package design.pattern.singleton;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

import org.eclipse.jetty.util.BlockingArrayQueue;

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
		printInstances3(hungeryMans);
		// printInstances(stns);// 怎样模拟线程不安全的单例demo ？
	}

	/**
	 * 
	 * @param s
	 */
	private static void printInstances(final SingletonThreadNotSafe[] s) {
		final int[] index = new int[1];
		final AtomicInteger count = new AtomicInteger(0);// 用来实现“顺序打印”
		ExecutorService executor = Executors.newFixedThreadPool(10);// 通过线程池执行

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
			executor.execute(r);
		}
		executor.shutdown();
	}

	/**
	 * 
	 * @param h
	 */
	private static void printInstances(final SingletonHungeryMan[] h) {
		final int[] index = new int[1];
		final AtomicInteger count = new AtomicInteger(0);// 用来实现“顺序打印”
		ExecutorService executor = Executors.newFixedThreadPool(10);// 通过线程池执行

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
			executor.execute(r);

		}
		executor.shutdown();
	}

	/**
	 * 
	 * @param h
	 */
	private static void printInstances2(final SingletonHungeryMan[] h) {
		final AtomicInteger index = new AtomicInteger();
		ExecutorService executor = Executors.newFixedThreadPool(10000);// 通过线程池执行
		for (int i = 0; i < LENGTH; i++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					synchronized (MainTest) {
						h[index.get()] = SingletonHungeryMan.getInstance();// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
						System.out.println(index.get() + " " + h[index.get()]);
						index.getAndIncrement();
					}
				}
			};
			executor.execute(r);
		}

		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param h
	 */
	private static void printInstances3(final SingletonHungeryMan[] h) {
		// ExecutorService executor = new ThreadPoolExecutor(10000, 10000, 0L,
		// TimeUnit.NANOSECONDS, new ArrayBlockingQueue<Runnable>(10),
		// new AbortPolicy());

		ExecutorService executor = new ThreadPoolExecutor(10000, 10000, 0L,
				TimeUnit.NANOSECONDS, new BlockingArrayQueue<Runnable>(0),
				new AbortPolicy());

		final int[] i = new int[1];
		for (i[0] = 0; i[0] < LENGTH;) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					synchronized (MainTest) {
						// h[i[0]] = SingletonHungeryMan.getInstance();//
						// 这里保证线程安全的取得正确的数组下标，实现了“顺序打印”
						// System.out.println(i[0] + " " + h[i[0]]);
						System.out.println(i[0]);
						i[0]++;
					}
				}
			};
			// new Thread(r).start();
			executor.execute(r);
		}

		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
