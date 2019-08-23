package com.yzh.study.designPattern.wrapper.original;

/**
 * @description: 模拟原有的系统登录实现
 * @author: HeroYang
 * @create: 2019-08-21 15:11
 **/
public class OrginalLoginService implements IOrginalLoginService {

	public Result register(String name, String pass) {
		System.out.println("老系统较为复杂的注册实现,用户名为：" + name + ",密码为：" + pass);
		return new Result("200", "注册成功");
	}

	public Result login(String name, String pass) {
		System.out.println("登录，用户名：" + name + ",密码：" + pass);
		return new Result("200", "登录成功");
	}

	@Override
	public Result registerAndLogin(String name, String pass) {
		register(name, pass);
		return login(name, pass);
	}
}
