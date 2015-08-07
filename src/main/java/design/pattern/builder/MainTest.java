/**
 * 
 */
package design.pattern.builder;

/**
 * @author chenguangjian 2015年8月8日 上午1:01:42
 * 
 *         将一个复杂对象的构建与其表示相分离，使其同样的构建过程可以创建不同的表示。
 * 
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Builder builder = new Builder();
		House house = GameManager.CreateHouse(builder);
	}

}
