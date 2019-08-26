package com.yzh.study.designPattern.observer.demo_listener;

import com.yzh.study.designPattern.observer.demo_listener.common.ISubject;
import com.yzh.study.designPattern.observer.demo_listener.common.Util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 被观察主体的代理类，除了代理主体，还加入了监听器
 * @author: HeroYang
 * @create: 2019-08-25 18:09
 **/
public class SubjectProxy implements InvocationHandler {

	//加入监听器
	SubjectListener subjectListener;

	Subject target;

	public ISubject bind(Subject target,SubjectListener subjectListener){
		this.target = target;
		this.subjectListener = subjectListener;
		return (ISubject) Proxy.newProxyInstance(Subject.class.getClassLoader(),Subject.class.getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(target,args);
		//代理方法后，开始触发 监听的方法
		subjectListener.trigger(Util.getMethodKey(method));
		return result;
	}

}
