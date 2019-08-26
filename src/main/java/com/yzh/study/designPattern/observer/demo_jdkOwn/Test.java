package com.yzh.study.designPattern.observer.demo_jdkOwn;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-26 10:38
 **/
public class Test {
	public static void main(String[] args) {
		Observer observer1 = new Observer("观察者1号");
		Observer observer2 = new Observer("观察者2号");
		Observer observer3 = new Observer("观察者3号");
		Subject subject = new Subject();
		subject.addObserver(observer1);
		subject.addObserver(observer2);
		subject.addObserver(observer3);
		subject.action();
	}
}
