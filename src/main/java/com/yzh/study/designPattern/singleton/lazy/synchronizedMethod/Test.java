package com.yzh.study.designPattern.singleton.lazy.synchronizedMethod;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 测试加上synchronized方法的懒加载单例
 * @author: HeroYang
 * @create: 2019-08-05 16:31
 **/
public class Test extends TestThreadSafe{

	public static void main(String[] args) {
		Test test = new Test();
		test.testSafe(1000,"懒加载，获取单例加上synchronized方法");
	}

	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new LazySyncThread(countDownLatch);
	}
}
