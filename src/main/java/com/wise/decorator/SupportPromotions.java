package com.wise.decorator;

/**
 * 促销类型
 */
public class SupportPromotions implements Cloneable {

	/**
	 * 该商品促销的ID
	 */
	private int id;

	/**
	 * 促销类型 1：优惠券 2：红包
	 */
	private PromotionType promotionType;

	/**
	 * 用户领取该商品的优惠券
	 */
	private UserCoupon userCoupon;

	/**
	 * 用户领取该商品的红包
	 */
	private UserRedPacket userRedPacket;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}
	
	public UserCoupon getUserCoupon() {
		return userCoupon;
	}

	public void setUserCoupon(UserCoupon userCoupon) {
		this.userCoupon = userCoupon;
	}

	public UserRedPacket getUserRedPacket() {
		return userRedPacket;
	}

	public void setUserRedPacket(UserRedPacket userRedPacket) {
		this.userRedPacket = userRedPacket;
	}

	/**
	 * 重写 clone 方法，提高创建对象效率
	 * @return
	 */
    @Override
	public SupportPromotions clone() throws CloneNotSupportedException {
        return (SupportPromotions)super.clone();
    }

}
