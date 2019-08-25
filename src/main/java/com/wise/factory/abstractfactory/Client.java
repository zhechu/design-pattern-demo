package com.wise.factory.abstractfactory;

/**
 * 客户端
 */
public class Client {

	public static void main(String[] args) {
		// 创建装机工程师对象
		ComputerEngineer engineer = new ComputerEngineer();
		
		// 客户选择并创建需要使用的装机方案对象
		AbstractFactory schema = new Schema1();
		// 通知装机工程师自己选择的装机方案，让装机工程师组装电脑
		engineer.makeComputer(schema);
		// now in Intel CPU,pins=1156
		// now in GAMainboard,cpuHoles=1156
		
		// 客户选择并创建需要使用的装机方案对象
		schema = new Schema2();
		// 告诉装机工程师自己选择的装机方案，让装机工程师组装电脑
		engineer.makeComputer(schema);
		// now in AMD CPU,pins=939
		// now in MSIMainboard,cpuHoles=939
	}

}
