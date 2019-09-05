package com.wise.singleton.lazy.enumclass;

/**
 * 客户端类
 * @author lingyuwang
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1);

		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2);

		Singleton singleton3 = Singleton.getInstance();
		System.out.println(singleton3);

		System.out.println(singleton1 == singleton2);
		// true
		System.out.println(singleton1 == singleton3);
		// true
		System.out.println(singleton2 == singleton3);
		// true

		singleton1.setSingletonData("Hello world");
		System.out.println(singleton1.getSingletonData());
		// Hello world

		System.out.println(singleton2.getSingletonData());
		// Hello world

		System.out.println(singleton3.getSingletonData());
		// Hello world
	}

}
