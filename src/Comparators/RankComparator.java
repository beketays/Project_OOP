package Comparators;

import java.util.Comparator;

import Actors.Teacher;
import Researcher.ResearchPaper;

public class RankComparator implements Comparator<Teacher>{

	
	/**
	 * Compare.
	 *
	 * @param rp1 the rp 1
	 * @param rp2 the rp 2
	 * @return the int
	 */
	@Override
	  public int compare(Teacher t1, Teacher t2) {
	    return t1.compareTo(t2);
	  }

}
