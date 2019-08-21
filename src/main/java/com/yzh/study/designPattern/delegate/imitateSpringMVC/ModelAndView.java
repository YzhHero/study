package com.yzh.study.designPattern.delegate.imitateSpringMVC;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @description: 模拟MV
 * @author: HeroYang
 * @create: 2019-08-21 11:16
 **/
@Setter
@Getter
@ToString
public class ModelAndView {

	private Object view;

	private Map<Object,Object> modelMap;

}
