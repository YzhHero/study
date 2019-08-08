package com.yzh.study.designPattern.singleton.enumSingleton;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 枚举单例线程
 * @author: HeroYang
 * @create: 2019-08-08 17:45
 **/
public class EnumSingletonThread extends MyThread {

	public EnumSingletonThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		EnumSingleton instance = EnumSingleton.INSTANCE;
		System.out.println(this.getName()+":"+System.currentTimeMillis()+":"+instance.hashCode());
	}
}
