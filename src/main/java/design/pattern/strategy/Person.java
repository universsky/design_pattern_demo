/**
 * 
 */
package design.pattern.strategy;

/**
 * @author jack 2015 2015年8月14日 下午10:26:59
 */
public class Person {
	private int age;
	private String sex;
	private double score;

	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 * @param sex
	 * @param score
	 */
	public Person(int age, String sex, double score) {
		super();
		this.age = age;
		this.sex = sex;
		this.score = score;
	}

	public String toString() {
		return "Person=[" + "age=" + age + ",score=" + score + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
