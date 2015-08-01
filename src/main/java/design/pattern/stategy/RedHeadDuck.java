/**
 * 
 */
package design.pattern.stategy;

/**
 * @author jack
 *
 */
public class RedHeadDuck extends AbstractDuck implements IFlyable {
	private String name;

	public RedHeadDuck(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("name:" + name + " === I am RedHeadDuck");

	}

	public void fly() {
		System.out.println("name===" + name + " I can fly");
	}

}
