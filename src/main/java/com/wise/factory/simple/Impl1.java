package com.wise.factory.simple;

/**
 * 实现类
 * @author lingyuwang
 *
 */
public class Impl1 implements Api {

	@Override
	public void hello(String name) {
		System.out.println("Impl1 hello "+name);
	}

}
