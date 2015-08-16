package design.pattern.strategy;

/**
 * @author jack 2015 2015年8月14日 下午10:56:58
 */
public class DataSort {
	public DataSort() {
	}

	/**
	 * @param <T>
	 * @param persons
	 */
	public static <T> void sort(Object[] objects, Comparator<T> c) {
		for (int i = 0; i < objects.length - 1; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (c.compare((T) objects[i], (T) objects[j]) > 0) {// bubble
																	// sorting
																	// algrithm
					Object temp = objects[i];
					objects[i] = objects[j];
					objects[j] = temp;
				}
			}
		}

	}
}
