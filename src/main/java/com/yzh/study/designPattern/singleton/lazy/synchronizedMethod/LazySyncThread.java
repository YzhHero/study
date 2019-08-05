package com.yzh.study.designPattern.singleton.lazy.synchronizedMethod;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 懒加载改造，线程安全
 * @author: HeroYang
 * @create: 2019-08-05 16:18
 **/
public class LazySyncThread extends MyThread {

	public LazySyncThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		SynchronizedLazyLoad synchronizedLazyLoad = SynchronizedLazyLoad.getInstance();
		System.out.println(this.getName() + ":" + System.currentTimeMillis() + ":" + synchronizedLazyLoad.hashCode());
	}

}
