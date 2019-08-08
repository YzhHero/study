package com.yzh.study.designPattern.singleton.destoryInstance.serializableTest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: data-analysis
 * @description: 待被序列化的对象
 * @author: HeroYang
 * @create: 2019-08-08 15:15
 **/
@Setter
@Getter
@ToString
public class MyObj implements Serializable {

	private static final long serialVersionUID = 3887959761537933973L;

	private String name;

	//transient表示不被序列化
	private transient int value;

//	public Object readResolve(){
//		return null;
//	}
}
