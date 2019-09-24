package com.wise.decorator;

import java.math.BigDecimal;

/**
 * 计算支付金额实现类
 */
public class BaseCount implements IBaseCount{

	@Override
	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());

		System.out.println("商品原单价金额为：" +  orderDetail.getPayMoney());
		
		return orderDetail.getPayMoney();
	}

}
