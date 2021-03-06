package com.yzh.study.designPattern.wrapper.original;

/**
 * @description: 模拟原有的系统登录接口
 * @author: HeroYang
 * @create: 2019-08-21 15:11
 **/
public interface IOrginalLoginService {

	public Result register(String name, String pass);

	public Result login(String name, String pass);

	public Result registerAndLogin(String name, String pass);
}
