package com.yzh.study.designPattern.template;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-15 16:32
 **/
@ToString
@Getter
@Setter
public class UserEntity {

	private String userName;

	private String userPass;

	private int status;
}
