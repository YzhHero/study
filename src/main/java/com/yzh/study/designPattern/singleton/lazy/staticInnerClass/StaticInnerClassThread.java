package com.yzh.study.designPattern.singleton.lazy.staticInnerClass;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-05 21:49
 **/
public class StaticInnerClassThread extends MyThread {

	public StaticInnerClassThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		StaticInnerClassInstance instance = StaticInnerClassInstance.getInstance();
		System.out.println(this.getName() + ":" + System.currentTimeMillis() + ":" + instance.hashCode());
	}
}
