package net.nexon.vindictus.itemcomparer.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.nexon.vindictus.itemcomparer.modell.Combo;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

/*
 * 
 */

public class ThreadStarter {
	private String PARAMETER = "";

	public ThreadStarter(String[] args, int cpus, int results, double price,
			int atk, int matk, Comparator<Combo> defc, Items items,
			boolean noinfo, boolean nocsv) {
		PARAMETER = Arrays.toString(args).replace(",", "").replace("[", "")
				.replace("]", "");

		start(cpus, results, price, atk, matk, defc, items, noinfo, nocsv);
	}

	private void start(int cpus, int results, double price, int atk, int matk,
			Comparator<Combo> defc, Items items, boolean noinfo, boolean nocsv) {
		start(cpus, results, price, atk, matk, defc, items.getShoes(),
				items.getPants(), items.getGloves(), items.getArmors(),
				items.getHelms(), noinfo, nocsv);
	}

	private StringBuffer sb = new StringBuffer();
	private DecimalFormat df = new DecimalFormat(",###");

	private void start(int cpus, int results, double price, int atk, int matk,
			Comparator<Combo> defc, List<Shoes> shoes, List<Pants> pants,
			List<Gloves> glov, List<Armor> armors, List<Helm> helms,
			boolean noinfo, boolean nocsv) {

		long total = 1l * shoes.size() * pants.size() * glov.size()
				* armors.size() * helms.size();

		List<Combo> combs = new ArrayList<Combo>();
		HashSet<String> setnames = new HashSet<>();
		HashSet<ItemSet> sets = new HashSet<>();
		// Debug Infos...
		sb.append("Shoes:\n");
		sb.append(shoes);
		sb.append("\n\n");
		sb.append("Pants:\n");
		sb.append(pants);
		sb.append("\n\n");
		sb.append("Gloves:\n");
		sb.append(glov);
		sb.append("\n\n");
		sb.append("Armors:\n");
		sb.append(armors);
		sb.append("\n\n");
		sb.append("Helms:\n");
		sb.append(helms);
		for (Shoes s : shoes) {
			s.getItemset().calcBonus();
			setnames.add(s.getItemset().getName());
			sets.add(s.getItemset());
			s.calcBonus();
		}
		for (Pants s : pants) {
			s.getItemset().calcBonus();
			setnames.add(s.getItemset().getName());
			sets.add(s.getItemset());
			s.calcBonus();
		}
		for (Gloves s : glov) {
			s.getItemset().calcBonus();
			setnames.add(s.getItemset().getName());
			sets.add(s.getItemset());
			s.calcBonus();
		}
		for (Armor s : armors) {
			s.getItemset().calcBonus();
			setnames.add(s.getItemset().getName());
			sets.add(s.getItemset());
			s.calcBonus();
		}
		for (Helm s : helms) {
			s.getItemset().calcBonus();
			setnames.add(s.getItemset().getName());
			sets.add(s.getItemset());
			s.calcBonus();
		}
		sb.append("");
		sb.append("Sets:");
		sb.append(setnames);

		int[] maxis = calcBestSets(sets);

		System.out.println("\nSets:\n" + setnames);

		String i_anzahl = "sets " + setnames.size() + "\tshoes " + shoes.size()
				+ "\tpants " + pants.size() + "\tgloves " + glov.size()
				+ "\tarmors " + armors.size() + "\thelms " + helms.size()
				+ "\n";
		String i_res = "Results: " + results + "\t"
				+ defc.getClass().getSimpleName().replace("Comparator", "")
				+ "\tPrice " + price + "\n";
		String i_atk = "Atk: " + atk + "\tMatk: " + matk + "\n";
		String i_comp = df.format(total) + " Comparisons." + "\tCPUs: " + cpus
				+ "\tTasks:" + shoes.size() + "\n";
		System.out.println(i_anzahl + i_res + i_atk + i_comp);
		System.out
				.println("Each dot is 1m checks. x means 1 Task finished. 1 Task has "
						+ df.format(total / shoes.size()) + " comparisons.");

		long start = System.currentTimeMillis();
		try {
			// 1/4 Loadbalancing - Forking
			List<Callable<List<Combo>>> tasks = new ArrayList<>();
			for (int i = 0; i < shoes.size(); i++) {
				Callable<List<Combo>> c = new ComboCall(price, atk, matk,
						maxis, shoes.subList(i, i + 1), pants, glov, armors,
						helms, results, defc);
				tasks.add(c);
			}

			// 2/4 Running
			ExecutorService executor = Executors.newFixedThreadPool(cpus);
			List<Future<List<Combo>>> f_combos = executor.invokeAll(tasks);

			// 3/4 Joining Results
			for (Future<List<Combo>> res : f_combos) {
				combs.addAll(res.get());
				if (combs.size() > results * 2) {
					Collections.sort(combs, defc);
					combs = new ArrayList<>(combs.subList(0, results));
				}
			}

			Collections.sort(combs, defc);

			if (results > total) {
				results = (int) total;
			}

			if (results > combs.size()) {
				results = combs.size();
			}

			combs = new ArrayList<Combo>(combs.subList(0, results));

			// 4/4 Closing
			executor.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println();
		String i_end1 = "------ DONE ------ Time = " + (end - start) + " ms";
		String i_end2 = "\t" + df.format(1.0d * total / (end - start) * 1000)
				+ " checks / s\n";
		System.out.println(i_end1 + i_end2 + "Results:");
		sb.insert(0, i_end2);
		sb.insert(0, i_end1);
		sb.insert(0, i_comp);
		sb.insert(0, i_atk);
		sb.insert(0, i_res);
		sb.insert(0, i_anzahl);
		sb.insert(0, PARAMETER + "\n");

		if (combs.size() == 0) {
			System.out.println("Nothing found, price was too low.");
			return;
		}

		System.out.println(Combo.OUTPUT_HEAD);
		for (int i = 0; i < combs.size(); i++) {
			System.out.println(i + ";" + combs.get(i));
			if (i >= 4) {
				System.out.println("[...]");
				break;
			}
		}

		if (!nocsv) {
			writeResults(combs, sb.toString(), noinfo);
		}
	}

	private int[] calcBestSets(HashSet<ItemSet> sets) {

		List<Integer> def = new ArrayList<>();
		List<Integer> atk = new ArrayList<>();
		List<Integer> matk = new ArrayList<>();

		HashMap<Integer, String> i_s = new HashMap<>();
		for (ItemSet set_a : sets) {
			int def0 = set_a.getDefBonus(5);
			def.add(def0);
			i_s.put(def0, set_a + " 5");

			int atk0 = (int) set_a.getAtkBonus(5);
			atk.add(atk0);
			i_s.put(atk0, set_a + " 5");

			int matk0 = set_a.getMatkBonus(5);
			matk.add(matk0);
			i_s.put(matk0, set_a + " 5");

			for (ItemSet set_b : sets) {
				if (set_a.equals(set_b))
					continue;
				else {
					int def1 = set_a.getDefBonus(2) + set_b.getDefBonus(2);
					int def2 = set_a.getDefBonus(2) + set_b.getDefBonus(3);
					def.add(def1);
					i_s.put(def1, set_a + " 2 2 " + set_b);
					def.add(def2);
					i_s.put(def2, set_a + " 2 3 " + set_b);

					int atk1 = (int) (set_a.getAtkBonus(2) + set_b
							.getAtkBonus(2));
					int atk2 = (int) (set_a.getAtkBonus(2) + set_b
							.getAtkBonus(3));
					atk.add(atk1);
					i_s.put(atk1, set_a + " 2 2 " + set_b);
					atk.add(atk2);
					i_s.put(atk2, set_a + " 2 3 " + set_b);

					int matk1 = set_a.getMatkBonus(2) + set_b.getMatkBonus(2);
					int matk2 = set_a.getMatkBonus(2) + set_b.getMatkBonus(3);
					matk.add(matk1);
					i_s.put(matk1, set_a + " 2 2 " + set_b);
					matk.add(matk2);
					i_s.put(matk2, set_a + " 2 3 " + set_b);

				}
			}
		}

		int maxdef = Collections.max(def);
		int maxatk = Collections.max(atk);
		int maxmatk = Collections.max(matk);
		int[] maximums = new int[3];
		maximums[0] = maxdef;
		maximums[1] = maxatk + 6; // to offset some rounding issues
		maximums[2] = maxmatk;

		System.out.println(Arrays.toString(maximums));
		System.out.println("Def:  " + i_s.get(maxdef));
		System.out.println("Atk:  " + i_s.get(maxatk));
		System.out.println("Matk: " + i_s.get(maxmatk));

		return maximums;

	}

	private void writeResults(List<Combo> combs, String infos, boolean noinfo) {
		File out = new File("_out" + File.separator);
		out.mkdirs();
		if (combs == null || combs.size() < 1)
			return;
		try {
			long time = System.currentTimeMillis();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("_out" + File.separator + time
							+ ".csv"), "UTF-8"));
			bw.write(Combo.OUTPUT_HEAD);
			bw.newLine();
			for (int i = 0; i < combs.size(); i++) {

				bw.write(i + ";" + combs.get(i));
				bw.newLine();
			}
			bw.close();

			if (!noinfo) {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("_out"
								+ File.separator + time + ".txt"), "UTF-8"));
				bufferedWriter.write(infos);
				bufferedWriter.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
