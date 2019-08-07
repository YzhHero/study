package com.yzh.study.designPattern.singleton.lazy.staticInnerClass;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-05 21:52
 **/
public class Test extends TestThreadSafe {
	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new StaticInnerClassThread(countDownLatch);
	}

	public static void main(String[] args) {
		Test test =new Test();
		test.testSafe(1000,"静态内部类");
	}
}
