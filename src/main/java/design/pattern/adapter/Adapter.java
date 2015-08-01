/**
 * 
 */
package design.pattern.adapter;

/**
 * @author jack
 * 
 *         ------------------------------ 适配器模式(adapter)
 *         ------------------------------- (1)
 *         适配器模式的意图是将一个已存在的类/接口进行复用,将其转换/具体化成客户希望的另外的一个类/接口。 (2) 如何实例复用：
 *         将要进行复用的类，放到目标类的构造方法中，进行实例化，然后在目标类的相应方法中，进行调用，修改原来方法
 *         中的参数，或添加相应的逻辑。即复用了已有类的原来方法。
 * 
 *         要实现的目标类
 *
 */
public class Adapter implements Target {
	Adaptee Adaptee;

	public Adapter() {
		Adaptee = new Adaptee();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.adapter.Target#get2Power(long)
	 */
	public long get2Power(long exp) {
		// TODO Auto-generated method stub
		return Adaptee.getPower(2, exp);// ---修改原来方法中的参数，
	}

}
