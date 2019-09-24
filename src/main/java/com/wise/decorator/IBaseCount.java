package com.wise.decorator;

import java.math.BigDecimal;

/**
 * 计算支付金额接口
 */
public interface IBaseCount {

	/**
	 * 算支付金额
	 * @param orderDetail
	 * @return
	 */
	BigDecimal countPayMoney(OrderDetail orderDetail);

}
