package com.yzh.study.designPattern.template.improve;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 模板模式的改进用法，  接口作为参数，使用的时候延时实现
 * 		此处过程可以描述为回调，
 * 		接口参数描述为 回调对象，因为在处理结果集时，jdbcTemplateImprove需要借助 回调对象（接口rowMap）的processResult方法，
 * 		而实际processResult又会调用 jdbcTemplateImprove里匿名类复写的processResult（），实际是一个A调用B，B回调A的机制
 * 		回调机制帖子：https://www.cnblogs.com/heshuchao/p/5376298.html
 * @author: HeroYang
 * @create: 2019-08-15 15:07
 **/
public class JdbcTemplateImprove {

	private DataSource dataSource;

	public JdbcTemplateImprove(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取连接
	 */
	private Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

	/**
	 * 获取语句集
	 */
	private PreparedStatement getPrepareStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	/**
	 * 获取结果集
	 */
	private ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
		return preparedStatement.executeQuery();
	}

	/**
	 * 处理结果集
	 */
	private void processResult(ResultSet rs, List<Object> objects,RowMap<?> rowMap) throws SQLException {
		while (rs.next()) {
			Object obj = rowMap.processResult(rs);
			objects.add(obj);
		}
	}

	/**
	 * 关闭结果集
	 */
	private void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	/**
	 * 关闭语句集
	 */
	private void closeStatement(Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
		}
	}

	/**
	 * 关闭连接
	 */
	private void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	//定义总流程,使用final修饰
	public final List<?> executeQuery(String sql,RowMap rowMap) {
		List<Object> objects = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			//1、获取连接
			connection = getConnection();
			//2、创建语句集
			preparedStatement = getPrepareStatement(connection, sql);
			//3、执行语句集，并获得结果集
			rs = getResultSet(preparedStatement);
			//4、解析结果集
			processResult(rs, objects,rowMap);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//5、关闭结果集
				closeResultSet(rs);
				//6、关闭语句集
				closeStatement(preparedStatement);
				//7、关闭连接
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objects;
	}

}
