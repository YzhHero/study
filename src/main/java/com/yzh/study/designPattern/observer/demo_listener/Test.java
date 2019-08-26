package com.yzh.study.designPattern.observer.demo_listener;

import com.yzh.study.designPattern.observer.demo_listener.common.ISubject;
import com.yzh.study.designPattern.observer.demo_listener.common.Util;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-25 17:34
 **/
public class Test {



	public static void main(String[] args) {
		SubjectListener subjectListener = new SubjectListener();
		Observer observer = new Observer();
		try {
			//注册关联 被监听的方法，监听的方法
			subjectListener.registration(Util.getMethodKey(Subject.class.getMethod("query")),new Event("观察查询的事件",observer,observer.getClass().getMethod("adviceLow",new Class[]{Event.class})));
			subjectListener.registration(Util.getMethodKey(Subject.class.getMethod("del")),new Event("观察删除的事件",observer,observer.getClass().getMethod("adviceHigh",new Class[]{Event.class})));
			subjectListener.registration(Util.getMethodKey(Subject.class.getMethod("add")),new Event("观察增加的事件",observer,observer.getClass().getMethod("adviceHigh",new Class[]{Event.class})));
			subjectListener.registration(Util.getMethodKey(Subject.class.getMethod("update")),new Event("观察修改的事件",observer,observer.getClass().getMethod("adviceHigh",new Class[]{Event.class})));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		ISubject subjectProxy = new SubjectProxy().bind(new Subject(),subjectListener);
		subjectProxy.add();
		subjectProxy.del();
		subjectProxy.update();
		subjectProxy.query();
	}
}
