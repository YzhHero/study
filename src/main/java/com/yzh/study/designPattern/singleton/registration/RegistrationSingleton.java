package com.yzh.study.designPattern.singleton.registration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: data-analysis
 * @description: 登记注册式单例
 * @author: HeroYang
 * @create: 2019-08-08 19:11
 *  登记式单例实际上维护的是一组单例类的实例，将这些实例存储到一个Map(登记簿)
 *  中，对于已经登记过的单例，则从工厂直接返回，对于没有登记的，则先登记，而后
 *  返回
 *  个人理解：枚举也是注册登记，只不过是一开始全在登记进去了
 *  另外IOC就是用的这个
 **/
//个人理解这是个 父类
public class RegistrationSingleton {
	private static Map<String, RegistrationSingleton> registrationMap = new ConcurrentHashMap<>();

	protected RegistrationSingleton(){}

	static {
		RegistrationSingleton registrationSingleton = new RegistrationSingleton();
		//先登记父类进去
		registrationMap.put(registrationSingleton.getClass().getName(),registrationSingleton);
	}

	public static RegistrationSingleton getInstance(String name)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
		Thread.sleep(10);
		if (name == null) {
			//默认为获取父类
			name = RegistrationSingleton.class.getName();
		}
		if (registrationMap.get(name) == null){
			registrationMap.put(name, (RegistrationSingleton) Class.forName(name).newInstance());
		}
		return registrationMap.get(name);
	}
}
