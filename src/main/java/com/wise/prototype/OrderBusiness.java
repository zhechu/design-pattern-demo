package com.wise.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理订单业务
 */
public class OrderBusiness {

	/**
	 * 创建订单
	 * @param order 订单对象
	 */
	public void saveOrder(OrderApi order) {
		List<OrderApi> orderList = new ArrayList<>();

		// 根据业务需求，当订单的预定的产品数量超过1000的时，则将订单拆成两份订单

		// 判断当前的预定产品数量是否大于1000
		OrderApi newOrder = null;
		while(order.getOrderProductNum() > 1000){
			// 新建一份订单，跟传入的订单除了数量不一样外，其他都相同
			try {
				newOrder = order.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			// 然后进行赋值，产品数量为1000
			newOrder.setOrderProductNum(1000);
			
			// 原来的订单保留，把数量设置成减少1000
			order.setOrderProductNum(order.getOrderProductNum() - 1000);

			// 先存储，然后统一处理
			orderList.add(newOrder);

			System.out.println("拆分生成订单==" + newOrder);
		}

		// 先存储，然后统一处理
		orderList.add(order);

		System.out.println("原订单==" + order);

		orderList.forEach(o -> {
			// hashCode 不一样，表示对象不一样
			System.out.println(o.hashCode());

			// 业务处理
			// TODO
		});
	}

}
