package com.yzh.study.designPattern.observer.demo_listener;

/**
 * @description: 观察者
 * @author: HeroYang
 * @create: 2019-08-25 17:18
 **/
public class Observer {

	public void adviceLow(Event event){
		System.out.println("【低级别观察】观察者观察到了【"+event.getEventName()+"】事件");
	}

	public void adviceHigh(Event event){
		System.out.println("【高级别观察】观察者观察到了【"+event.getEventName()+"】事件");
	}
}
