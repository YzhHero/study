package com.yzh.study.designPattern.observer.demo_listener;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 监听器
 * @author: HeroYang
 * @create: 2019-08-23 17:41
 **/
public class SubjectListener {

	//事件注册表
	private static Map<String, Event> eventMap = new HashMap<>();

	public void registration(String methodName, Event event) {
		eventMap.put(methodName, event);
	}

	public void trigger(String methodName) {
		Event event = eventMap.get(methodName);
		Object observer = event.getObserver();
		try {
			event.getObserverMethod().invoke(observer, event);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
