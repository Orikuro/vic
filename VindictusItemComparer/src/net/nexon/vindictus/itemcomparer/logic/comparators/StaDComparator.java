package net.nexon.vindictus.itemcomparer.logic.comparators;

import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.modell.Combo;

public class StaDComparator implements Comparator<Combo>{


	@Override
	public int compare(Combo o1, Combo o2) {
		Integer as = o1.getSta();
		Integer bs= o2.getSta();
		
		if (as == bs){
			Integer a_def = o1.getDef();
			Integer b_def = o2.getDef();
			return b_def.compareTo(a_def);
		}
		
		return bs.compareTo(as);
	}

}
