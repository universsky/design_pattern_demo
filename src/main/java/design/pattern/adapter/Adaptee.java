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
 * 
 *         要被复用的类
 *
 */
public class Adaptee {
	public long getPower(long base, long exp) {
		long result = 1;
		for (int i = 0; i < exp; i++)
			result *= base;
		return result;
	}
}
