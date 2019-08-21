package com.yzh.study.designPattern.adapter;

/**
 * @description: 适配器测试
 * @author: HeroYang
 * @create: 2019-08-21 16:25
 **/
public class Test {

	public static void main(String[] args) {
		/**
		 * 适配器，兼容，一个adapter既可以使用原来的方法，也可以使用新拓展的方法
		 */
		LoginAdapter loginAdapter = new LoginAdapter();
		System.out.println("========适配原来的登录方式===========");
		loginAdapter.login("老用户","123456");
		System.out.println("=========适配拓展的登录方式==========");
		loginAdapter.loginByWechat("jklisjyuiqw@y123uio");
	}
}
