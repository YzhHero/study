package com.yzh.study.designPattern.delegate.imitateSpringMVC.controller;

/**
 * @description: 模拟实际的Controller
 * @author: HeroYang
 * @create: 2019-08-21 10:15
 **/
public class UserController implements Controller {

	private final static UserController instance = new UserController();

	private UserController(){
	}

	public static UserController getInstance(){
		return instance;
	}

	public int addUser(){
		System.out.println("模拟 用户controller 新增操作");
		return 1;
	}

	public int updateUser(){
		System.out.println("模拟 用户controller 修改操作");
		return 1;
	}
}
