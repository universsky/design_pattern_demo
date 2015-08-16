/**
 * 
 */
package design.pattern.factory;

/**
 * @author jack 2015 2015年8月16日 下午9:40:38
 */
public class ProductA implements Product {

	/**
	 * 
	 */
	public ProductA() {
		System.out.println("Product A is created");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.factory.Product#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "A";
	}

}
