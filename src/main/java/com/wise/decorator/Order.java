package com.wise.decorator;

import java.math.BigDecimal;
import java.util.List;

/**
 * 主订单
 */
public class Order {

	/**
	 * 订单ID
	 */
	private int id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 总支付金额
	 */
	private BigDecimal totalPayMoney;

	/**
	 * 详细订单列表
	 */
	private List<OrderDetail> list;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getTotalPayMoney() {
		return totalPayMoney;
	}

	public void setTotalPayMoney(BigDecimal totalPayMoney) {
		this.totalPayMoney = totalPayMoney;
	}

	public List<OrderDetail> getList() {
		return list;
	}

	public void setList(List<OrderDetail> list) {
		this.list = list;
	}

}
