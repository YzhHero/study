package com.yzh.study.designPattern.singleton.lazy.threadUnsafe;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 非线程安全测试
 * @author: HeroYang
 * @create: 2019-08-05 15:15
 **/
public class Test extends TestThreadSafe {


	public static void main(String[] args) {
		TestThreadSafe test = new Test();
		test.testSafe(1000,"非线程安全懒汉式");
	}

	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new LazyThread(countDownLatch);
	}
}
