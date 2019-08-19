package com.yzh.study.designPattern.template.useAbstract;

import com.yzh.study.designPattern.template.UserDao;
import com.yzh.study.designPattern.template.UserEntity;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:使用抽象类来实现JdbcTemplate
 * @author: HeroYang
 * @create: 2019-08-15 16:41
 **/

/**
 * 实际场景并没有这么继承，缺点：
 * 1、这样有耦合，父子关系，必须继承构造方法，实际Dao层不需要管Datasource
 * 2、若这个类有许多方法需要实现，而实际用不着
 * 改进版：请看 ./improve
 */
public class UserDaoImpl extends JdbcTemplate implements UserDao {

	public UserDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Object processResult(ResultSet rs) throws SQLException {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(rs.getString("userName"));
		userEntity.setUserPass(rs.getString("userPass"));
		userEntity.setStatus(rs.getInt("status"));
		return userEntity;
	}

	public List<UserEntity> getUserList(){
		String sql = "select * from user";
		List<UserEntity> userList = (List<UserEntity>) super.executeQuery(sql);
		return userList;
	}
}
