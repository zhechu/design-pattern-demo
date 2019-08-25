package com.wise.factory.abstractfactory;

/**
 * 装机工程师的类
 */
public  class ComputerEngineer {

	/**
	 * 定义组装机器需要的CPU
	 */
	private CPUApi cpu= null;

	/**
	 * 定义组装机器需要的主板
	 */
	private MainboardApi mainboard = null;

	/**
	 * 装机过程
	 * @param schema 客户选择的装机方案
	 */
	public void makeComputer(AbstractFactory schema){
		// 1：首先准备好装机所需要的配件
		prepareHardwares(schema);

		// 2：组装机器
		
		// 3：测试机器
		
		// 4：交付客户
	}

	/**
	 * 准备装机所需要的配件
	 * @param schema 客户选择的装机方案
	 */
	private void prepareHardwares(AbstractFactory schema){
		// 使用抽象工厂来获取相应的接口对象
		this.cpu = schema.createCPUApi();
		this.mainboard = schema.createMainboardApi();
		
		// 测试一下配件是否好用
		this.cpu.calculate();
		this.mainboard.installCPU();
	}

}
