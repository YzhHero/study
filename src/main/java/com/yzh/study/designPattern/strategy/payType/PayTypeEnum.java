package com.yzh.study.designPattern.strategy.payType;

import com.yzh.study.designPattern.strategy.PaymentState;

public enum PayTypeEnum {
	AliPay(new AliPay()), JDPay(new JDPay()), WechatPay(new WechatPay());

	private PaymentInf usePayType;

	PayTypeEnum(PaymentInf usePayType) {
		this.usePayType = usePayType;
	}

	public PaymentState getPayResult(double amount) {
		return usePayType.pay(amount);
	}
}
