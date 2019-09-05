package com.wise.singleton.lazy.innerclass;

/**
 * 使用类的内部类实现的单例
 */
public class Singleton {

	/**
	 * 静态的内部类的实例与外部类的实例没有绑定关系，且只有被调用到才会加载，从而实现了延迟加载的效果
	 */
	private static class SingletonHolder {

		/**
		 * 静态初始化器，由 JVM 保证线程安全
		 */
		private static final Singleton instance = new Singleton();

	}

	/**
	 * 私有化构造方法，不允许外部直接调用构造函数创建类的实例
	 */
	private Singleton(){}
	
	public static  Singleton getInstance(){
		return SingletonHolder.instance;
	}

}
