package com.yzh.study.designPattern.strategy;

import com.yzh.study.designPattern.strategy.payType.PayTypeEnum;

/**
 * @program: data-analysis
 * @description: 网上购物使用不同支付方法，来解释策略模式
 * @author: HeroYang
 * @create: 2019-08-14 17:10
 **/
public class ShoppingOnlineTest {

	private static void scanInfo() {
		System.out.println("开始浏览信息");
	}

	private static void addCart() {
		System.out.println("加入购物车");
	}

	private static void settle() {
		System.out.println("开始结算");
	}

	/**
	 * 支付这里有多种方式，与工厂不同的是，这里是对实现屏蔽而不是创建的屏蔽
	 */
	private static void pay(PayTypeEnum payTypeEnum) {
		//客户端
		PaymentState res = payTypeEnum.getPayResult(100.5);
		System.out.println("支付的结果为：" + res.toString());
	}

	//简单模拟网购流程
	public static void main(String[] args) {
		//浏览信息
		scanInfo();
		//加入购物车
		addCart();
		//结算
		settle();
		//支付，调用端在这里进行选择
		pay(PayTypeEnum.AliPay);
	}
}
