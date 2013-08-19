package net.nexon.vindictus.itemcomparer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

import net.nexon.vindictus.itemcomparer.modell.Armor;
import net.nexon.vindictus.itemcomparer.modell.Combo;
import net.nexon.vindictus.itemcomparer.modell.Gloves;
import net.nexon.vindictus.itemcomparer.modell.Helm;
import net.nexon.vindictus.itemcomparer.modell.Pants;
import net.nexon.vindictus.itemcomparer.modell.Shoes;

public class ComboCall implements Callable<List<Combo>> {

	private List<Shoes> shoes;
	private List<Pants> pants;
	private List<Gloves> gloves;
	private List<Armor> armors;
	private List<Helm> helms;

	private Comparator<Combo> comp;

	private int results = 30;
	private double PRICE;

	public ComboCall(double pri, List<Shoes> sho, List<Pants> pan, List<Gloves> glov,
			List<Armor> arms, List<Helm> hes, int result, Comparator<Combo> defc) {
		PRICE = pri;
		shoes = sho;
		pants = pan;
		gloves = glov;
		armors = arms;
		helms = hes;
		results = result;
		comp = defc;
	}


		
	

	@Override
	public List<Combo> call() throws Exception {
		List<Combo> combos = new ArrayList<>();
		double total_p = 0;
		double s_p = 0;
		double p_p = 0;
		double g_p = 0;
		double a_p = 0;
		double h_p = 0;

		int thresh = results *2;
		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getPrice();
			for (Pants p : pants) {
				p_p = p.getPrice();
				for (Gloves g : gloves) {
					g_p = g.getPrice();
					for (Armor a : armors) {
						a_p = a.getPrice();
						for (Helm h : helms) {
							h_p = h.getPrice();
							total_p = s_p + p_p + g_p + a_p + h_p;

							if (total_p < PRICE) {
								combos.add(new Combo(s, p, g, a, h));
							}
							i++;
							if (i % 1000000 == 0) {
								System.out.print(".");
							}
							if (combos.size() > thresh) {
								Collections.sort(combos, comp);
								combos = new ArrayList<Combo>(combos.subList(0,
										results));
							}
						}
					}
				}

			}
		}
		System.out.print("x");
		return combos;
	}
}
