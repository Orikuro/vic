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
			Comparator<Combo> defc, Items items, boolean noinfo) {
		PARAMETER = Arrays.toString(args).replace(",", "").replace("[", "")
				.replace("]", "");

		start(cpus, results, price, defc, items, noinfo);
	}

	private void start(int cpus, int results, double price,
			Comparator<Combo> defc, Items items, boolean noinfo) {
		start(cpus, results, price, defc, items.getShoes(), items.getPants(),
				items.getGloves(), items.getArmors(), items.getHelms(), noinfo);
	}

	private void start(int cpus, int results, double price,
			Comparator<Combo> defc, List<Shoes> shoes, List<Pants> pants,
			List<Gloves> glov, List<Armor> armors, List<Helm> helms,
			boolean noinfo) {
		StringBuffer sb = new StringBuffer();
		long total = 1l * shoes.size() * pants.size() * glov.size()
				* armors.size() * helms.size();
		DecimalFormat df = new DecimalFormat(",###");
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

		calcBestSets(sets);

		System.out.println("\nSets:\n" + setnames);

		String i_anzahl = "sets " + setnames.size() + "\tshoes " + shoes.size()
				+ "\tpants " + pants.size() + "\tgloves " + glov.size()
				+ "\tarmors " + armors.size() + "\thelms " + helms.size()
				+ "\n";
		String i_res = "Results: " + results + "\t"
				+ defc.getClass().getSimpleName().replace("Comparator", "")
				+ "\tPrice " + price + "\n";
		String i_comp = df.format(total) + " Comparisons." + "\tCPUs: " + cpus
				+ "\tTasks:" + shoes.size() + "\n";
		System.out.println(i_anzahl + i_res + i_comp);
		System.out
				.println("Each dot is 1m checks. x means 1 Task finished. 1 Task has "
						+ df.format(total / shoes.size()) + " comparisons.");

		long start = System.currentTimeMillis();
		try {
			// 1/4 Loadbalancing - Forking
			List<Callable<List<Combo>>> tasks = new ArrayList<>();
			for (int i = 0; i < shoes.size(); i++) {
				Callable<List<Combo>> c = new ComboCall(price, shoes.subList(i,
						i + 1), pants, glov, armors, helms, results, defc);
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
		sb.insert(0, i_res);
		sb.insert(0, i_anzahl);
		sb.insert(0, PARAMETER + "\n");

		if (combs.size() == 0) {
			System.out.println("Nothing found, price was too low.");
			System.exit(0);
		}

		System.out.println(Combo.OUTPUT_HEAD);
		for (int i = 0; i < combs.size(); i++) {
			System.out.println(i + ";" + combs.get(i));
			if (i >= 2) {
				System.out.println("[...]");
				break;
			}
		}

		writeResults(combs, sb.toString(), noinfo);

	}

	private void calcBestSets(HashSet<ItemSet> sets) {

		List<Integer> def = new ArrayList<>();
		//TODO: atk, matk, stamina max
//		List<Integer> def = new ArrayList<>();
//		List<Integer> def = new ArrayList<>();
//		List<Integer> def = new ArrayList<>();
		HashMap<Integer, String> i_s = new HashMap<>();
		for (ItemSet set_a : sets) {
			def.add(set_a.getDefBonus(5));
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
				}
			}
		}

		int maxdef = Collections.max(def);
		System.out.println("maxdef " + maxdef);
		System.out.println(i_s.get(maxdef));

		//System.exit(0);

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
