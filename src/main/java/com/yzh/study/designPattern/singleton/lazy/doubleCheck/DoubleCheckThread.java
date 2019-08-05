package com.yzh.study.designPattern.singleton.lazy.doubleCheck;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description: 双重校验懒加载
 * @author: HeroYang
 * @create: 2019-08-05 19:23
 **/
public class DoubleCheckThread extends MyThread {

	public DoubleCheckThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		DoubleCheckInstance instance =DoubleCheckInstance.getInstance();
		System.out.println(this.getName() + ":" + System.currentTimeMillis() + ":" + instance.hashCode());
	}
}
