/**
 * 
 */
package design.pattern.builder;

/**
 * @author jack 对同一个构建过程，只要配置不同的生成器实现，就会生成出不同表现的对象。
 */
public interface IBuilder {
	public abstract void BuildDoor();

	public abstract void BuildWall();

	public abstract void BuildWindow();

	public abstract void BuildFloor();

	public abstract void BuildHouseCeiling();

	public abstract House GetHouse();
}
