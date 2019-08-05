package com.yzh.study.designPattern.singleton.lazy.doubleCheck;

import com.yzh.study.designPattern.singleton.MyThread;
import com.yzh.study.designPattern.singleton.TestThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 双重校验懒加载Test
 * @author: HeroYang
 * @create: 2019-08-05 20:50
 **/
public class Test extends TestThreadSafe {
	@Override
	public MyThread getMyThread(CountDownLatch countDownLatch) {
		return new DoubleCheckThread(countDownLatch);
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.testSafe(1000,"双重校验懒加载");
	}
}
