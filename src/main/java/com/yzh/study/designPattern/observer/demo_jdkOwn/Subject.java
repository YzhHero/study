package com.yzh.study.designPattern.observer.demo_jdkOwn;

import java.util.Observable;

/**
 * @description: 用jdk自带实现的主体
 * @author: HeroYang
 * @create: 2019-08-26 10:33
 **/
public class Subject extends Observable {

	public void action(){
		System.out.println("主体动作");
		setChanged();
//		notifyObservers();
		notifyObservers("带参通知");
	}
}
