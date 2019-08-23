package com.yzh.study.designPattern.wrapper.Adapter;

import com.yzh.study.designPattern.wrapper.original.IOrginalLoginService;
import com.yzh.study.designPattern.wrapper.original.Result;

/**
 * @description: 注册适配器
 * @author: HeroYang
 * @create: 2019-08-21 16:00
 * （1）继承来适配
 * （2）使用依赖注入（继承只能继承一个）
 *  适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
 *  例如：此处保留原有类的注册，并在注册上支持了手机的注册
 *
 *  适配 主要为了兼容 has-a，装饰 主要为了拓展 is-a TODO 在spring源码去理解，目前感觉区别不明显
 **/
public class RegisterAdapter{
	//假设这个是原有稳定不能改动的
	IOrginalLoginService orginalLoginService;

	public RegisterAdapter(IOrginalLoginService orginalLoginService) {
		this.orginalLoginService = orginalLoginService;
	}

	private String generatePassWord(String phoneNum) {
		//模拟生成密码
		String passWord = phoneNum + "@pass";
		return passWord;
	}

	//模拟验证验证码
	private boolean checkCode(String phoneNum, String code) {
		return true;
	}

	private Result registerByPhone(String phoneNum, String code) {
		Result result = new Result("reg_fail", "注册失败");
		if (checkCode(phoneNum, code)) {
			result = orginalLoginService.register(phoneNum, generatePassWord(phoneNum));
		}
		return result;
	}

	/**
	 * 适配的注册
	 * @param nameOrPhone
	 * @param passOrCode
	 * @param type
	 * @return
	 */
	public Result register(String nameOrPhone, String passOrCode,RegisterEnum type) {
		Result result = new Result("reg_fail", "注册失败");
		switch (type){
		case PHONENUM:
			registerByPhone(nameOrPhone,passOrCode);
			break;
		case NAME_AND_PASS:
			orginalLoginService.register(nameOrPhone,passOrCode);
			break;
		}
		return result;
	}

}
