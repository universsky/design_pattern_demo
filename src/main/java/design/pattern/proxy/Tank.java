/**
 * 
 */
package design.pattern.proxy;

import java.util.Random;

/**
 * @author jack 2015 2015年8月2日 下午11:58:12
 */
public class Tank implements Moveable {

	public void move() {
		System.out.println("Tank is moving ...");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		System.out.println("Tankk is stopping ...");
	}

}
