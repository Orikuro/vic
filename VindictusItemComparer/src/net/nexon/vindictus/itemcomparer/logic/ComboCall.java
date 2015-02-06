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
	private int ATK;
	private int MATK;
	private int[] MAXIS;

	public ComboCall(double pri, int atk, int matk, int[] maxima,
			List<Shoes> sho, List<Pants> pan, List<Gloves> glov,
			List<Armor> arms, List<Helm> hes, int result, Comparator<Combo> defc) {
		PRICE = pri;
		shoes = sho;
		pants = pan;
		gloves = glov;
		armors = arms;
		helms = hes;
		results = result;
		comp = defc;
		MAXIS = maxima;
		ATK = atk;
		MATK = matk;
		thresh = results * 2;
	}

	private static int min = -1;

	private List<Combo> combos = new ArrayList<>();

	private double total_p = 0;
	private double s_p = 0;
	private double p_p = 0;
	private double g_p = 0;
	private double a_p = 0;
	private double h_p = 0;
	private int thresh;

	@Override
	public List<Combo> call() throws Exception {

		String compname = comp.getClass().getSimpleName();

		switch (compname) {
		case "AtkComparator":
			return callAtk();
		case "DefComparator":
			return callDef();
		case "MatkComparator":
			return callMatk();
		case "StaDComparator":
		case "StaAComparator":
		case "StaMComparator":
			return callSta();
		default:
			return callStandard();
		}
	}

	private List<Combo> callStandard() throws Exception {
		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getTotalPrice();
			for (Pants p : pants) {
				p_p = p.getTotalPrice();
				for (Gloves g : gloves) {
					g_p = g.getTotalPrice();
					for (Armor a : armors) {
						a_p = a.getTotalPrice();
						for (Helm h : helms) {
							h_p = h.getTotalPrice();
							total_p = s_p + p_p + g_p + a_p + h_p;

							if (total_p <= PRICE) {
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

	private List<Combo> callDef() throws Exception {
		int total_def = 0;
		int s_def = 0;
		int p_def = 0;
		int g_def = 0;
		int a_def = 0;
		int h_def = 0;

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
							if (total_p <= PRICE
									&& (total_def + MAXIS[0]) >= min) {
								Combo c = new Combo(s, p, g, a, h);
								if (c.getAtk() >= ATK && c.getMatk() >= MATK) {
									combos.add(c);
								}
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

	private List<Combo> callAtk() throws Exception {

		int total_def = 0;
		int s_def = 0;
		int p_def = 0;
		int g_def = 0;
		int a_def = 0;
		int h_def = 0;

		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getTotalPrice();
			s_def = s.getTotalatk();
			for (Pants p : pants) {
				p_p = p.getTotalPrice();
				p_def = p.getTotalatk();
				for (Gloves g : gloves) {
					g_p = g.getTotalPrice();
					g_def = g.getTotalatk();
					for (Armor a : armors) {
						a_p = a.getTotalPrice();
						a_def = a.getTotalatk();
						for (Helm h : helms) {
							h_p = h.getTotalPrice();
							h_def = h.getTotalatk();
							total_p = s_p + p_p + g_p + a_p + h_p;

							total_def = s_def + p_def + h_def + a_def + g_def
									+ h_def;

							if (total_p <= PRICE
									&& (total_def + MAXIS[1]) >= min) {
								Combo c = new Combo(s, p, g, a, h);
								if (c.getAtk() >= ATK) {
									combos.add(c);
								}
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
									min = (int) combos.get(results - 1)
											.getAtk();
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

	private List<Combo> callMatk() throws Exception {
		int total_def = 0;
		int s_def = 0;
		int p_def = 0;
		int g_def = 0;
		int a_def = 0;
		int h_def = 0;

		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getTotalPrice();
			s_def = s.getTotalmatk();
			for (Pants p : pants) {
				p_p = p.getTotalPrice();
				p_def = p.getTotalmatk();
				for (Gloves g : gloves) {
					g_p = g.getTotalPrice();
					g_def = g.getTotalmatk();
					for (Armor a : armors) {
						a_p = a.getTotalPrice();
						a_def = a.getTotalmatk();
						for (Helm h : helms) {
							h_p = h.getTotalPrice();
							h_def = h.getTotalmatk();
							total_p = s_p + p_p + g_p + a_p + h_p;

							total_def = s_def + p_def + h_def + a_def + g_def
									+ h_def;

							if (total_p <= PRICE
									&& (total_def + MAXIS[2]) >= min) {

								Combo c = new Combo(s, p, g, a, h);
								if (c.getMatk() >= MATK) {
									combos.add(c);
								}
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
									min = combos.get(results - 1).getMatk();
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

	private List<Combo> callSta() throws Exception {

		int total_def = 0;
		int s_def = 0;
		int p_def = 0;
		int g_def = 0;
		int a_def = 0;
		int h_def = 0;

		int i = 0;
		for (Shoes s : shoes) {
			s_p = s.getTotalPrice();
			s_def = s.getTotalsta();
			for (Pants p : pants) {
				p_p = p.getTotalPrice();
				p_def = p.getTotalsta();
				for (Gloves g : gloves) {
					g_p = g.getTotalPrice();
					g_def = g.getTotalsta();
					for (Armor a : armors) {
						a_p = a.getTotalPrice();
						a_def = a.getTotalsta();
						for (Helm h : helms) {
							h_p = h.getTotalPrice();
							h_def = h.getTotalsta();
							total_p = s_p + p_p + g_p + a_p + h_p;

							total_def = s_def + p_def + h_def + a_def + g_def
									+ h_def;
							if (total_p <= PRICE && (total_def) >= min) {
								Combo c = new Combo(s, p, g, a, h);
								if (c.getAtk() >= ATK && c.getMatk() >= MATK) {
									combos.add(c);
								}
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
									min = combos.get(results - 1).getSta();
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
