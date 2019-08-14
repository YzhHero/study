package com.yzh.study.designPattern.strategy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: data-analysis
 * @description: 支付状态
 * @author: HeroYang
 * @create: 2019-08-14 17:06
 **/
@Setter
@Getter
@ToString
public class PaymentState {
	//支付状态code
	private int payCode;
	//支付状态消息
	private String payMsg;
	//支付金额
	private double payAmount;

	public PaymentState(int payCode, String payMsg, double payAmount) {
		this.payCode = payCode;
		this.payMsg = payMsg;
		this.payAmount = payAmount;
	}
}
