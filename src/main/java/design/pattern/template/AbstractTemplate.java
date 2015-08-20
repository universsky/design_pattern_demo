/*
 * 项目:	design.pattern
 * 文件:	AbstractTemplate.java
 * 包名:	design.pattern.template
 * 日期:	2015年8月20日下午11:41:52
 * 版权：Copyright (c) 2015, qjdchina.com All Rights Reserved.
 *
 */

package design.pattern.template;

/**
 * 类名:	   AbstractTemplate <br/>
 * 功能:	   TODO <br/>
 * 原因:	   TODO  <br/>
 * 日期:	   2015年8月20日 下午11:41:52 <br/>
 * @author jack
 * @version
 * @since  JDK 1.7
 * @see
 */

public abstract class AbstractTemplate implements Template {
	public void execute() {
		subExecute1();
		subExecute2();
		subExecute3();
	}
	protected abstract void subExecute1();
	protected abstract void subExecute2();
	protected void subExecute3() {
	}

}
