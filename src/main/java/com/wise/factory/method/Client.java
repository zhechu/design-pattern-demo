package com.wise.factory.method;

/**
 * 客户端
 */
public class Client {

	public static void main(String[] args) {
		/*//创建需要使用的Creator对象
		ExportOperate operate = new ExportDBOperate();
		//调用输出数据的功能方法
		operate.export("测试数据");*/
		
		// 当有默认实现时
		ExportOperate operate = new ExportOperate();
		operate.export("测试数据");
		// 导出数据测试数据到文本文件

		operate = new ExportDBOperate();
		operate.export("测试数据");
		// 导出数据测试数据到数据库备份文件
	}

}
