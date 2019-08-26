package com.wise.factory.simple;

/**
 * 实现类
 * @author lingyuwang
 *
 */
public class Impl2 implements Api {

	@Override
    public void hello(String name) {
		System.out.println("Impl2 hello "+name);
	}

}
