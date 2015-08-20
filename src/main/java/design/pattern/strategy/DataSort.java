package design.pattern.strategy;

/**
 *
 * 类名:	   DataSort <br/>
 * 功能:	   TODO <br/>
 * 原因:	   TODO  <br/>
 * 日期:	   2015年8月20日 下午11:33:09 <br/>
 * @author jack
 * @version
 * @since  JDK 1.7
 * @see
 */
public class DataSort {
	/**
	 *
	 * 功能描述: 对象数组排序 <br/>
	 * 适用条件: TODO <br/>
	 * 执行流程: 实现Comparator接口中的compare方法 <br/>
	 * 使用方法: TODO <br/>
	 * 注意事项: TODO <br/>
	 *
	 * @author jack
	 * @date:  2015年8月20日 下午11:31:44 <br/>
	 * @param objects
	 * @param c
	 * @since JDK 1.7
	 */
	public static <T> void sort(final Object[] objects, final Comparator<T> c) {
		for (int i = 0; i < objects.length - 1; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (c.compare((T) objects[i], (T) objects[j]) > 0) {
					// bubble sorting algorithm
					final Object temp = objects[i];
					objects[i] = objects[j];
					objects[j] = temp;
				}
			}
		}
		
	}
	
	public DataSort() {
	}
}
