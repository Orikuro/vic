package net.nexon.vindictus.itemcomparer;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.inport.StaticImport;
import net.nexon.vindictus.itemcomparer.inport.XMLImport;
import net.nexon.vindictus.itemcomparer.logic.ThreadStarter;
import net.nexon.vindictus.itemcomparer.logic.comparators.*;
import net.nexon.vindictus.itemcomparer.modell.Combo;
import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.VChar;
import net.nexon.vindictus.itemcomparer.modell.VScroll;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Main {

	private enum VSort {
		def, atk, matk, sta, staatk, stamatk, cheapdef, cheapatk, cheapmatk, cheapsta
	};

	private Comparator<Combo> COMBOSORT;

	@Option(name = "-char", aliases = { "-c" }, required = true, usage = "the char used to filter useful sets, all to ignore filtering")
	private VChar vchar;

	@Option(name = "-sort", aliases = { "-s" }, required = true, usage = "the sorting algorithm")
	private void setComparator(VSort sort) {
		switch (sort) {
		case def:
			COMBOSORT = new DefComparator();
			break;
		case atk:
			COMBOSORT = new AtkComparator();
			break;
		case matk:
			COMBOSORT = new MatkComparator();
			break;
		case sta:
			COMBOSORT = new StaDComparator();
			break;
		case staatk:
			COMBOSORT = new StaAComparator();
			break;
		case stamatk:
			COMBOSORT = new StaMComparator();
			break;
		case cheapatk:
			COMBOSORT = new Atk_PriceComparator();
			break;
		case cheapdef:
			COMBOSORT = new Def_PriceComparator();
			break;
		case cheapmatk:
			COMBOSORT = new Matk_PriceComparator();
			break;
		case cheapsta:
			COMBOSORT = new Sta_PriceComparator();
			break;
		default:
			COMBOSORT = new DefComparator();
			break;
		}
	}

	@Option(name = "-results", aliases = { "-r" }, usage = "the number of results, default: 30")
	private int results = 30;

	@Option(name = "-min", usage = "minimum level of items to include, default: 50")
	private int min = 50;

	@Option(name = "-max", usage = "maximum level of items to include, default: 999")
	private int max = 999;

	@Option(name = "-smin", usage = "minimum of stars to include, default: 2")
	private int smin = 2;

	@Option(name = "-smax", usage = "maximum of stars to include, default: 5")
	private int smax = 5;

	@Option(name = "-plus", usage = "set enhancement level of all items, default: -1 = disabled")
	private int plus = -1;

	@Option(name = "-price", usage = "set maxium price to filter items with in milions, e.g. 10.44 = 10,44 mil, default: MAXIMUM = disabled")
	private double price = Double.MAX_VALUE;

	@Option(name = "-dup", aliases = { "-d" }, usage = "duplicate items with scroll preset, (can have huge impact on performance!)")
	private VScroll vscroll;

	@Option(name = "-force", aliases = { "-f", "-cpus" }, usage = "force number of cpus, default: Systems Maximum")
	private int CPUS = Runtime.getRuntime().availableProcessors();

	@Option(name = "-keep", aliases = { "-k" }, usage = "keep overscrolled Items, default: false (huge impact on performance with -d !)")
	private boolean KEEP = false;

	@Option(name = "-noinfo", aliases = { "-no" }, usage = "if set, disables writing of .txt info files, default: false")
	private boolean NOINFO = false;
	
	@Option(name = "-export", usage = "export static.xml")
	private boolean export = false;

	@Option(name = "-ignore", aliases = { "-i" }, usage = "ignore sets that contain those words, use  commas to separate names eg \"raider, champion\", default: disabled")
	private String ignore = "";

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("ALPHA 1.5.1 - 18.08.13 - by Nekuro/Orikuro");

		if (Arrays.asList(args).contains("-export")) {
			System.out.println("Exporting static info then closing");
			StaticImport.main(null);
			System.exit(0);
		}

		new Main().startMain(args);
	}

	private void startMain(String[] args) throws Exception {
		CmdLineParser cmdLineParser = new CmdLineParser(this);

		cmdLineParser.setUsageWidth(120);
		try {
			cmdLineParser.parseArgument(args);
		} catch (Exception e) {
			System.err.println(e.getMessage());

			System.err.print("Usage: java -jar VindictusItemComparer.jar");
			cmdLineParser.printSingleLineUsage(System.err);
			System.err.println();

			cmdLineParser.printUsage(System.err);
			return;
		}
	
		Items items = new Items();
		try {
			items = XMLImport.importItems("data" + File.separatorChar
					+ "items.xml");
		} catch (Exception e) {
			System.err.println("Import of items.xml failed");
			System.err
					.println("Use -export and rename static.xml to items.xml");
			System.exit(1);
		}

		// filtering
		items.filterSetNames(ignore);
		items.filterStars(smin, smax);
		items.filterLevel(min, max);
		items.filterChar(vchar);

		// exit when not enough left
		if (items.isNotEnough()) {
			System.err.println("Not enough items left for full sets!");
			System.exit(1);
		}

		// scroll duplicating
		if (vscroll != null) {
			switch (vscroll) {
			case enthu:
				items.duplicateEnthu(KEEP);
				break;
			case force:
				items.duplicateForce(KEEP);
				break;
			case f_enthu:
				items.duplicateForceAndEnthu(KEEP);
				break;
			case ts_enthu:
				items.duplicateTutSentAndEnthu(KEEP);
				break;
			case ta_enthu:
				items.duplicateTA_Enthu(KEEP);
				break;
			case tutresis:
				items.duplicateTutResistant(KEEP);
				break;
			case tutsenti:
				items.duplicateTutSentinel(KEEP);
				break;
			case tutarma:
				items.duplicateTutArmadilo(KEEP);
				break;
			case ts_tr_ta:
				items.duplicateTs_Tr_Ta(KEEP);
				break;
			case ts_ta:
				items.duplicateTs_Ta(KEEP);
				break;
			case ts_tr:
				items.duplicateTs_Tr(KEEP);
				break;
			case ts_ta_enthu:
				items.duplicateTs_Ta_Enthu(KEEP);
				break;
			default:
				break;
			}
		}

		// overwrite enhance level
		items.forcePlus(plus);

		new ThreadStarter(args, CPUS, results, price, COMBOSORT, items, NOINFO);

	}

}