package com.yzh.study.designPattern.adapter.original;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-21 15:14
 **/
@Setter
@ToString
@Getter
public class Result {

	private String rescode;

	private String resMsg;

	public Result(String rescode, String resMsg) {
		this.rescode = rescode;
		this.resMsg = resMsg;
	}
}
