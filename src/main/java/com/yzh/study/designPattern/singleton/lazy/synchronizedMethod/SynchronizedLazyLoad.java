package com.yzh.study.designPattern.singleton.lazy.synchronizedMethod;

/**
 * @program: data-analysis
 * @description: 获取单例方法加上synchronized
 * @author: HeroYang
 * @create: 2019-08-05 16:14\
 * 优点：懒加载
 * 缺点：synchronized方式加到了方法上，性能较差
 **/
public class SynchronizedLazyLoad {

	private static SynchronizedLazyLoad synchronizedLazyLoad;

	private SynchronizedLazyLoad() {
	}

	public synchronized static SynchronizedLazyLoad getInstance() {
		if (synchronizedLazyLoad == null) {
			synchronizedLazyLoad = new SynchronizedLazyLoad();
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return synchronizedLazyLoad;
	}
}
