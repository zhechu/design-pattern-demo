package com.wise.decorator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 商品
 */
public class Merchandise {

	/**
	 * 商品SKU
	 */
	private String sku;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品单价
	 */
	private BigDecimal price;

	/**
	 * 支持促销类型
	 */
	private Map<PromotionType, SupportPromotions> supportPromotions;
	
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<PromotionType, SupportPromotions> getSupportPromotions() {
		return supportPromotions;
	}

	public void setSupportPromotions(Map<PromotionType, SupportPromotions> supportPromotions) {
		this.supportPromotions = supportPromotions;
	}

}
