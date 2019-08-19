package com.yzh.study.designPattern.template.improve;

import com.yzh.study.designPattern.template.UserDao;
import com.yzh.study.designPattern.template.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-15 17:27
 **/
public class UserDaoImpl implements UserDao {

	private JdbcTemplateImprove jdbcTemplateImprove;

	@Override
	public List<UserEntity> getUserList(){
		String sql = "select * from user";
		return (List<UserEntity>) jdbcTemplateImprove.executeQuery(sql, new RowMap<UserEntity>() {
			@Override
			public UserEntity processResult(ResultSet rs) throws SQLException {
				UserEntity userEntity = new UserEntity();
				userEntity.setUserName(rs.getString("userName"));
				userEntity.setUserPass(rs.getString("userPass"));
				userEntity.setStatus(rs.getInt("status"));
				return userEntity;
			}
		});
	}
}
