/**
 * 
 */
package design.pattern.singleton;

/**
 * @author chenguangjian 饿汉式单例类.在类初始化时，已经自行实例化
 *         饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
 */
public class SingletonHungeryMan {
	// 私有构造方法
	private SingletonHungeryMan() {
	}

	final private static SingletonHungeryMan ins = new SingletonHungeryMan(); // 这地方直接用static实例变量的方式来保证单例

	// 静态工厂方法,但是在多线程环境中，还是会返回null
	public static SingletonHungeryMan getInstance() {
		return ins;
	}

}
