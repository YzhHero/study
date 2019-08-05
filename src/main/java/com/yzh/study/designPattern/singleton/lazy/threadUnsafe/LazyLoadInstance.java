package com.yzh.study.designPattern.singleton.lazy.threadUnsafe;

/**
 * @program: data-analysis
 * @description: 懒汉式获取单例
 * @author: HeroYang
 * @create: 2019-08-05 15:08
 * 缺点：线程不安全
 * 优点：懒加载，节约内存
 **/
public class LazyLoadInstance {

	private static LazyLoadInstance lazyLoadInstance;

	private LazyLoadInstance() {
	}

	public static LazyLoadInstance getInstance() {
		if (lazyLoadInstance == null){
			lazyLoadInstance = new LazyLoadInstance();
		}
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return lazyLoadInstance;
	}
}
