/**
 * 
 */
package design.pattern.proxy;

/**
 * @author jack 2015 2015年8月3日 上午12:07:37
 */
public class ProxyTime implements Moveable {
	private Moveable t;

	public ProxyTime(Moveable t) {
		super();
		this.t = t;
	}

	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));
	}

	public void stop() {
		long start = System.currentTimeMillis();
		t.stop();
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));
	}

}
