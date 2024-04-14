package Comparators;

import java.util.Comparator;

import Actors.Student;
import SubSystems.News;

public class NewsComparator implements Comparator<News> {
	
	/**
	 * Compare.
	 *
	 * @param s1 the s 1
	 * @param s2 the s 2
	 * @return the int
	 */
	
	@Override
	public int compare(News o1, News o2) {
		return o1.compareTo(o2);
	}

}
