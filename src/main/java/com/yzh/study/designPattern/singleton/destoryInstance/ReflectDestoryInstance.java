package com.yzh.study.designPattern.singleton.destoryInstance;

import com.yzh.study.designPattern.singleton.enumSingleton.EnumSingleton;
import com.yzh.study.designPattern.singleton.lazy.staticInnerClass.StaticInnerClassInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 反射破坏单例
 * @author: HeroYang
 * @create: 2019-08-06 21:30
 **/
public class ReflectDestoryInstance {
	public static void main(String[] args) throws NoSuchMethodException {
//		DestoryInnerClassInstance();
		DestoryEnumInstance();
	}

	/**
	 * 反射破坏枚举测试
	 * @throws NoSuchMethodException
	 */
	private static void DestoryEnumInstance() throws NoSuchMethodException {
		Class instanceClazz = EnumSingleton.class;
//		Constructor[] constructors = instanceClazz.getDeclaredConstructors();
//		for (Constructor constructor : constructors) {
//			System.out.println("1");
//		}
		//枚举默认的构造函数就带String和int，String是记录实例名字,int是记录下标
		Constructor<EnumSingleton> constructor = instanceClazz.getDeclaredConstructor(String.class,int.class,String.class,int.class);
		constructor.setAccessible(true);
		EnumSingleton enumSingleton = null;
		try {
			//java.lang.IllegalArgumentException: Cannot reflectively create enum objects
			//无法使用反射创建枚举实例,newInstance有判断，是枚举就抛出上面这个错
			enumSingleton = constructor.newInstance("测试反射枚举",321);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(enumSingleton);
	}

	private static void DestoryInnerClassInstance(){
		Class instanceClazz = StaticInnerClassInstance.class;
		try {
			//破坏 静态内部类的单例
			StaticInnerClassInstance instance2 = StaticInnerClassInstance.getInstance();
			System.out.println("instance2:"+instance2.hashCode());
			/**
			 * 通过反射  修改私有变量，来绕过只允许实例一次
			 */
			Field field = instanceClazz.getDeclaredField("initialized");
			field.setAccessible(true);
			field.set(instance2,false);
			/**
			 * 可以通过获取声明的构造方法，加上setAccessible(true)，来反射获取
			 */
			Constructor constructor = instanceClazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			StaticInnerClassInstance instance1 = (StaticInnerClassInstance) constructor.newInstance();
			System.out.println("instance1："+instance1.hashCode());
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
