package com.wise.factory.abstractfactory;

/**
 * 抽象工厂的接口，声明创建抽象产品对象的操作
 */
public interface AbstractFactory {

	/**
	 * 创建CPU的对象
	 * @return CPU的对象
	 */
	CPUApi createCPUApi();

	/**
	 * 创建主板的对象
	 * @return 主板的对象
	 */
	MainboardApi createMainboardApi();

}
