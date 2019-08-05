package com.yzh.study.designPattern.singleton;

import com.yzh.study.designPattern.singleton.hungry.HungryLoadInstance;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 测试在外部countDown
 * @author: HeroYang
 * @create: 2019-08-05 15:57
 **/
public class TestCountDownThreadOut {
	public static void main(String[] args) {
		int cycleNum =100;
		CountDownLatch countDownLatch = new CountDownLatch(cycleNum);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < cycleNum; i++) {
			new Thread(){
				@Override
				public void run() {
					HungryLoadInstance hungryLoadInstance = HungryLoadInstance.getInstance();
					System.out.println(this.getName()+":"+System.currentTimeMillis()+":"+hungryLoadInstance.hashCode());
				}
			}.start();
			// 这里countdown完，子线程也不一定全部执行完
			countDownLatch.countDown();
		}
		try {
			// 阻塞当前线程，直到倒数计数器倒数到0
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(cycleNum + "个线程【饿汉式】获取单例，总耗时为：" + (endTime - startTime) + " ms .");
	}
}
