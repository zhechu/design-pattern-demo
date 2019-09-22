package com.wise.prototype;

/**
 * 订单接口，声明了可以克隆自身的方法
 */
public interface OrderApi extends Cloneable {

	/**
	 * 获取订单产品数量
	 * @return 订单中产品数量
	 */
	int getOrderProductNum();

	/**
	 * 设置订单产品数量
	 * @param num 订单产品数量
	 */
	void setOrderProductNum(int num);

	/**
	 * 将 Object 的方法修饰符改为 public，允许外界访问
	 * @return
	 * @throws CloneNotSupportedException
	 */
	OrderApi clone() throws CloneNotSupportedException;

}
