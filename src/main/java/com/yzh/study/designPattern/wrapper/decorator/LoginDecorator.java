package com.yzh.study.designPattern.wrapper.decorator;

import com.yzh.study.designPattern.wrapper.original.IOrginalLoginService;
import com.yzh.study.designPattern.wrapper.original.Result;

/**
 * @description: 装饰器，主 拓展，并且与被装饰的同宗同源
 * @author: HeroYang
 * @create: 2019-08-23 14:17
 **/
public class LoginDecorator implements IOrginalLoginService, LoginByThirdService {

	IOrginalLoginService orginalLoginService;

	public LoginDecorator(IOrginalLoginService orginalLoginService) {
		this.orginalLoginService = orginalLoginService;
	}

	private boolean check(String openId) {
		System.out.println("检测第三方登录是否符合标准,openId:" + openId);
		return true;
	}

	@Override
	public Result loginByWechat(String openId) {
		Result result = new Result("400", "通过微信登录失败");
		if (check(openId)) {
			String name = "Wechat" + openId;
			String pass = "Wechat" + openId;
			result = registerAndLogin(name, pass);
		}
		return result;
	}

	@Override
	public Result loginByQQ(String openId) {
		Result result = new Result("400", "通过QQ登录失败");
		if (check(openId)) {
			String name = "QQ" + openId;
			String pass = "QQ" + openId;
			result = registerAndLogin(name, pass);
		}
		return result;
	}

	@Override
	public Result loginByBlog(String openId) {
		Result result = new Result("400", "通过blog登录失败");
		if (check(openId)) {
			String name = "blog" + openId;
			String pass = "blog" + openId;
			result = registerAndLogin(name, pass);
		}
		return result;
	}

	@Override
	public Result register(String name, String pass) {
		return orginalLoginService.register(name, pass);
	}

	@Override
	public Result login(String name, String pass) {
		return orginalLoginService.login(name, pass);
	}

	@Override
	public Result registerAndLogin(String name, String pass) {
		return orginalLoginService.registerAndLogin(name, pass);
	}
}
