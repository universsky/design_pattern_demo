/**
 * 
 */
package design.pattern.stategy;

/**
 * @author jack
 * 
 *         第四种方法： 对上面各方式的总结: 继承的好处:让共同部分,可以复用.避免重复编程.
 *         继承的不好:耦合性高.一旦超类添加一个新方法,子类都继承,拥有此方法, 若子类相当部分不实现此方法,则要进行大批量修改.
 *         继承时,子类就不可继承其它类了. 接口的好处:解决了继承耦合性高的问题. 且可让实现类,继承或实现其它类或接口.
 *         接口的不好:不能真正实现代码的复用.可用以下的策略模式来解决.
 * 
 *         ------------------------- strategy(策略模式) -------------------------
 *         我们有一个设计原则： 找出应用中相同之处，且不容易发生变化的东西，把它们抽取到抽象类中，让子类去继承它们；
 *         找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。 -->important.
 *         现在，为了要分开“变化和不变化的部分”，我们准备建立两组类（完全远离Duck类），一个是"fly"相关的，另一个
 *         是“quack”相关的，每一组类将实现各自的动作。比方说，我们可能有一个类实现“呱呱叫”，另一个类实现“吱吱
 *         叫”，还有一个类实现“安静”。
 *
 */
public class DuckTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractDuck marllardDuck = new MarllardDuck("Marllard");

		marllardDuck.quack();
		marllardDuck.swim();
		marllardDuck.display();
		marllardDuck.fly();

		AbstractDuck redHeadDuck = new RedHeadDuck("Reed");
		redHeadDuck.quack();
		redHeadDuck.swim();
		redHeadDuck.display();
		redHeadDuck.fly();

	}

}
