package com.yzh.study.designPattern.singleton.hungry;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 测试线程安全的类
 * @author: HeroYang
 * @create: 2019-08-05 14:53
 **/
public class HungryThread extends MyThread {

	//构造的时候，传入countDownLatch
	public HungryThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	//不同的Thread获取的实例方法的实现
	@Override
	protected void getInstance() {
		HungryLoadInstance hungryLoadInstance = HungryLoadInstance.getInstance();
		System.out.println(this.getName()+":"+System.currentTimeMillis()+":"+hungryLoadInstance.hashCode());
	}

}