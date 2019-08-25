package com.wise.factory.simple;

/**
 * 简单工厂类
 * 范围：独立的组件或独立的模块级别
 * 类名：“模块名称+Factory”
 * 方法名：“get+接口名称”或“create+接口名称”
 * @author lingyuwang
 *
 */
public class Factory {
	
	private Factory() {}

	public static Api createApi() {
		// 主要实现选择合适的实现类创建实例对象
		return new Impl1();
	} 
	
	public static Api createApi(int type) { // 缺点，暴露参数的含义
		// 主要实现选择合适的实现类创建实例对象
		
		// 根据type进行选择，1和2应为常量
		Api api = null;
		if (type==1) {
			api = new Impl1();
		} else if (type==2) {
			api = new Impl2();
		}
		
		// 参数来源
		// 1：client
		// 2：配置文件
		// 3：系统自身，比如运行期间的某个值
		
		return api;
	} 
	
}
