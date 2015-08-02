/**
 * 
 */
package design.pattern.proxy;

/**
 * @author jack 2015 2015年8月3日 上午12:07:37
 */
public class ProxyLogTank implements Moveable {
	private Moveable t;

	public ProxyLogTank(Moveable t) {
		super();
		this.t = t;
	}

	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Start: " + start);
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("End: " + end);
		System.out.println("time:" + (end - start));
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
