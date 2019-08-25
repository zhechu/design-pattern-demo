package com.wise.factory.abstractfactory;

/**
 * 装机方案一：Intel 的CPU + 技嘉的主板
 */
public class Schema1 implements AbstractFactory{

	public CPUApi createCPUApi() {
		return new IntelCPU(1156);
	}

	public MainboardApi createMainboardApi() {
		return new GAMainboard(1156);
	}

}
