package com.yzh.study.designPattern.singleton.destoryInstance;

import com.yzh.study.designPattern.singleton.enumSingleton.EnumSingleton;
import lombok.Setter;

import java.io.*;

/**
 * @program: data-analysis
 * @description: 序列化反序列化破坏单例
 * @author: HeroYang
 * @create: 2019-08-08 14:47
 **/
@Setter
public class SerializableDestoryInstance {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		StaticInnerClassInstance instance = StaticInnerClassInstance.getInstance();
		EnumSingleton instance = EnumSingleton.INSTANCE;
		String filePath = "D://serialize";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(instance);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
		//通过重写readResolve来保证单例
//		StaticInnerClassInstance deInstance = (StaticInnerClassInstance) ois.readObject();
		//枚举保证序列化
		EnumSingleton deInstance = (EnumSingleton) ois.readObject();

		System.out.println("序列化前的hashcode:" + instance.hashCode() + ",序列化后的hashcode：" + deInstance.hashCode());

	}
}
