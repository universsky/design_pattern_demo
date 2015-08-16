/**
 * 
 */
package design.pattern.strategy;

/**
 * @author jack 2015 2015年8月14日 下午10:26:06
 * @param <E>
 */
public class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		int age1 = p1.getAge();
		int age2 = p2.getAge();

		if (age1 == age2) {
			return 0;
		} else if (age1 > age2) {
			return 1;
		}

		else {
			return -1;
		}
	}

}
