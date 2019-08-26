package com.wise.factory.method;

/**
 * 具体的创建器实现对象，实现创建导出成数据库备份文件形式的对象
 */
public class ExportDBOperate extends ExportOperate{

	/**
	 * 声明为 protected，目的：1.防止客户端调用，2.可被子类重写，便于扩展
	 * @return
	 */
	@Override
	protected ExportFileApi factoryMethod() {
		// 创建导出成数据库备份文件形式的对象
		return new ExportDB();
	}
}
