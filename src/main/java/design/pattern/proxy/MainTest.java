/**
 * 
 */
package design.pattern.proxy;

/**
 * @author jack 2015 2015年8月2日 上午1:08:50
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProxySubject proxySubject = new ProxySubject();
		proxySubject.request();

		Moveable t = new Tank();
		ProxyTime proxyTimeTank = new ProxyTime(t);
		proxyTimeTank.move();

		ProxyLogTank logTank = new ProxyLogTank(t);
		logTank.move();

	}

}
