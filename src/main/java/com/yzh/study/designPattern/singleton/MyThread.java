package com.yzh.study.designPattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-05 16:20
 **/
public abstract class MyThread extends Thread {

	//倒数计时器，可让主线程等待所有子线程并发执行完
	private CountDownLatch countDownLatch;

	public MyThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	protected abstract void getInstance();

	@Override
	public void run() {
		//获取单例，并打印相应的线程名和对象hashCode
		getInstance();
		countDownLatch.countDown();
	}
}
