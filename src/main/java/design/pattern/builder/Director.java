package design.pattern.builder;

/**
 * 指导者，指导使用生成器的接口来构建产品的对象 生成器模式的构造方法是为了构造同一个产品，因此必须有指导者来协调进行工作，构造方法之间存在必然的业务联系
 * 
 * @author chenguangjian 2015年8月8日 上午12:58:30
 */
public class Director {
	private Builder builder;

	/**
	 * @param builder
	 */
	public Director(Builder builder) {
		super();
		this.builder = builder;
	}

	/**
	 * 示意方法，指导生成器构建最终的产品对象
	 */
	public void constructHouse() {
		// 通过使用生成器接口来构建最终的产品对象
		builder.BuildDoor();
		builder.BuildFloor();
		builder.BuildWall();
	}
}
