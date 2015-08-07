/**
 * Builder模式主要用户“分步骤构建一个复杂的对象”。
 * 在这其中“分步骤”是一个稳定的算法，而复杂对象的各个部分经常变化。
 * 变化点在哪里，封装哪里---Builder模式主要在于应对“复杂对象各个部分”的频繁需求变动。
 * 
 * 其缺点在于难以应对“分步骤构建算法”的需求变动。
 * 
 * Abstract Factory模式解决“系列对象”的需求变化，
 * Builder模式解决“对象部分”的需求变化。
 * Builder模式通常和Composite模式组合使用。
 */
package design.pattern.builder;

/**
 * @author jack
 * 
 * @IBuilder： 生成器接口，定义创建一个Product对象所需的各个部件的操作。
 * @Builder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，同时还提供一个让用户获取组装完成后的产品对象的方法
 * 
 * @Director： 指导者，也被称为导向者，主要用来使用Builder接口，以一个统一的过程来构建所需要的Product对象。
 * @Product： 产品，表示被生成器构建的复杂对象，包含多个部件。
 *
 *
 *           以下情况应当使用建造者模式：
 * 
 * @1、 产品对象的内部结构需要有不同的展示。
 * @2、 不同的展示对象属性依赖与同一个产品对象，产品对象内部顺序可自行调整使用。
 * @3、 在对象创建过程中会使用到系统中的一些其它对象，这些对象在产品对象的创建过程中不易得到。
 * 
 *     使用建造者模式主要有以下效果：
 * 
 * @1、 建造模式的使用使得产品的内部表象可以独立的变化。使用建造者模式可以使客户端不必知道产品内部组成的细节。
 * @2、 每个特定的建造者都独立于其它建造者和程序的其余部分，这提高拉模块化程度，并使得添加其建造者变的灵活简单。
 * @3、 因为每一个建造者都是根据数据来逐步构造出最终的产品的，因此对建造者构造的每个最终产品从头到尾有更好的控制能力。
 */
public class Builder implements IBuilder {
	/**
	 * 生成器最终构建的产品对象
	 */
	private House house;

	/**
	 * 获取生成器最终构建的产品对象
	 * 
	 * @return 生成器最终构建的产品对象
	 */

	@Override
	public House GetHouse() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());
		return house;
	}

	@Override
	public void BuildDoor() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());
	}

	@Override
	public void BuildWall() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());

	}

	@Override
	public void BuildWindow() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());

	}

	@Override
	public void BuildFloor() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());

	}

	@Override
	public void BuildHouseCeiling() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());

	}

}
