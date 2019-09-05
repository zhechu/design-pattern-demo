package com.wise.singleton.hungry;

/**
 * 饿汉式单例
 */
public class Singleton {

	/**
	 * 定义一个变量存储创建的唯一类实例
	 */
	private final static Singleton INSTANCE = new Singleton();

	/**
	 * 私有化构造方法，不允许外部直接调用构造函数创建类的实例
	 */
	private Singleton(){}

	/**
	 * 定义一个方法=为客户端提供类实例
	 * @return
	 */
	public static Singleton getInstance(){
		return INSTANCE;
	}
	
	/**
	 * 示例方法，单例可以有额外的操作
	 */
	public void operation(){
		// 功能处理
	}

}
