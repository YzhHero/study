package com.yzh.study.designPattern.wrapper.Adapter;

import com.yzh.study.designPattern.wrapper.original.IOrginalLoginService;
import com.yzh.study.designPattern.wrapper.original.OrginalLoginService;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-23 15:08
 **/
public class TestAdapter {
	public static void main(String[] args) {
		/**
		 * 适配器，兼容
		 */
		IOrginalLoginService orginalLoginService = new OrginalLoginService();
		RegisterAdapter registerAdapter = new RegisterAdapter(orginalLoginService);
		System.out.println("========原来的注册方式===========");
		registerAdapter.register("user","12345",RegisterEnum.NAME_AND_PASS);
		System.out.println("=========适配手机的注册方式==========");
		registerAdapter.register("17688928929","675212",RegisterEnum.PHONENUM);
	}
}
