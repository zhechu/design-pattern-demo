package com.wise.decorator;

import java.math.BigDecimal;

/**
 * 红包
 */
public class UserRedPacket {

	/**
	 * 红包ID
	 */
	private int id;

	/**
	 * 领取用户ID
	 */
	private int userId;

	/**
	 * 商品SKU
	 */
	private String sku;

	/**
	 * 领取红包金额
	 */
	private BigDecimal redPacket;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getRedPacket() {
		return redPacket;
	}

	public void setRedPacket(BigDecimal redPacket) {
		this.redPacket = redPacket;
	}
	
}
