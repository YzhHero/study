package com.yzh.study.designPattern.singleton.registration;

import com.yzh.study.designPattern.singleton.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-09 10:55
 **/
public class RegistrationThread extends MyThread {
	public RegistrationThread(CountDownLatch countDownLatch) {
		super(countDownLatch);
	}

	@Override
	protected void getInstance() {
		try {
			RegistrationSingleton subInstance = SubRegistrationSingleton.getInstance(SubRegistrationSingleton.class.getName());
			System.out.println(this.getName() + ":" + System.currentTimeMillis() + ":" + subInstance.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
