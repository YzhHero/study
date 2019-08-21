package com.yzh.study.designPattern.adapter;

import com.yzh.study.designPattern.adapter.original.OrginalLoginServiceImpl;
import com.yzh.study.designPattern.adapter.original.Result;

/**
 * @description: 登录适配器
 * @author: HeroYang
 * @create: 2019-08-21 16:00
 * （1）除了继承来适配
 * （2）还可以使用依赖注入（继承只能继承一个）
 **/
public class LoginAdapter extends OrginalLoginServiceImpl implements LoginByThirdService {

	@Override
	public boolean check(String openId) {
		System.out.println("检测第三方登录是否符合标准,openId:"+openId);
		return true;
	}

	@Override
	public Result loginByWechat(String openId) {
		Result result = new Result("400","通过微信登录失败");
		if (check(openId)){
			String name = "Wechat"+openId;
			String pass = "Wechat"+openId;
			result = super.registerAndLogin(name,pass);
		}
		return result;
	}

	@Override
	public Result loginByQQ(String openId) {
		Result result = new Result("400","通过QQ登录失败");
		if (check(openId)){
			String name = "QQ"+openId;
			String pass = "QQ"+openId;
			result = super.registerAndLogin(name,pass);
		}
		return result;
	}

	@Override
	public Result loginByBlog(String openId) {
		Result result = new Result("400","通过微博登录失败");
		if (check(openId)){
			String name = "Blog"+openId;
			String pass = "Blog"+openId;
			result = super.registerAndLogin(name,pass);
		}
		return result;
	}
}
