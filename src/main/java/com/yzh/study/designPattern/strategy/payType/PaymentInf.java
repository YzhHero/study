package com.yzh.study.designPattern.strategy.payType;

import com.yzh.study.designPattern.strategy.PaymentState;

public interface PaymentInf {
	public PaymentState pay(double payAmount);
}
