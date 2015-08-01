/**
 * 
 */
package design.pattern.stategy;

/**
 * @author jack
 *
 */
public class MarllardDuck extends AbstractDuck implements IFlyable {
	private String name;

	public MarllardDuck(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see design.pattern.Duck#display()
	 */
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("name:" + name + " === I am MarllardDuck");

	}

	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("name===" + name + " I can Fly");

	}

}
