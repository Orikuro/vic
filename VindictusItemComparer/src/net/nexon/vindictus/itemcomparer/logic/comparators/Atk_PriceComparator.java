package net.nexon.vindictus.itemcomparer.logic.comparators;

import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.modell.Combo;

public class Atk_PriceComparator implements Comparator<Combo>{


	@Override
	public int compare(Combo o1, Combo o2) {
		Double a_def = o1.getAtk();
		Double b_def = o2.getAtk();
		
		double a_pr = o1.getPrice();
		double b_pr = o2.getPrice();
		
		if (a_pr <= 0){
			a_pr = 0.5;
		}
		if (b_pr <= 0){
			b_pr = 0.5;
		}
		
		Double a_ver = a_def / a_pr;
		Double b_ver = b_def / b_pr;
		
		return b_ver.compareTo(a_ver);
	}

}
