package com.wise.decorator;

import java.math.BigDecimal;

/**
 * 计算使用优惠券后的金额
 */
public class CouponDecorator extends BaseCountDecorator {

	public CouponDecorator(IBaseCount count) {
		super(count);
	}
	
	@Override
	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		super.countPayMoney(orderDetail);
		return countCouponPayMoney(orderDetail);
	}
	
	private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
		BigDecimal coupon =  orderDetail.getMerchandise().getSupportPromotions().get(PromotionType.COUPON).getUserCoupon().getCoupon();

		System.out.println("优惠券金额：" + coupon);
		
		orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(coupon));
		return orderDetail.getPayMoney();
	}

}
