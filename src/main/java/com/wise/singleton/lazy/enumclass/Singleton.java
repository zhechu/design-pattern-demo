package com.wise.singleton.lazy.enumclass;

/**
 * 使用枚举实现的单例
 */
public enum Singleton {
	
	/**
	 * 定义一个枚举的元素，其代表 Singleton 的一个实例
	 */
	INSTANCE;

	public static Singleton getInstance(){
		return INSTANCE;
	}

	/**
	 * 单例可以有自己的属性
	 */
	private String singletonData;

	public String getSingletonData() {
		return singletonData;
	}

	public void setSingletonData(String singletonData) {
		this.singletonData = singletonData;
	}

}
