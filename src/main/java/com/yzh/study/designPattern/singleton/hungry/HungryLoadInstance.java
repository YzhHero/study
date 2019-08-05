package com.yzh.study.designPattern.singleton.hungry;

/**
 * @program: data-analysis
 * @description: 饿汉式获取单例
 * @author: HeroYang
 * @create: 2019-08-05 14:20
 * 优点：类加载时创建实例，避免线程安全的问题
 * 缺点：单例没有使用，仅是类被加载就已经创建，内存空间容易被浪费
 * 适用：单例占用内存较小时
 **/
public class HungryLoadInstance{

	private static final HungryLoadInstance instance = new HungryLoadInstance();

	//私有构造方法
	private HungryLoadInstance() {
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	public static HungryLoadInstance getInstance(){
		return instance;
	}

}
