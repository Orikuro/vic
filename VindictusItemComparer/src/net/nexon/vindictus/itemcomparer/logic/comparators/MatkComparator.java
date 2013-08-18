package net.nexon.vindictus.itemcomparer.logic.comparators;

import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.modell.Combo;

public class MatkComparator implements Comparator<Combo>{


	@Override
	public int compare(Combo o1, Combo o2) {
		Integer a_def = o1.getMatk();
		Integer b_def = o2.getMatk();
		return b_def.compareTo(a_def);
	}

}
