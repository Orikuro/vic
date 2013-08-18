package net.nexon.vindictus.itemcomparer.logic.comparators;

import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.modell.Combo;

public class AtkComparator implements Comparator<Combo>{


	@Override
	public int compare(Combo o1, Combo o2) {
		Double a_def = o1.getAtk();
		Double b_def = o2.getAtk();
		return b_def.compareTo(a_def);
	}

}
