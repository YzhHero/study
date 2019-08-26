package com.yzh.study.designPattern.observer.demo_listener;

import com.yzh.study.designPattern.observer.demo_listener.common.ISubject;

/**
 * @description: 被观察的主体
 * @author: HeroYang
 * @create: 2019-08-23 17:36
 **/
public class Subject implements ISubject {

	public void add(){
		System.out.println("被观察的主体--增加动作");
	}

	public void add(String a){
		System.out.println("被观察的主体--增加动作");
	}

	public void del(){
		System.out.println("被观察的主体--删除动作");
	}

	public void update(){
		System.out.println("被观察的主体--修改动作");
	}

	public void query(){
		System.out.println("被观察的主体--查询动作");
	}
}
