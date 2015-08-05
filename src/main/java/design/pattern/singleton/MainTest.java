package design.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author chenguangjian 2015年8月6日 上午1:05:18
 */
public class MainTest {
	private static final int LENGTH = 10000;
	final static MainTest MainTest = new MainTest();
	final static SingletonThreadNotSafe s1 = SingletonThreadNotSafe
			.getInstance();
	final static SingletonThreadNotSafe s2 = SingletonThreadNotSafe
			.getInstance();
	// final static Singleton s3 = new Singleton(); // private
	// 只能在Singleton类内部才可以访问
	final static SingletonThreadNotSafe[] stns = new SingletonThreadNotSafe[LENGTH];
	final static SingletonThreadSafe[] sts = new SingletonThreadSafe[LENGTH];
	final static SingletonHungeryMan[] hungeryMans = new SingletonHungeryMan[LENGTH];

	public static void main(String[] args) {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
		printInstances(hungeryMans);
		printInstances(stns);// 怎样模拟线程不安全的单例demo ？
	}

	private static void printInstances(final SingletonThreadNotSafe[] s) {
		final int[] index = new int[1];
		final AtomicInteger count = new AtomicInteger(0);// 用来实现“顺序打印”
		for (index[0] = 0; index[0] < LENGTH; index[0]++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					synchronized (MainTest) {
						s[count.get()] = SingletonThreadNotSafe.getInstance();// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
						System.out.println(count.get() + " " + s[count.get()]);
						count.getAndIncrement();// 线程安全的下标加1
					}
				}
			};
			ExecutorService executor = Executors.newFixedThreadPool(10);// 通过线程池执行
			executor.execute(r);
			executor.shutdown();
		}
	}

	private static void printInstances(final SingletonHungeryMan[] h) {
		final int[] index = new int[1];
		final AtomicInteger count = new AtomicInteger(0);// 用来实现“顺序打印”
		for (index[0] = 0; index[0] < LENGTH; index[0]++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					synchronized (MainTest) {
						h[count.get()] = SingletonHungeryMan.getInstance();// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
						System.out.println(count.get() + " " + h[count.get()]);
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
