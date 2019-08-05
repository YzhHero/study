package com.yzh.study.designPattern.singleton.hungry;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 多线程测试饿汉式的线程安全和性能
 * @author: HeroYang
 * @create: 2019-08-05 14:33
 * 结果：
 * 		1、线程安全
 * 		2、性能较好
 **/
public class Test extends TestThreadSafe {

	public static void main(String[] args) {
		Test test = new Test();
		test.testSafe(1000,"饿汉式");
	}

	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new HungryThread(countDownLatch);
	}
}
