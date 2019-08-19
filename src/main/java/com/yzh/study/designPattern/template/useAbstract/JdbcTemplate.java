package com.yzh.study.designPattern.template.useAbstract;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 使用抽象类来实现JdbcTemplate
 * @author: HeroYang
 * @create: 2019-08-15 15:07
 **/
public abstract class JdbcTemplate {

	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 抽象方法 -- 解析结果集
	 */
	public abstract Object processResult(ResultSet rs) throws SQLException;

	/**
	 * 获取连接
	 */
	private Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

	/**
	 * 获取语句集
	 */
	private PreparedStatement getPrepareStatement(Connection connection,String sql) throws SQLException {
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
	private void processResult(ResultSet rs,List<Object> objects) throws SQLException {
		while (rs.next()){
			Object obj = processResult(rs);
			objects.add(obj);
		}
	}

	//定义总流程,使用final修饰
	public final List<?> executeQuery(String sql) {
		List<Object> objects = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			//1、获取连接
			connection = getConnection();
			//2、创建语句集
			preparedStatement =getPrepareStatement(connection,sql);
			//3、执行语句集，并获得结果集
			rs = getResultSet(preparedStatement);
			//4、解析结果集
			processResult(rs,objects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//5、关闭结果集
				if (rs != null) {
					rs.close();
				}
				//6、关闭语句集
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				//7、关闭连接
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objects;
	}

}
