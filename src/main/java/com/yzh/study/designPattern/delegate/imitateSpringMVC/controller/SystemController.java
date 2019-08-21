package com.yzh.study.designPattern.delegate.imitateSpringMVC.controller;

import com.yzh.study.designPattern.delegate.imitateSpringMVC.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 模拟实际的Controller
 * @author: HeroYang
 * @create: 2019-08-21 10:15
 **/
public class SystemController implements Controller {

	private final static SystemController instance = new SystemController();

	private SystemController(){

	}

	public static SystemController getInstance(){
		return instance;
	}

	public ModelAndView addSystem(){
		ModelAndView mv = new ModelAndView();
		System.out.println("模拟 系统controller 新增操作");
		Map<Object,Object> modelMap = new HashMap<>();
		modelMap.put("resCode","1");
		mv.setModelMap(modelMap);
		mv.setView("addSystem");
		return mv;
	}

	public int updateSystem(){
		System.out.println("模拟 系统controller 修改操作");
		return 1;
	}
}
