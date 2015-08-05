/**
 * 
 */
package design.pattern.singleton;

/**
 * @author chenguangjian
 *
 */
public class MainTest {
	static SingletonThreadNotSafe s1 = SingletonThreadNotSafe.getInstance();
	static SingletonThreadNotSafe s2 = SingletonThreadNotSafe.getInstance();
	// Singleton s3 = new Singleton(); // private 只能在Singleton类内部才可以访问
	static SingletonThreadNotSafe[] stns = new SingletonThreadNotSafe[10000];
	static SingletonThreadSafe[] sts = new SingletonThreadSafe[10000];
	static SingletonHungeryMan[] hungeryMans = new SingletonHungeryMan[10000];

	public static void main(String[] args) {

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);

		final int[] index = new int[1];
		for (int i = 0; i < stns.length; i++) {
			index[0] = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					stns[index[0]] = SingletonThreadNotSafe.getInstance();
				}

			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					sts[index[0]] = SingletonThreadSafe.getInstance();
					// sts[index[0]] = SingletonThreadSafe.getInstance2();
					// System.out.println(index[0] + " " + sts[index[0]]);
				}

			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					hungeryMans[index[0]] = SingletonHungeryMan.getInstance();
					System.out.println(index[0] + " " + hungeryMans[index[0]]);
				}

			}).start();

			/**
			 * 这种方式的实现对于线程来说并不是安全的，因为在多线程的环境下有可能得到Singleton类的多个实例。如果同时有两个线程去判断
			 * （instance ==
			 * null），并且得到的结果为真，这时两个线程都会创建类Singleton的实例，这样就违背了Singleton模式的原则 。
			 * 
			 * 实际运行结果表明，在多线程环境中，调用getInstance()方法，会有可能返回null
			 * 
			 * design.pattern.singleton.Singleton@33abb81e
			 * design.pattern.singleton.Singleton@33abb81e true 0 null 1 null 2
			 * design.pattern.singleton.Singleton@33abb81e 3 null 4
			 * design.pattern.singleton.Singleton@33abb81e 5 null 6
			 * design.pattern.singleton.Singleton@33abb81e 7
			 * design.pattern.singleton.Singleton@33abb81e 8
			 * design.pattern.singleton.Singleton@33abb81e 9
			 * design.pattern.singleton.Singleton@33abb81e 10
			 * design.pattern.singleton.Singleton@33abb81e 11
			 * design.pattern.singleton.Singleton@33abb81e 12
			 * design.pattern.singleton.Singleton@33abb81e 13 null 14
			 * design.pattern.singleton.Singleton@33abb81e 15 null 16 null 。。。。
			 * 。。。。
			 */
		}

	}
}
