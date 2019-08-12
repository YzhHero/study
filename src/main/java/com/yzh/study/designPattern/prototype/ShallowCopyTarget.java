package com.yzh.study.designPattern.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-analysis
 * @description: 浅复制
 * @author: HeroYang
 * @create: 2019-08-12 10:13
 * 1、被复制的对象必须实现Cloneable接口
 * 2、浅复制对于引用类型的属性，是复制它的地址，这样实际是同一引用，被复制的修改也会影响原来的数据
 **/
@Setter
@Getter
@ToString
public class ShallowCopyTarget implements Cloneable{
	private String name;
	private int value;
	private List<String> list;
	private Obj obj;

	public static void main(String[] args) {
		ShallowCopyTarget copyTarget = new ShallowCopyTarget();
		copyTarget.setName("测试浅拷贝");
		copyTarget.setValue(1);
		List<String> testList =new ArrayList<String>();
		testList.add("测试列表1");
		testList.add("测试列表2");
		copyTarget.setList(testList);
		Obj obj =new Obj();
		copyTarget.setObj(obj);

		try {
			ShallowCopyTarget copySource = (ShallowCopyTarget) copyTarget.clone();
			copySource.getList().add("测试列表3");
			System.out.println(copySource.toString());
			System.out.println("copyTarget hashCode:"+copyTarget.hashCode()+",copySource hashCode:"+copySource.hashCode());
			System.out.println(copyTarget.getList().hashCode()+","+copySource.getList().hashCode());
			System.out.println(copyTarget.getObj().hashCode()+","+copySource.getObj().hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class Obj implements Cloneable, Serializable {
	private String name;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}