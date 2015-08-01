/**
 * 
 */
package design.pattern.stategy;

/**
 * @author jack
 * 
 *         如果超类有新的特性，子类都必须变动，这是我们开发最不喜欢看到的，一个类变让另一个类也跟着变，这有点不符合OO设计了。这样很显然的耦合了一起
 *         。利用继承-->耦合度太高了.
 * 
 *         实现接口，是一种代码解耦的设计理念。
 *
 */
public abstract class AbstractDuck implements IFlyable {
	public void quack() {
		System.out.println("quack");
	}

	public void swim() {
		System.out.println("swim");
	}

	public abstract void display();

}
