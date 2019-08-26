package com.yzh.study.designPattern.observer.demo_listener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Method;

/**
 * @description: 事件
 * @author: HeroYang
 * @create: 2019-08-23 17:44
 **/
@Getter
@Setter
@ToString
public class Event {

	public Event(String eventName, Object observer, Method observerMethod) {
		this.eventName = eventName;
		this.observer = observer;
		this.observerMethod = observerMethod;
	}

	//事件名
	private String eventName;

	//单事件观察者
	private Object observer;

	//单事件观察者方法
	private Method observerMethod;
}
