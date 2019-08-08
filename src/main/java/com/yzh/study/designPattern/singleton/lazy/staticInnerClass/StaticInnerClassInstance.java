package com.yzh.study.designPattern.singleton.lazy.staticInnerClass;

import java.io.Serializable;

/**
 * @program: data-analysis
 * @description: 静态内部类获取单例
 * @author: HeroYang
 * @create: 2019-08-05 21:45
 * 优点：1、通过类加载机制保证只创建一个实例
 * 		2、内部类创建实例，只要JVM不加载这个单例类，就不会创建单例对象（加载一个类时，其内部类不会同时被加载）
 **/
public class StaticInnerClassInstance implements Serializable {

	private static boolean initialized = false;

	private StaticInnerClassInstance() {
		//防止多线程反射获取,但还是可以被修改【initialized】来绕过
		synchronized (StaticInnerClassInstance.class) {
			if (!initialized) {
				initialized = true;
			} else {
				throw new RuntimeException("创建了两个实例");
			}
		}
	}

	//通过重写readResolve来保证单例
	private Object readResolve(){
		return SingletonHolder.instance;
	}

	private static class SingletonHolder {
		public static StaticInnerClassInstance instance = new StaticInnerClassInstance();
	}

	public static StaticInnerClassInstance getInstance() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SingletonHolder.instance;
	}

}
