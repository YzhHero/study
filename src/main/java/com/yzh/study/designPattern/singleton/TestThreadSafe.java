package com.yzh.study.designPattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 测试线程安全抽象类
 * @author: HeroYang
 * @create: 2019-08-05 15:39
 **/
public abstract class TestThreadSafe {

	public abstract MyThread getMyThread(CountDownLatch countDownLatch);

	//此处用到了模板模式，定义流程，getMyThread延时加载
	public final void testSafe(int cycleNum,String singletonType){
		CountDownLatch countDownLatch = new CountDownLatch(cycleNum);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i <cycleNum ; i++) {
			MyThread myThread = getMyThread(countDownLatch);
			myThread.start();
		}
		try {
			// 阻塞当前线程，直到倒数计数器倒数到0
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(cycleNum+"个线程【"+singletonType+"】获取单例，总耗时为："+(endTime - startTime)+" ms .");
	}
}
