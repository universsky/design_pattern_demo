/**
 * 
 */
package design.pattern.singleton;

/**
 * @author chenguangjian
 *         这种方式的实现对于线程来说并不是安全的，因为在多线程的环境下有可能得到Singleton类的多个实例。如果同时有两个线程去判断
 *         （instance ==
 *         null），并且得到的结果为真，这时两个线程都会创建类Singleton的实例，这样就违背了Singleton模式的原则 。
 *         实际运行结果表明，在多线程环境中，调用getInstance()方法，会有可能返回null
 * 
 *         实际上在上述代码中，有可能在计算出表达式的值之前，对象实例已经被创建，但是内存模型并不能保证对象实例在第二个线程创建之前被发现。
 *         该实现方式主要有两个优点： 由于实例是在 Instance
 *         属性方法内部创建的，因此类可以使用附加功能（例如，对子类进行实例化），即使它可能引入不想要的依赖性。
 *         直到对象要求产生一个实例才执行实例化；这种方法称为"惰性实例化"。惰性实例化避免了在应用程序启动时实例化不必要的 singleton。
 */
public class SingletonThreadSafe {
	private static SingletonThreadSafe singleton = null;

	// Singleton通过将构造方法限定为private避免了类在外部被实例化
	private SingletonThreadSafe() {
	}

	/**
	 * 这样写，依然是线程不安全的
	 * 
	 * @return
	 */
	public static synchronized SingletonThreadSafe getInstance() { // 这样写依然是线程不安全的，当多线程环境下，有可能返回null
		if (singleton == null) {
			singleton = new SingletonThreadSafe();
		}
		return singleton;
	}

	/**
	 * 双重检查锁定 这样写，依然是线程不安全的
	 * 
	 * @return
	 */
	public static synchronized SingletonThreadSafe getInstance2() {
		if (singleton == null) {
			synchronized (SingletonThreadSafe.class) {
				if (singleton == null) {
					singleton = new SingletonThreadSafe();
				}
			}
		}
		return singleton;
	}

}
