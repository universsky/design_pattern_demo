/**
 * 
 */
package design.pattern.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jack 2015 2015年8月14日 下午9:12:35
 */
public class StrategyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person[] persons = { new Person(24, "male", 80.5),
				new Person(27, "female", 90), new Person(20, "male", 88.5), };
		DataSort.sort(persons,
				new design.pattern.strategy.Comparator<Person>() {

					@Override
					public int compare(Person p1, Person p2) {
						double score1 = p1.getScore();
						double score2 = p2.getScore();

						if (score1 == score2) {
							return 0;
						} else if (score1 > score2) {
							return 1;
						}

						else {
							return -1;
						}
					}
				});

		for (Person p : persons) {
			System.out.println(p);
		}

		Arrays.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getAge() == o2.getAge()) {
					return 0;
				} else if (o1.getAge() > o2.getAge()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (Person p : persons) {
			System.out.println(p);
		}
	}
}
