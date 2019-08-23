package com.yzh.study.designPattern.wrapper.decorator;

import com.yzh.study.designPattern.wrapper.original.IOrginalLoginService;
import com.yzh.study.designPattern.wrapper.original.OrginalLoginService;

/**
 * @description: 测试装饰者
 * @author: HeroYang
 * @create: 2019-08-23 15:43
 **/
public class TestDecorator {
	public static void main(String[] args) {
		IOrginalLoginService orginalLoginService = new OrginalLoginService();
		LoginDecorator loginDecorator = new LoginDecorator(orginalLoginService);
		System.out.println("=======原来的方式注册登录=====");
		System.out.println(loginDecorator.registerAndLogin("user","123456"));
		System.out.println("=======拓展的第三方 注册登录=====");
		System.out.println(loginDecorator.loginByWechat("jkljksd123@123"));
	}
}
