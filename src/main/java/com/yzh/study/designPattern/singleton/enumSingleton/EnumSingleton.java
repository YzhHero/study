package com.yzh.study.designPattern.singleton.enumSingleton;

/**
 * 枚举序列化是由jvm保证的，每一个枚举类型和定义的枚举变量在JVM中都是唯一的
 *我的理解：一种线程安全，天然支持序列化反序列化的 一种饿汉式
 */
public enum EnumSingleton {
	INSTANCE("单例", 1), INSTANCE2("单例2", 2);
	private String name;
	private int value;

	EnumSingleton(String name, int value) {
		this.name = name;
		this.value = value;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
