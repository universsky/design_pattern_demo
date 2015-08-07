/**
 * 
 */
package design.pattern.builder;

/**
 * @author chenguangjian 2015年8月8日 上午1:16:09
 * 
 *         指导者，指导使用生成器的接口来构建产品的对象
 *         生成器模式的构造方法是为了构造同一个产品，因此必须有指导者来协调进行工作，构造方法之间存在必然的业务联系
 */
public class GameManager {
	public static House CreateHouse(Builder builder) {
		builder.BuildDoor();

		builder.BuildWindow();
		builder.BuildWindow();

		builder.BuildWall();
		builder.BuildWall();
		builder.BuildWall();
		builder.BuildWall();

		builder.BuildFloor();
		builder.BuildHouseCeiling();

		return builder.GetHouse();

	}
}
