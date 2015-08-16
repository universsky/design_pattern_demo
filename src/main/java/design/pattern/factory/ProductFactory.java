/**
 * 
 */
package design.pattern.factory;

/**
 * @author jack 2015 2015年8月16日 下午9:57:05
 */
public class ProductFactory {

	/**
	 * 
	 */
	public ProductFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Product getProduct(String type) {
		switch (type) {
		case "A":
			return new ProductA();
		case "B":
			return new ProductB();
		}
		return null;
	}
}
