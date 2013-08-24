package net.nexon.vindictus.itemcomparer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

import net.nexon.vindictus.itemcomparer.modell.Combo;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class ComboCall implements Callable<List<Combo>> {

	private List<Shoes> shoes;
	private List<Pants> pants;
	private List<Gloves> gloves;
	private List<Armor> armors;
	private List<Helm> helms;

	private Comparator<Combo> comp;

	private int results = 30;
	private double PRICE;

	public ComboCall(double pri, List<Shoes> sho, List<Pants> pan,
			List<Gloves> glov, List<Armor> arms, List<Helm> hes, int result,
			Comparator<Combo> defc) {
		PRICE = pri;
		shoes = sho;
		pants = pan;
		gloves = glov;
		armors = arms;
		helms = hes;
		results = result;
		comp = defc;
	}

	static int min = -1;

	@Override
	public List<Combo> call() throws Exception {
		List<Combo> combos = new ArrayList<>();
		double total_p = 0;
		double s_p = 0;
		double p_p = 0;
		double g_p = 0;
		double a_p = 0;
		double h_p = 0;

		int total_def = 0;
		int s_def = 0;
		int p_def = 0;
		int g_def = 0;
		int a_def = 0;
		int h_def = 0;

		int thresh = results * 2;
		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getTotalPrice();
			s_def = s.getTotaldef();
			for (Pants p : pants) {
				p_p = p.getTotalPrice();
				p_def = p.getTotaldef();
				for (Gloves g : gloves) {
					g_p = g.getTotalPrice();
					g_def = g.getTotaldef();
					for (Armor a : armors) {
						a_p = a.getTotalPrice();
						a_def = a.getTotaldef();
						for (Helm h : helms) {
							h_p = h.getTotalPrice();
							h_def = h.getTotaldef();
							total_p = s_p + p_p + g_p + a_p + h_p;

							total_def = s_def + p_def + h_def + a_def + g_def
									+ h_def;
							// TODO: dynamic maxdef
//							 if (total_p < PRICE && (total_def+457)>=min) {
							if (total_p <= PRICE) {
								// this is way more expensive than sorting
								// complex object => lots of overhead
								// the less this is called, the faster it gets!
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
								synchronized (this) {
									min = combos.get(results - 1).getDef();
								}
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
