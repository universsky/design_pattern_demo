/**
 * 
 */
package design.pattern.proxy;

/**
 * @author jack 2015 2015年8月2日 上午1:06:20
 */
public class ProxySubject extends Subject {

	private RealSubject realSubject;

	public ProxySubject() {
		realSubject = new RealSubject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.proxy.Subject#request()
	 */
	@Override
	public void request() {
		// TODO Auto-generated method stub
		preRequest();
		realSubject.request(); // 此处执行真实对象的request方法
		postRequest();

	}

	private void preRequest() {
		// something you want to do before requesting
		System.out.println("pre request, i am playing job");
	}

	private void postRequest() {
		// something you want to do after requesting
		System.out.println("post request, iam playing money");
	}

}
