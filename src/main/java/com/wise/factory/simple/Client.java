package com.wise.factory.simple;

/**
 * 客户端类
 * @author lingyuwang
 *
 */
public class Client {
	
	public static void main(String[] args) {
		// 客户端不需知道具体的实现（隔离封装、面向接口编程）
		Api api = Factory.createApi();
		api.hello("man"); // Impl1 hello man

		Api api1 = Factory.createApi(2);
		api1.hello("girl"); // Impl2 hello girl
	}
	
}
