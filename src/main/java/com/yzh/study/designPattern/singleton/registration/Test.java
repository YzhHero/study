package com.yzh.study.designPattern.singleton.registration;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-08 22:55
 **/
public class Test extends TestThreadSafe {

	public static void main(String[] args) {
		Test test = new Test();
		test.testSafe(1000,"注册登记");
	}

	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new RegistrationThread(countDownLatch);
	}
}
