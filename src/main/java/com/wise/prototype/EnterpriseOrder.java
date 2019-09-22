package com.wise.prototype;

/**
 * 企业订单
 */
public class EnterpriseOrder implements OrderApi {

	/**
	 * 企业名称
	 */
	private String enterpriseName;

	/**
	 * 产品编号
	 */
	private String productId;

	/**
	 * 订单产品数量
	 */
	private int orderProductNum;

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

	@Override
	public void setOrderProductNum(int num) {
		this.orderProductNum = num;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString(){
		return "本企业订单的订购企业是=" + this.enterpriseName + "，订购产品是=" + this.productId + "，订购数量为=" + this.orderProductNum;
	}

	@Override
	public OrderApi clone() throws CloneNotSupportedException {
		return (OrderApi) super.clone();
	}

}
