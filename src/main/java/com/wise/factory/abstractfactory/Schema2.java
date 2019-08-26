package com.wise.factory.abstractfactory;

/**
 * 装机方案二：AMD的CPU + 微星的主板
 */
public class Schema2 implements AbstractFactory{

	@Override
    public CPUApi createCPUApi() {
		return new AMDCPU(939);
	}

	@Override
	public MainboardApi createMainboardApi() {
		return new MSIMainboard(939);
	}

}
