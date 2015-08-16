/**
 * 
 */
package design.pattern.factory;

/**
 * @author jack 2015 2015年8月16日 下午9:41:23
 */
public class ProductB implements Product {

	/**
	 * 
	 */
	public ProductB() {
		System.out.println("Product B is created");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.factory.Product#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "B";
	}

}
