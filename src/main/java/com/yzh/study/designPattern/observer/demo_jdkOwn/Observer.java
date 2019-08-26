package com.yzh.study.designPattern.observer.demo_jdkOwn;

import java.util.Observable;

/**
 * @description: 用jdk自带实现的观察者
 * @author: HeroYang
 * @create: 2019-08-26 10:32
 **/
public class Observer implements java.util.Observer {

	public Observer(String name) {
		this.name = name;
	}

	private  String name;

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(this.name+"观察者知道 主体动作 了"+arg);
	}
}
