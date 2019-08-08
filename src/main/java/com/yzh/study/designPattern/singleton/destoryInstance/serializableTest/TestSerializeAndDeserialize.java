package com.yzh.study.designPattern.singleton.destoryInstance.serializableTest;

import java.io.*;

/**
 * @program: data-analysis
 * @description: 测试序列化和反序列化
 * @author: HeroYang
 * @create: 2019-08-08 15:46
 **/
public class TestSerializeAndDeserialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		MyObj obj =new MyObj();
		obj.setName("测试序列化");
		obj.setValue(123);
		System.out.println("序列化前的对象(值)："+obj.toString()+",hashcode:"+obj.hashCode());
		String filePath ="D://serialize";
		//序列化对象到文件中
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.close();
		//反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
		MyObj objDe = (MyObj) ois.readObject();
		ois.close();

		System.out.println("序列化后的对象(值)："+objDe.toString()+",hashcode:"+objDe.hashCode());
	}

}
