/**
 * 
 */
package design.pattern.factory;

/**
 * @author jack 2015 2015年8月16日 下午10:00:34
 */
public class MainTest {

	/**
	 * 
	 */
	public MainTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = ProductFactory.getProduct("A");
		String productName = product.getName();
		System.out.println(productName);

	}

}
