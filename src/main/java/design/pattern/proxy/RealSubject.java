/**
 * 
 */
package design.pattern.proxy;

/**
 * @author jack 2015 2015年8月2日 上午1:05:22
 */
public class RealSubject extends Subject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.proxy.Subject#request()
	 */
	public void request() {
		System.out.println("I am real subject");

	}

}
