package com.yzh.study.designPattern.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-analysis
 * @description: 深拷贝
 * @author: HeroYang
 * @create: 2019-08-12 10:44
 **/
@Getter
@Setter
@ToString
public class DeepCloneTarget implements Cloneable,Serializable{
	private String name;
	private int value;
	private List<String> list;
	private Obj obj;

	/**
	 * 深拷贝实现1：在clone中对引用类型的属性一一clone
	 * 缺点：1、需要自己一个一个处理
	 * 		2、对于List这种属性，未实现cloneable（实现类ArrayList实现了），不方便clone
	 */
	protected Object deepClone1() throws CloneNotSupportedException {
		DeepCloneTarget deepCloneTarget = (DeepCloneTarget) super.clone();
//		deepCloneTarget.setList((List<String>) ((ArrayList<String>)deepCloneTarget.getList()).clone());
		deepCloneTarget.setObj((Obj) deepCloneTarget.getObj().clone());
		return deepCloneTarget;
	}

	/**
	 * 深拷贝实现2：在clone的时候，将原对象转成字节码，然后再转换出来，这里所有的引用对象的属性都是新建的，不存在引用共享的问题，引用类均需
	 * 实现序列化
	 */
	protected <T extends Serializable>T deepClone2(T obj) throws CloneNotSupportedException {
		T cloneSource =null;
		try {
			//写入字节流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.close();
			//存字节流里取出
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			cloneSource = (T) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cloneSource;
	}

	public static void main(String[] args) {
		DeepCloneTarget copyTarget = new DeepCloneTarget();
		copyTarget.setName("测试浅拷贝");
		copyTarget.setValue(1);
		List<String> testList =new ArrayList<String>();
		testList.add("测试列表1");
		testList.add("测试列表2");
		copyTarget.setList(testList);
		Obj obj =new Obj();
		copyTarget.setObj(obj);
		try {
//			DeepCloneTarget copySource = (DeepCloneTarget) copyTarget.deepClone1();
			DeepCloneTarget copySource = (DeepCloneTarget) copyTarget.deepClone2(copyTarget);
			System.out.println(copySource.toString());
			System.out.println("list属性是否相同："+(copySource.getList() == copyTarget.getList())+",obj属性是否相同"+(copySource.getObj() == copyTarget.getObj()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
