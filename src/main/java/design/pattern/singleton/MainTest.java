package design.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author chenguangjian 2015年8月6日 上午1:05:18
 */
public class MainTest {
	final static MainTest MainTest = new MainTest();
	final static SingletonThreadNotSafe s1 = SingletonThreadNotSafe
			.getInstance();
	final static SingletonThreadNotSafe s2 = SingletonThreadNotSafe
			.getInstance();
	// final static Singleton s3 = new Singleton(); // private
	// 只能在Singleton类内部才可以访问
	final static SingletonThreadNotSafe[] stns = new SingletonThreadNotSafe[10000];
	final static SingletonThreadSafe[] sts = new SingletonThreadSafe[10000];
	final static SingletonHungeryMan[] hungeryMans = new SingletonHungeryMan[10000];

	public static void main(String[] args) {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);

		// final AtomicInteger ci = new AtomicInteger(0);
		//
		// synchronized (MainTest) {
		// for (; ci.get() < stns.length; ci.getAndIncrement()) {
		// Runnable r = new Runnable() {
		// @Override
		// public void run() {
		// synchronized (MainTest) {
		// hungeryMans[ci.get()] = SingletonHungeryMan
		// .getInstance();// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
		// System.out.println(ci.get() + " "
		// + hungeryMans[ci.get()]);
		// }
		// }
		// };
		// ExecutorService executor = Executors.newFixedThreadPool(100);//
		// 通过线程池执行
		// executor.execute(r);
		// executor.shutdown();
		// }
		// }

		final int[] index = new int[1];
		final AtomicInteger count = new AtomicInteger(0);// 用来实现“顺序打印”
		for (index[0] = 0; index[0] < stns.length; index[0]++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					synchronized (MainTest) {
						hungeryMans[count.get()] = SingletonHungeryMan
								.getInstance();// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
						System.out.println(count.get() + " "
								+ hungeryMans[count.get()]);
						count.getAndIncrement();// 线程安全的下标加1
					}
				}
			};
			ExecutorService executor = Executors.newFixedThreadPool(10);// 通过线程池执行
			executor.execute(r);
			executor.shutdown();
		}
	}
}
