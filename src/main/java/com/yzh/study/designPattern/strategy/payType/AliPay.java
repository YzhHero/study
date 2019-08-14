package com.yzh.study.designPattern.strategy.payType;

import com.yzh.study.designPattern.strategy.PaymentState;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-14 17:12
 **/
public class AliPay implements PaymentInf {
	@Override
	public PaymentState pay(double payAmount) {
		System.out.println("欢迎使用支付宝支付");
		System.out.println("支付宝的支付流程");
		return new PaymentState(200,"支付宝支付成功",payAmount);
	}
}
