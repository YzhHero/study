package com.yzh.study.designPattern.adapter;

import com.yzh.study.designPattern.adapter.original.Result;

public interface LoginByThirdService{

	public boolean check(String openId);

	public Result loginByWechat(String openId);

	public Result loginByQQ(String openId);

	public Result loginByBlog(String openId);

}
