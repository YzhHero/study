package com.yzh.study.designPattern.singleton.enumSingleton;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-08 17:56
 **/
public class Test extends TestThreadSafe {
	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new EnumSingletonThread(countDownLatch);
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.testSafe(1000,"枚举单例");
	}
}
