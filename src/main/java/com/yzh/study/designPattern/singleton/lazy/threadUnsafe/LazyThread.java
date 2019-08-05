package com.yzh.study.designPattern.singleton.lazy.threadUnsafe;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 测试线程安全的类
 * @author: HeroYang
 * @create: 2019-08-05 14:53
 **/
public class LazyThread extends MyThread {


	public LazyThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		LazyLoadInstance lazyLoadInstance = LazyLoadInstance.getInstance();
		System.out.println(this.getName() + ":" + System.currentTimeMillis() + ":" + lazyLoadInstance.hashCode());
	}

}