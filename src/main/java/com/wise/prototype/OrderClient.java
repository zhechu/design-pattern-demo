package com.wise.prototype;

public class OrderClient {

	public static void main(String[] args) {
		// 创建订单对象
		PersonalOrder op = new PersonalOrder();
		// 设置订单数据
		op.setOrderProductNum(3925);
		op.setCustomerName("张三");
		op.setProductId("P0001");
		
		OrderBusiness ob = new OrderBusiness();
		// 调用业务服务保存订单对象
		ob.saveOrder(op);
	}

}
