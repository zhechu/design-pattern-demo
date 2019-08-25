package com.wise.factory.abstractfactory;

/**
 * 装机方案二：AMD的CPU + 微星的主板
 */
public class Schema2 implements AbstractFactory{

	public CPUApi createCPUApi() {
		return new AMDCPU(939);
	}

	public MainboardApi createMainboardApi() {
		return new MSIMainboard(939);
	}

}
