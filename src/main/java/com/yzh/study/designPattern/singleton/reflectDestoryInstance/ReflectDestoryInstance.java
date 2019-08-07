package com.yzh.study.designPattern.singleton.reflectDestoryInstance;

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
	public static void main(String[] args) {
		Class instanceClazz = StaticInnerClassInstance.class;
		try {
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
