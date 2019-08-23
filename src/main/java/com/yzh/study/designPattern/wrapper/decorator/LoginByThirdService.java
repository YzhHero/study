package com.yzh.study.designPattern.wrapper.decorator;

import com.yzh.study.designPattern.wrapper.original.Result;

public interface LoginByThirdService{

	public Result loginByWechat(String openId);

	public Result loginByQQ(String openId);

	public Result loginByBlog(String openId);

}
