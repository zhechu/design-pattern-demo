package com.wise.decorator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    public static void main( String[] args ) {
    	// 新建订单
    	Order order = new Order();

    	// 初始化订单
    	init(order);

    	// 计算每个订单项实付金额
    	for (OrderDetail orderDetail: order.getList()) {
    		BigDecimal payMoney = PromotionFactory.getPayMoney(orderDetail);
    		orderDetail.setPayMoney(payMoney);
    		System.out.println("最终支付金额：" + orderDetail.getPayMoney());
    	}
    }

	/**
	 * 订单初始化
	 * @param order
	 * @return
	 */
	private static Order init(Order order) {
		// 促销类型
    	Map<PromotionType, SupportPromotions> supportPromotionsMap = new HashMap<>();

		// 优惠券
		SupportPromotions couponSupportPromotions = new SupportPromotions();
		couponSupportPromotions.setPromotionType(PromotionType.COUPON);
    	UserCoupon userCoupon= new UserCoupon();
    	userCoupon.setCoupon(new BigDecimal(3));
    	userCoupon.setSku("1-11-1");
    	userCoupon.setUserId(1);
    	couponSupportPromotions.setUserCoupon(userCoupon);
    	supportPromotionsMap.put(PromotionType.COUPON, couponSupportPromotions);

    	// 红包
		SupportPromotions redpackedSupportPromotions = null;
		try {
			// 使用克隆方法提高创建对象效率
			redpackedSupportPromotions = couponSupportPromotions.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		redpackedSupportPromotions.setPromotionType(PromotionType.REDPACKED);
    	UserRedPacket userRedPacket= new UserRedPacket();
    	userRedPacket.setId(1);
    	userRedPacket.setRedPacket(new BigDecimal(10));
    	userRedPacket.setSku("1-11-1");
    	userCoupon.setUserId(1);
    	redpackedSupportPromotions.setUserRedPacket(userRedPacket);
    	supportPromotionsMap.put(PromotionType.REDPACKED, redpackedSupportPromotions);

    	// 商品
    	Merchandise merchandise = new Merchandise();
    	merchandise.setSku("1-11-1");
    	merchandise.setName("笔记本");
    	merchandise.setPrice(new BigDecimal(20));
    	merchandise.setSupportPromotions(supportPromotionsMap);

    	// 订单项
    	List<OrderDetail> OrderDetailList = new ArrayList<>(1);
    	OrderDetail orderDetail = new OrderDetail();
    	orderDetail.setId(1);
    	orderDetail.setOrderId(1111);
    	orderDetail.setMerchandise(merchandise);
    	OrderDetailList.add(orderDetail);
    	order.setList(OrderDetailList);
    	
    	return order;
    }

}
