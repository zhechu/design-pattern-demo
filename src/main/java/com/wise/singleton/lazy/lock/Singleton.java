package com.wise.singleton.lazy.lock;

/**
 * 双重检查加锁的懒汉式单例
 */
public class Singleton {

	/**
	 * 添加 volatile 修饰，保证线程间可见
	 */
	private volatile static Singleton INSTANCE = null;

	/**
	 * 私有化构造方法，不允许外部直接调用构造函数创建类的实例
	 */
	private Singleton(){}

	public static  Singleton getInstance(){
		// 检查实例是否存在，若不存在则进入同步块
		if (INSTANCE == null) {
			// 同步块，安全地创建实例
			synchronized(Singleton.class) {
				// 再次检查实例是否存在，若不存在则创建实例
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * 示例方法，单例可以有额外的操作
	 */
	public void operation(){
		// 功能处理
	}

}
