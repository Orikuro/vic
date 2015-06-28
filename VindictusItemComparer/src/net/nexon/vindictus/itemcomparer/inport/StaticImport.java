package net.nexon.vindictus.itemcomparer.inport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import net.nexon.vindictus.itemcomparer.modell.Item;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.ItemSetBonus;
import net.nexon.vindictus.itemcomparer.modell.ItemSets;
import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.enu.VChar;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class StaticImport {

	private static List<Shoes> shoes = new ArrayList<>();
	private static List<Pants> pants = new ArrayList<>();
	private static List<Gloves> gloves = new ArrayList<>();
	private static List<Armor> armors = new ArrayList<>();
	private static List<Helm> helms = new ArrayList<>();

	private static HashMap<Integer, Item> itemmap = new HashMap<>();

	private static HashSet<String> sets = new HashSet<>();
	private static HashSet<ItemSet> isets = new HashSet<>();

	private static String vella = VChar.vella.toString();
	private static String fiona = VChar.fiona.toString();
	private static String lann = VChar.lann.toString();
	private static String hurk = VChar.hurk.toString();
	private static String karok = VChar.karok.toString();
	private static String kai = VChar.kai.toString();
	private static String lynn = VChar.lynn.toString();
	private static String arisha = VChar.arisha.toString();

	private static String magic = VChar.evie.toString() + " " + arisha;

	private static String char_melee = lynn + " " + vella + " " + fiona + " "
			+ lann + " " + hurk + " " + karok + " " + kai;

	private static String char_lan_kai = lann + " " + kai;
	private static String char_lan_kai_kar = lann + " " + hurk + " " + karok
			+ " " + kai;

	static void generateWonderland() {
		String setname = "Wonderland";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		int sdef = 116;
		int sstr = 0;
		int sint = 0;
		int sagi = 0;
		int satk = 0;
		boni.add(new ItemSetBonus(sdef, sstr, sint, sagi, satk));
		boni.add(new ItemSetBonus(128, 0, 0, 0, 0));
		boni.add(new ItemSetBonus(148, 18, 84, 0, 0));
		boni.add(new ItemSetBonus(160, 27, 125, 0, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		String name = "Walkers";
		int def = 267;
		int str = 0;
		int vint = 118;
		int agi = 29;
		int crit_res = 12;
		Shoes s = new Shoes(iset, name, 60, ItemTyp.CLOTH, def, str, vint, agi,
				crit_res);
		Pants p = new Pants(iset, "Mini Dress", 60, ItemTyp.CLOTH, 318, 0, 140,
				28, 13);
		Gloves g = new Gloves(iset, "Belt Gloves", 60, ItemTyp.CLOTH, 249, 0,
				125, 29, 9);
		Armor a = new Armor(iset, "Chain Boleru", 60, ItemTyp.CLOTH, 360, 0,
				134, 28, 14);
		Helm h = new Helm(iset, "Rabbit Hat", 60, ItemTyp.CLOTH, 299, 0, 129,
				29, 9);

		s.setStars(3);
		p.setStars(3);
		g.setStars(3);
		a.setStars(3);
		h.setStars(3);
		sets.add(setname + " 3*");
		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		Shoes ss = new Shoes(iset, name, 60, ItemTyp.CLOTH, def, str, vint,
				agi, crit_res);
		Pants pp = new Pants(iset, "Mini Dress", 60, ItemTyp.CLOTH, 318, 0,
				140, 28, 13);
		Gloves gg = new Gloves(iset, "Belt Gloves", 60, ItemTyp.CLOTH, 249, 0,
				125, 29, 9);
		Armor aa = new Armor(iset, "Chain Boleru", 60, ItemTyp.CLOTH, 360, 0,
				134, 28, 14);
		Helm hh = new Helm(iset, "Rabbit Hat", 60, ItemTyp.CLOTH, 299, 0, 129,
				29, 9);

		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

		sets.add(setname + " 4*");
		Shoes sss = new Shoes(iset, name, 60, ItemTyp.CLOTH, def, str, vint,
				agi, crit_res);
		Pants ppp = new Pants(iset, "Mini Dress", 60, ItemTyp.CLOTH, 318, 0,
				140, 28, 13);
		Gloves ggg = new Gloves(iset, "Belt Gloves", 60, ItemTyp.CLOTH, 249, 0,
				125, 29, 9);
		Armor aaa = new Armor(iset, "Chain Boleru", 60, ItemTyp.CLOTH, 360, 0,
				134, 28, 14);
		Helm hhh = new Helm(iset, "Rabbit Hat", 60, ItemTyp.CLOTH, 299, 0, 129,
				29, 9);

		sss.setStars(4);
		ppp.setStars(4);
		ggg.setStars(4);
		aaa.setStars(4);
		hhh.setStars(4);

		shoes.add(sss);
		gloves.add(ggg);
		pants.add(ppp);
		armors.add(aaa);
		helms.add(hhh);

	}

	static void generateMhara() {
		String setname = "Mhara";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		int sdef = 195;
		int sstr = 0;
		int sint = 0;
		int sagi = 0;
		int satk = 0;
		boni.add(new ItemSetBonus(sdef, sstr, sint, sagi, satk));
		boni.add(new ItemSetBonus(230, 0, 0));
		boni.add(new ItemSetBonus(270, 25, 110));
		boni.add(new ItemSetBonus(330, 45, 160));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Gloves g = new Gloves(iset, "Armguard", 70, ItemTyp.LIGHT, 403, 9, 114,
				29, 10);
		String name = "Boots";
		int def = 405;
		int str = 9;
		int vint = 114;
		int agi = 30;
		int crit_res = 10;
		Shoes s = new Shoes(iset, name, 70, ItemTyp.LIGHT, def, str, vint, agi,
				crit_res);
		Pants p = new Pants(iset, "Chaps", 70, ItemTyp.LIGHT, 485, 11, 151, 33,
				12);
		Helm h = new Helm(iset, "Fur Cap", 70, ItemTyp.LIGHT, 459, 10, 130, 30,
				11);
		Armor a = new Armor(iset, "Scale Coat", 70, ItemTyp.LIGHT, 536, 12,
				151, 33, 14);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generatePearlClassic() {
		String setname = "Classic Black Pearl";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(225, 0, 80));
		boni.add(new ItemSetBonus(260, 0, 110));
		boni.add(new ItemSetBonus(300, 0, 130));
		boni.add(new ItemSetBonus(360, 0, 180));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Boots", 80, ItemTyp.HEAVY, 737, 29, 125, 45,
				12);
		Gloves g = new Gloves(iset, "Gauntlets", 80, ItemTyp.LIGHT, 723, 30,
				125, 45, 12);
		Pants p = new Pants(iset, "Greaves", 80, ItemTyp.LIGHT, 798, 35, 151,
				49, 15);
		Helm h = new Helm(iset, "Helmet", 80, ItemTyp.LIGHT, 772, 34, 132, 46,
				14);
		Armor a = new Armor(iset, "Mail", 80, ItemTyp.LIGHT, 845, 36, 159, 50,
				16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateEverlastingEvie() {
		String setname = "Everlasting(Evie)";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(206, 0, 0));
		boni.add(new ItemSetBonus(241, 0, 0));
		boni.add(new ItemSetBonus(325, 22, 102));
		boni.add(new ItemSetBonus(397, 41, 143));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 601, 23, 143, 37,
				14);
		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.LIGHT, 493, 16, 109, 32,
				10);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 479, 17, 109,
				32, 10);
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.LIGHT, 528, 21, 116, 33,
				12);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 554, 22, 135, 36,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateApocryphal() {
		String setname = "Apocryphal";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(190, 82, 0));
		boni.add(new ItemSetBonus(210, 106, 0));
		boni.add(new ItemSetBonus(230, 134, 0));
		boni.add(new ItemSetBonus(295, 164, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		// def, str, int, agi, critres
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.PLATE, 774, 118, 0, 48,
				13);
		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.PLATE, 754, 120, 0, 41,
				12);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.PLATE, 834, 123, 0, 57,
				17);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.PLATE, 761, 119, 0,
				41, 12);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 595, 121, 0, 46,
				14);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateEverlastingFio() {
		String setname = "Everlasting";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Armor a = new Armor(iset, "Armor", 70, ItemTyp.PLATE, 922, 100, 0, 54,
				17);
		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.PLATE, 835, 110, 0, 39,
				13);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.PLATE, 844, 111, 0,
				39, 12);
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.PLATE, 860, 99, 0, 49, 13);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 689, 101, 0, 45,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateBlackPearl() {
		String setname = "Black Pearl";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona + " " + vella);

		Shoes s = new Shoes(iset, "Boots", 80, ItemTyp.LIGHT, 986, 113, 0, 67,
				13);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.HEAVY, 972, 112, 0,
				62, 12);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.LIGHT, 1037, 124, 0, 52,
				16);
		Helm h = new Helm(iset, "Helmet", 80, ItemTyp.LIGHT, 1011, 114, 0, 58,
				15);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.LIGHT, 1084, 123, 0, 52,
				17);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateHeremon() {
		String setname = "Heremon";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(196, 73, 0));
		boni.add(new ItemSetBonus(215, 100, 0));
		boni.add(new ItemSetBonus(288, 130, 0));
		boni.add(new ItemSetBonus(364, 162, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Boots", 80, ItemTyp.HEAVY, 900, 135, 0, 70,
				14);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.PLATE, 1200, 150, 0, 55,
				20);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 990, 135, 0,
				66, 16);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.HEAVY, 1000, 150, 0, 60,
				18);
		Helm h = new Helm(iset, "Helmet", 80, ItemTyp.PLATE, 1150, 135, 0, 60,
				17);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateNoblesse() {
		String setname = "Noblesse";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(190, 75, 0));
		boni.add(new ItemSetBonus(215, 103, 0));
		boni.add(new ItemSetBonus(285, 133, 0));
		boni.add(new ItemSetBonus(360, 164, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Boots", 80, ItemTyp.PLATE, 912, 146, 0, 66,
				15);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 979, 144, 0,
				60, 16);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.HEAVY, 991, 159, 0, 53,
				17);
		Helm h = new Helm(iset, "Helmet", 80, ItemTyp.PLATE, 1165, 144, 0, 55,
				16);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.HEAVY, 1140, 160, 0, 49,
				19);
		s.setPrice(40);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateNighthawk() {
		String setname = "Nighthawk";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(192, 58, 0));
		boni.add(new ItemSetBonus(212, 82, 0));
		boni.add(new ItemSetBonus(287, 110, 0));
		boni.add(new ItemSetBonus(365, 140, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.HEAVY, 629, 86, 0, 20,
				10);
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.HEAVY, 703, 96, 0, 22, 11);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.PLATE, 629, 86, 0,
				20, 10);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.PLATE, 888, 122, 0, 28,
				14);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.PLATE, 851, 117, 0, 27,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generatePhantomHeavy() {
		String setname = "Phantom Heavy";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.HEAVY, 631, 95, 0, 12, 8);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 628, 95, 0,
				10, 8);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 780, 99, 0, 9, 10);
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.HEAVY, 732, 95, 0, 11, 8);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 890, 99, 0, 9, 12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateRoyalGuard() {
		String setname = "Royal Guard Light";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Boots", 70, ItemTyp.HEAVY, 604, 93, 0, 21,
				13);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 600, 93, 0,
				21, 11);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 749, 109, 0, 32,
				14);
		Helm h = new Helm(iset, "Helmet", 70, ItemTyp.HEAVY, 700, 109, 0, 32,
				11);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 850, 109, 0, 33,
				15);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateHeremonSoft() {
		String setname = "Heremon Soft";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(230, 0, 77));
		boni.add(new ItemSetBonus(270, 0, 107));
		boni.add(new ItemSetBonus(315, 0, 126));
		boni.add(new ItemSetBonus(380, 0, 175));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.LIGHT, 774, 28, 123, 49,
				12);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.HEAVY, 887, 35, 220, 55,
				18);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.HEAVY, 759, 29, 155,
				49, 15);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.LIGHT, 838, 34, 148, 54,
				15);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.LIGHT, 800, 33, 135, 50, 14);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generatePirateLeather() {
		String setname = "Leather Pirate";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_lan_kai);

		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.HEAVY, 986, 113, 13, 67,
				13);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.HEAVY, 972, 112, 13,
				62, 13);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.LIGHT, 1037, 124, 13,
				52, 16);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.LIGHT, 1011, 114, 13, 58,
				15);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.LIGHT, 1084, 123, 13,
				52, 17);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generatePirate() {
		String setname = "Pirate";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_lan_kai_kar);

		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.HEAVY, 1086, 109, 9, 63,
				14);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.HEAVY, 1072, 108, 9,
				58, 14);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.HEAVY, 1137, 120, 9, 48,
				17);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.LIGHT, 1111, 110, 9, 54, 16);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.LIGHT, 1184, 119, 9, 48,
				18);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateNobleseWitch() {
		String setname = "Noblese Witch";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(230, 0, 77));
		boni.add(new ItemSetBonus(270, 0, 107));
		boni.add(new ItemSetBonus(315, 0, 126));
		boni.add(new ItemSetBonus(384, 0, 175));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.PLATE, 875, 31, 128, 54,
				13);
		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 835, 32, 161,
				54, 16);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.HEAVY, 922, 37, 151, 59,
				16);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.PLATE, 904, 36, 140, 55, 15);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.HEAVY, 869, 39, 216, 61,
				18);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateNighthawkLight() {
		String setname = "Nighthawk Light";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(196, 0, 0));
		boni.add(new ItemSetBonus(231, 0, 0));
		boni.add(new ItemSetBonus(315, 0, 92));
		boni.add(new ItemSetBonus(387, 0, 133));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 408, 0, 103, 22,
				10);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 456, 0, 115, 24, 11);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 408, 0, 103,
				22, 10);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 576, 0, 146, 31,
				14);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 552, 0, 140, 29,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generatePhantomLight() {
		String setname = "Phantom Light";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(206, 0, 0));
		boni.add(new ItemSetBonus(241, 0, 0));
		boni.add(new ItemSetBonus(325, 22, 102));
		boni.add(new ItemSetBonus(397, 41, 143));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 424, 0, 103, 27,
				8);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 399, 0, 103,
				27, 8);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 502, 0, 140, 30,
				9);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 473, 0, 119, 30, 8);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 565, 0, 140, 31,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateRoyalGuardLight() {
		String setname = "Royal Guard Light";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona + " " + vella);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.HEAVY, 604, 93, 0, 21,
				13);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 600, 93, 0,
				21, 11);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 749, 109, 0, 32,
				14);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.HEAVY, 700, 109, 0, 32, 11);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 850, 109, 0, 33,
				15);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

	}

	static void generateLightwind() {
		String setname = "Lightwind";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(vella);

		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 763, 102, 0, 25,
				9);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 650, 90, 0, 20, 7);
		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 413, 94, 0,
				55, 7);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 594, 95, 0, 60, 8);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 677, 112, 0, 25,
				8);

		a.setStamina(7);
		s.setStamina(4);
		g.setStamina(4);
		h.setStamina(5);
		p.setStamina(5);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		sets.add(setname + " 3*");

		Armor aa = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 763, 102, 0, 25,
				9);
		Shoes ss = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 650, 90, 0, 20,
				7);
		Gloves gg = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 413, 94, 0,
				55, 7);
		Helm hh = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 594, 95, 0, 60, 8);
		Pants pp = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 677, 112, 0, 25,
				8);

		aa.setStamina(7);
		ss.setStamina(4);
		gg.setStamina(4);
		hh.setStamina(5);
		pp.setStamina(5);

		aa.setStars(3);
		ss.setStars(3);
		gg.setStars(3);
		hh.setStars(3);
		pp.setStars(3);

		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

	}

	static void generateRaiders() {
		String setname = "Raiders";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(142, 65, 0));
		boni.add(new ItemSetBonus(156, 94, 0));
		boni.add(new ItemSetBonus(181, 125, 0));
		boni.add(new ItemSetBonus(191, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.LIGHT, 300, 112, 0, 21,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.LIGHT, 337, 112, 0, 21, 11);
		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.LIGHT, 281, 113, 0,
				22, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.LIGHT, 405, 118, 0, 21,
				13);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.LIGHT, 359, 112, 0, 24,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		sets.add(setname + " 3*");

		Shoes ss = new Shoes(iset, "Shoes", 60, ItemTyp.LIGHT, 300, 112, 0, 21,
				10);
		Helm hh = new Helm(iset, "Helm", 60, ItemTyp.LIGHT, 337, 112, 0, 21, 11);
		Gloves gg = new Gloves(iset, "Gloves", 60, ItemTyp.LIGHT, 281, 113, 0,
				22, 10);
		Armor aa = new Armor(iset, "Armor", 60, ItemTyp.LIGHT, 405, 118, 0, 21,
				13);
		Pants pp = new Pants(iset, "Pants", 60, ItemTyp.LIGHT, 359, 112, 0, 24,
				11);

		ss.setStars(3);
		pp.setStars(3);
		gg.setStars(3);
		aa.setStars(3);
		hh.setStars(3);
		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

	}

	static void generateBlackHammer() {
		String setname = "Black Hammer";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(190, 76, 0, 30));
		boni.add(new ItemSetBonus(230, 101, 0, 35));
		boni.add(new ItemSetBonus(275, 111, 0, 40));
		boni.add(new ItemSetBonus(315, 126, 0, 45));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 488, 94, 0, 25, 9);
		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 462, 89, 0,
				27, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 700, 107, 0, 35,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 663, 97, 0, 29, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 781, 105, 0, 40,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		sets.add(setname + " 3*");

		Shoes ss = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 488, 94, 0, 25,
				9);
		Gloves gg = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 462, 89, 0,
				27, 9);
		Pants pp = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 700, 107, 0, 35,
				10);
		Helm hh = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 663, 97, 0, 29, 10);
		Armor aa = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 781, 105, 0, 40,
				12);

		ss.setStars(3);
		pp.setStars(3);
		gg.setStars(3);
		aa.setStars(3);
		hh.setStars(3);
		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

	}

	static void generateShiningWill() {
		String setname = "Shining Will";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 35, 0));
		boni.add(new ItemSetBonus(165, 50, 0));
		ItemSetBonus ab = new ItemSetBonus(180, 70, 0);
		ab.setAtk(246);
		boni.add(ab);
		ItemSetBonus b = new ItemSetBonus(210, 90, 0);
		b.setAtk(246);
		boni.add(b);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona);

		Shoes s = new Shoes(iset, "Shoes", 54, ItemTyp.PLATE, 524, 88, 0, 10, 8);
		Gloves g = new Gloves(iset, "Gloves", 54, ItemTyp.PLATE, 496, 86, 0, 9,
				8);
		Helm h = new Helm(iset, "Helm", 54, ItemTyp.PLATE, 583, 90, 0, 8, 9);
		Armor a = new Armor(iset, "Armor", 54, ItemTyp.PLATE, 689, 87, 0, 10,
				11);
		Pants p = new Pants(iset, "Pants", 54, ItemTyp.PLATE, 617, 89, 0, 11, 9);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		sets.add(setname + " 3*");

		Shoes ss = new Shoes(iset, "Shoes", 54, ItemTyp.PLATE, 524, 88, 0, 10,
				8);
		Gloves gg = new Gloves(iset, "Gloves", 54, ItemTyp.PLATE, 496, 86, 0,
				9, 8);
		Helm hh = new Helm(iset, "Helm", 54, ItemTyp.PLATE, 583, 90, 0, 8, 9);
		Armor aa = new Armor(iset, "Armor", 54, ItemTyp.PLATE, 689, 87, 0, 10,
				11);
		Pants pp = new Pants(iset, "Pants", 54, ItemTyp.PLATE, 617, 89, 0, 11,
				9);

		ss.setStars(3);
		pp.setStars(3);
		gg.setStars(3);
		aa.setStars(3);
		hh.setStars(3);
		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

	}

	static void generateSwift() {
		String setname = "Swift";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(180, 111, 0, 35));
		boni.add(new ItemSetBonus(225, 124, 0, 55));
		boni.add(new ItemSetBonus(275, 137, 0, 75));
		boni.add(new ItemSetBonus(315, 150, 0, 95));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 476, 90, 0, 20, 9);
		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 450, 92, 0,
				21, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 678, 97, 0, 20,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 641, 93, 0, 18, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 759, 95, 0, 21,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		sets.add(setname + " 3*");

		Shoes ss = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 476, 90, 0, 20,
				9);
		Gloves gg = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 450, 92, 0,
				21, 9);
		Pants pp = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 678, 97, 0, 20,
				10);
		Helm hh = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 641, 93, 0, 18, 10);
		Armor aa = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 759, 95, 0, 21,
				12);

		ss.setStars(3);
		pp.setStars(3);
		gg.setStars(3);
		aa.setStars(3);
		hh.setStars(3);
		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);

	}

	static void generateSilentQue() {
		String setname = "Silent  Quemielle";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona);

		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 526, 92, 0, 22, 7);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 742, 115, 0, 26,
				10);
		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.PLATE, 522, 92, 0,
				22, 7);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 610, 98, 0, 24, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 652, 98, 0, 24, 9);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateHolyWing() {
		String setname = "Holy Wing";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 55, 0));
		boni.add(new ItemSetBonus(220, 76, 0));
		boni.add(new ItemSetBonus(280, 93, 0));
		boni.add(new ItemSetBonus(330, 118, 0, 50));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.PLATE, 516, 92, 0,
				20, 9);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 618, 99, 0, 18, 10);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 550, 92, 0, 20, 9);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 743, 107, 0, 25,
				12);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 657, 110, 0, 25,
				10);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateRoyalGHeavy() {
		String setname = "Royal Guard Heavy";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(190, 82, 0));
		boni.add(new ItemSetBonus(210, 106, 0));
		boni.add(new ItemSetBonus(230, 134, 0));
		boni.add(new ItemSetBonus(295, 164, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_lan_kai_kar);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.HEAVY, 604, 93, 0, 21,
				13);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 600, 93, 0,
				21, 11);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 749, 109, 0, 32,
				14);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.HEAVY, 700, 109, 0, 32, 11);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 850, 109, 0, 33,
				15);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateImperialSoft() {
		String setname = "Imperial Guard Soft";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(195, 0, 0));
		boni.add(new ItemSetBonus(230, 0, 0));
		boni.add(new ItemSetBonus(270, 25, 110));
		boni.add(new ItemSetBonus(330, 45, 160));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 395, 0, 113, 22,
				11);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 372, 0, 106,
				22, 9);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 470, 0, 132, 23,
				12);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 442, 0, 106, 23, 9);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 532, 0, 140, 25,
				13);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateImperialHard() {
		String setname = "Imperial Guard Hard";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(202, 68, 0));
		boni.add(new ItemSetBonus(222, 92, 0));
		boni.add(new ItemSetBonus(297, 120, 0));
		boni.add(new ItemSetBonus(375, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(fiona + " " + vella);

		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.HEAVY, 604, 93, 0, 21,
				13);
		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.HEAVY, 600, 93, 0,
				21, 11);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.HEAVY, 749, 109, 0, 32,
				14);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.HEAVY, 700, 109, 0, 32, 11);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.HEAVY, 850, 109, 0, 33,
				15);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateSkeletonWitch() {
		String setname = "Skeleton Witch";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(226, 0, 80));
		boni.add(new ItemSetBonus(265, 0, 112));
		boni.add(new ItemSetBonus(310, 0, 132));
		boni.add(new ItemSetBonus(378, 0, 184));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 759, 33, 127,
				49, 13);
		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.PLATE, 773, 31, 127, 49,
				13);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.PLATE, 837, 38, 153, 53,
				16);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.PLATE, 810, 37, 135, 50, 15);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.PLATE, 887, 39, 161, 55,
				17);

		g.setStamina(5);
		s.setStamina(5);
		p.setStamina(7);
		h.setStamina(6);
		a.setStamina(7);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateSkeleton() {
		String setname = "Skeleton";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(191, 75, 0));
		boni.add(new ItemSetBonus(216, 103, 0));
		boni.add(new ItemSetBonus(287, 133, 0));
		boni.add(new ItemSetBonus(363, 165, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 941, 123, 14,
				68, 14);
		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.PLATE, 950, 124, 14, 73,
				14);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.PLATE, 1005, 136, 14,
				57, 17);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.PLATE, 980, 125, 14, 63, 15);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.PLATE, 1050, 135, 14,
				57, 18);

		g.setStamina(5);
		s.setStamina(5);
		p.setStamina(7);
		h.setStamina(6);
		a.setStamina(7);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateChampionSoft() {
		String setname = "Champion Soft";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(195, 0, 0));
		boni.add(new ItemSetBonus(230, 0, 0));
		boni.add(new ItemSetBonus(270, 25, 110));
		boni.add(new ItemSetBonus(330, 45, 160));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 343, 8, 109,
				26, 7);
		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 344, 8, 109, 27,
				7);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 412, 10, 145, 30,
				8);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 390, 9, 125, 27, 8);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 456, 11, 145, 30,
				10);

		g.setStamina(4);
		s.setStamina(4);
		p.setStamina(6);
		h.setStamina(5);
		a.setStamina(6);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateChampion() {
		String setname = "Champion";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 72, 0));
		boni.add(new ItemSetBonus(164, 104, 0));
		boni.add(new ItemSetBonus(191, 138, 0));
		boni.add(new ItemSetBonus(206, 170, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 479, 107, 0,
				37, 8);
		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 475, 108, 0, 37,
				8);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 536, 109, 0, 41,
				10);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 511, 106, 0, 43, 9);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 584, 111, 0, 51,
				12);

		g.setStamina(4);
		s.setStamina(4);
		p.setStamina(6);
		h.setStamina(5);
		a.setStamina(6);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateWEdge() {
		String setname = "Warrior Edge";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 35, 0));
		boni.add(new ItemSetBonus(165, 50, 0));
		boni.add(new ItemSetBonus(180, 70, 0, 0, 246));
		boni.add(new ItemSetBonus(210, 90, 0, 0, 246));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(hurk);
		Gloves g = new Gloves(iset, "Gloves", 54, ItemTyp.PLATE, 496, 86, 0, 9,
				8);
		Shoes s = new Shoes(iset, "Shoes", 54, ItemTyp.PLATE, 524, 88, 0, 10, 8);
		Pants p = new Pants(iset, "Pants", 54, ItemTyp.PLATE, 617, 89, 0, 11, 9);
		Helm h = new Helm(iset, "Helm", 54, ItemTyp.PLATE, 583, 90, 0, 9, 9);
		Armor a = new Armor(iset, "Armor", 54, ItemTyp.PLATE, 689, 87, 0, 10,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);

		Gloves gg = new Gloves(iset, "Gloves", 54, ItemTyp.PLATE, 496, 86, 0,
				9, 8);
		Shoes ss = new Shoes(iset, "Shoes", 54, ItemTyp.PLATE, 524, 88, 0, 10,
				8);
		Pants pp = new Pants(iset, "Pants", 54, ItemTyp.PLATE, 617, 89, 0, 11,
				9);
		Helm hh = new Helm(iset, "Helm", 54, ItemTyp.PLATE, 583, 90, 0, 9, 9);
		Armor aa = new Armor(iset, "Armor", 54, ItemTyp.PLATE, 689, 87, 0, 10,
				11);
		sets.add(setname + " 3*");
		ss.setStars(3);
		gg.setStars(3);
		pp.setStars(3);
		aa.setStars(3);
		hh.setStars(3);

		shoes.add(ss);
		gloves.add(gg);
		pants.add(pp);
		armors.add(aa);
		helms.add(hh);
	}

	static void generateK9() {
		String setname = "K-9";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(hurk);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 496, 92, 0,
				20, 9);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 530, 92, 0, 20, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 657, 110, 0, 25,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 598, 99, 0, 18, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 743, 107, 0, 25,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateHMagnum() {
		String setname = "Hundred Magnum";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(hurk);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.PLATE, 492, 92, 0,
				22, 7);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 496, 92, 0, 22, 7);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 652, 98, 0, 24, 9);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.PLATE, 580, 98, 0, 24, 9);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 742, 115, 0, 26,
				10);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateMajest() {
		String setname = "Majest";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(192, 58, 0));
		boni.add(new ItemSetBonus(212, 82, 0));
		boni.add(new ItemSetBonus(287, 110, 0));
		boni.add(new ItemSetBonus(365, 140, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_lan_kai_kar);

		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.PLATE, 721, 100, 0,
				17, 7);
		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.PLATE, 714, 100, 0, 17,
				7);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.PLATE, 734, 114, 0, 24,
				10);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 555, 100, 0, 19, 9);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.PLATE, 794, 114, 0, 25,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateMajestLeather() {
		String setname = "Majest Leather";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(192, 58, 0));
		boni.add(new ItemSetBonus(212, 82, 0));
		boni.add(new ItemSetBonus(287, 110, 0));
		boni.add(new ItemSetBonus(365, 140, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(vella + " " + fiona);

		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 621, 105, 0,
				17, 7);
		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 614, 105, 0, 17,
				7);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 634, 119, 0, 24,
				10);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 455, 105, 0, 19, 9);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 694, 119, 0, 25,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateMajestSoft() {
		String setname = "Majest Soft";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(196, 0, 75));
		boni.add(new ItemSetBonus(231, 0, 95));
		boni.add(new ItemSetBonus(315, 0, 115));
		boni.add(new ItemSetBonus(387, 0, 135));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Gloves g = new Gloves(iset, "Gloves", 70, ItemTyp.LIGHT, 369, 0, 114,
				19, 7);
		Shoes s = new Shoes(iset, "Shoes", 70, ItemTyp.LIGHT, 383, 0, 114, 19,
				7);
		Pants p = new Pants(iset, "Pants", 70, ItemTyp.LIGHT, 444, 0, 140, 16,
				10);
		Helm h = new Helm(iset, "Helm", 70, ItemTyp.LIGHT, 418, 0, 121, 21, 9);
		Armor a = new Armor(iset, "Armor", 70, ItemTyp.LIGHT, 491, 0, 148, 28,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateArmageddon() {
		String setname = "Armageddon";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(135, 60, 0));
		boni.add(new ItemSetBonus(210, 90, 0));
		boni.add(new ItemSetBonus(285, 120, 0));
		boni.add(new ItemSetBonus(360, 150, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee);

		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.PLATE, 1030, 138, 4,
				53, 12);
		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.PLATE, 940, 140, 4, 58,
				12);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.PLATE, 1040, 153, 4, 43,
				15);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.PLATE, 1190, 138, 4, 49, 14);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.PLATE, 1240, 154, 4, 43,
				16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateArmageddonWitch() {
		String setname = "Armageddon Witch";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(284, 0, 80));
		boni.add(new ItemSetBonus(334, 0, 110));
		boni.add(new ItemSetBonus(384, 0, 140));
		boni.add(new ItemSetBonus(434, 0, 170));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(magic);

		Gloves g = new Gloves(iset, "Gloves", 80, ItemTyp.HEAVY, 885, 25, 160,
				43, 13);
		Shoes s = new Shoes(iset, "Shoes", 80, ItemTyp.PLATE, 925, 24, 127, 43,
				10);
		Pants p = new Pants(iset, "Pants", 80, ItemTyp.HEAVY, 972, 30, 150, 48,
				13);
		Helm h = new Helm(iset, "Helm", 80, ItemTyp.PLATE, 954, 29, 139, 44, 12);
		Armor a = new Armor(iset, "Armor", 80, ItemTyp.LIGHT, 919, 31, 215, 50,
				15);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateSoulloop() {
		String setname = "Soul Loop";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 35, 0));
		boni.add(new ItemSetBonus(165, 50, 0));
		ItemSetBonus ab = new ItemSetBonus(180, 70, 0);
		ab.setAtk(246);
		boni.add(ab);
		ItemSetBonus b = new ItemSetBonus(210, 90, 0);
		b.setAtk(246);
		boni.add(b);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(lynn);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 496, 86, 0, 9,
				8);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 524, 88, 0, 10, 8);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.HEAVY, 617, 89, 0, 11, 9);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 583, 90, 0, 9, 9);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.HEAVY, 689, 87, 0, 10,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateOriental() {
		String setname = "Oriental Odyssey";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(lynn);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 496, 92, 0,
				20, 9);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 530, 92, 0, 20, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 657, 110, 0, 25,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 598, 99, 0, 18, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 743, 107, 0, 25,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateDancing() {
		String setname = "Dancing Blade";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(99, 65, 0));
		boni.add(new ItemSetBonus(109, 94, 0));
		boni.add(new ItemSetBonus(126, 125, 0));
		boni.add(new ItemSetBonus(137, 154, 0));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(lynn);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 413, 92, 0,
				55, 9);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.PLATE, 650, 92, 0, 20, 9);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.PLATE, 677, 110, 0, 25,
				10);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 594, 99, 0, 60, 10);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.PLATE, 763, 107, 0, 25,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateApex() {
		String setname = "Apex Senior";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(116, 0, 0));
		boni.add(new ItemSetBonus(128, 0, 0));
		boni.add(new ItemSetBonus(148, 0, 82));
		boni.add(new ItemSetBonus(160, 0, 124));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(arisha);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.CLOTH, 215, 0, 114,
				37, 9);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.CLOTH, 233, 0, 121, 38,
				11);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.CLOTH, 298, 0, 142, 42,
				11);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.CLOTH, 256, 0, 130, 44, 9);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.CLOTH, 331, 0, 140, 45,
				12);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateSilverFox() {
		String setname = "Silver Fox";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(90, 0, 0));
		boni.add(new ItemSetBonus(145, 0, 0));
		boni.add(new ItemSetBonus(180, 0, 84));
		boni.add(new ItemSetBonus(240, 0, 125));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(arisha);

		Gloves g = new Gloves(iset, "Gloves", 60, ItemTyp.HEAVY, 335, 13, 86,
				20, 10);
		Shoes s = new Shoes(iset, "Shoes", 60, ItemTyp.HEAVY, 322, 12, 86, 19,
				10);
		Pants p = new Pants(iset, "Pants", 60, ItemTyp.LIGHT, 512, 16, 98, 23,
				11);
		Helm h = new Helm(iset, "Helm", 60, ItemTyp.HEAVY, 452, 15, 86, 22, 12);
		Armor a = new Armor(iset, "Armor", 60, ItemTyp.HEAVY, 577, 15, 94, 21,
				13);
		g.setStamina(2);
		s.setStamina(2);
		p.setStamina(3);
		h.setStamina(2);
		a.setStamina(3);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateStriker() {
		String setname = "L Strike";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(150, 0, 12));
		boni.add(new ItemSetBonus(165, 0, 24));
		boni.add(new ItemSetBonus(180, 0, 39));
		boni.add(new ItemSetBonus(210, 0, 52));

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(arisha);

		Gloves g = new Gloves(iset, "Gloves", 54, ItemTyp.CLOTH, 256, 0, 98,
				18, 8);
		Shoes s = new Shoes(iset, "Shoes", 54, ItemTyp.CLOTH, 267, 0, 99, 17, 8);
		Pants p = new Pants(iset, "Pants", 54, ItemTyp.CLOTH, 300, 0, 97, 19, 9);
		Helm h = new Helm(iset, "Helm", 54, ItemTyp.CLOTH, 272, 0, 98, 15, 8);
		Armor a = new Armor(iset, "Armor", 54, ItemTyp.CLOTH, 326, 0, 99, 17,
				11);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateRegina_3_min() {
		String setname = "Regina (Orange minimum)";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(0, 0, 0));
		ItemSetBonus sonderbonus1 = new ItemSetBonus(165, 60, 81);
		sonderbonus1.setSta(5);
		boni.add(sonderbonus1);

		ItemSetBonus sonderbonus2 = new ItemSetBonus(220, 80, 108);
		sonderbonus2.setSta(6);
		boni.add(sonderbonus2);
		
		ItemSetBonus sonderbonus3 = new ItemSetBonus(275, 100,135);
		sonderbonus3.setSta(7);
		boni.add(sonderbonus3);
		
		ItemSetBonus sonderbonus4 = new ItemSetBonus(330, 120, 162);
		sonderbonus4.setSta(10);
		boni.add(sonderbonus4);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee + " " + magic);

		Gloves g = new Gloves(iset, "Gloves", 90, ItemTyp.PLATE, 1255, 144,
				194, 72, 13);
		Shoes s = new Shoes(iset, "Shoes", 90, ItemTyp.PLATE, 1255, 144, 194,
				72, 13);
		Helm h = new Helm(iset, "Helm", 90, ItemTyp.PLATE, 1255, 144, 194, 72,
				13);

		Pants p = new Pants(iset, "Pants", 90, ItemTyp.PLATE, 1355, 144, 194,
				72, 18);
		Armor a = new Armor(iset, "Armor", 90, ItemTyp.PLATE, 1422, 144, 194,
				72, 16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}
	static void generateBarha_3_min() {
		String setname = "Barha (Orange minimum)";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(0, 0, 0));
		ItemSetBonus sonderbonus1 = new ItemSetBonus(165, 60, 81);
		sonderbonus1.setSta(5);
		boni.add(sonderbonus1);

		ItemSetBonus sonderbonus2 = new ItemSetBonus(220, 80, 108);
		sonderbonus2.setSta(6);
		boni.add(sonderbonus2);
		
		ItemSetBonus sonderbonus3 = new ItemSetBonus(275, 100,135);
		sonderbonus3.setSta(7);
		boni.add(sonderbonus3);
		
		ItemSetBonus sonderbonus4 = new ItemSetBonus(330, 120, 162);
		sonderbonus4.setSta(10);
		boni.add(sonderbonus4);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee + " " + magic);

		Gloves g = new Gloves(iset, "Gloves", 90, ItemTyp.HEAVY, 1255, 144,
				194, 72, 13);
		Shoes s = new Shoes(iset, "Shoes", 90, ItemTyp.HEAVY, 1255, 144, 194,
				72, 13);
		Helm h = new Helm(iset, "Helm", 90, ItemTyp.HEAVY, 1255, 144, 194, 72,
				13);

		Pants p = new Pants(iset, "Pants", 90, ItemTyp.HEAVY, 1355, 144, 194,
				72, 18);
		Armor a = new Armor(iset, "Armor", 90, ItemTyp.HEAVY, 1422, 144, 194,
				72, 16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}

	static void generateGuardian_3_min() {
		String setname = "Guardian (Orange minimum)";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(0, 0, 0));
		ItemSetBonus sonderbonus1 = new ItemSetBonus(165, 60, 81);
		sonderbonus1.setSta(5);
		boni.add(sonderbonus1);

		ItemSetBonus sonderbonus2 = new ItemSetBonus(220, 80, 108);
		sonderbonus2.setSta(6);
		boni.add(sonderbonus2);
		
		ItemSetBonus sonderbonus3 = new ItemSetBonus(275, 100,135);
		sonderbonus3.setSta(7);
		boni.add(sonderbonus3);
		
		ItemSetBonus sonderbonus4 = new ItemSetBonus(330, 120, 162);
		sonderbonus4.setSta(10);
		boni.add(sonderbonus4);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee + " " + magic);

		Gloves g = new Gloves(iset, "Gloves", 90, ItemTyp.LIGHT, 1255, 144,
				194, 72, 13);
		Shoes s = new Shoes(iset, "Shoes", 90, ItemTyp.LIGHT, 1255, 144, 194,
				72, 13);
		Helm h = new Helm(iset, "Helm", 90, ItemTyp.LIGHT, 1255, 144, 194, 72,
				13);

		Pants p = new Pants(iset, "Pants", 90, ItemTyp.LIGHT, 1355, 144, 194,
				72, 18);
		Armor a = new Armor(iset, "Armor", 90, ItemTyp.LIGHT, 1422, 144, 194,
				72, 16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}
	
	static void generateCloth_3_min() {
		String setname = "Cloth90 (Orange minimum)";
		sets.add(setname);
		List<ItemSetBonus> boni = new ArrayList<ItemSetBonus>();
		boni.add(new ItemSetBonus(0, 0, 0));
		ItemSetBonus sonderbonus1 = new ItemSetBonus(165, 60, 81);
		sonderbonus1.setSta(5);
		boni.add(sonderbonus1);

		ItemSetBonus sonderbonus2 = new ItemSetBonus(220, 80, 108);
		sonderbonus2.setSta(6);
		boni.add(sonderbonus2);
		
		ItemSetBonus sonderbonus3 = new ItemSetBonus(275, 100,135);
		sonderbonus3.setSta(7);
		boni.add(sonderbonus3);
		
		ItemSetBonus sonderbonus4 = new ItemSetBonus(330, 120, 162);
		sonderbonus4.setSta(10);
		boni.add(sonderbonus4);

		ItemSet iset = new ItemSet(setname, boni);
		iset.setUsefulChars(char_melee + " " + magic);

		Gloves g = new Gloves(iset, "Gloves", 90, ItemTyp.CLOTH, 1255, 144,
				194, 72, 13);
		Shoes s = new Shoes(iset, "Shoes", 90, ItemTyp.CLOTH, 1255, 144, 194,
				72, 13);
		Helm h = new Helm(iset, "Helm", 90, ItemTyp.CLOTH, 1255, 144, 194, 72,
				13);

		Pants p = new Pants(iset, "Pants", 90, ItemTyp.CLOTH, 1355, 144, 194,
				72, 18);
		Armor a = new Armor(iset, "Armor", 90, ItemTyp.CLOTH, 1422, 144, 194,
				72, 16);

		shoes.add(s);
		gloves.add(g);
		pants.add(p);
		armors.add(a);
		helms.add(h);
	}
	
	public static void staticImAndExport() {
		// 60 sets
		generateWonderland();
		generateLightwind();
		generateRaiders();
		generateBlackHammer();
		generateShiningWill();
		generateSwift();
		generateSilentQue();
		generateHolyWing();

		// 70 sets
		generateChampion();
		generateChampionSoft();
		generateImperialHard();
		generateImperialSoft();
		generateRoyalGHeavy();
		generateMhara();
		generateEverlastingEvie();
		generateApocryphal();
		generateEverlastingFio();
		generateNighthawk();
		generatePhantomHeavy();
		generateRoyalGuard();
		generateNighthawkLight();
		generatePhantomLight();

		// 80 sets
		generateSkeleton();
		generateSkeletonWitch();
		generatePearlClassic();
		generateBlackPearl();
		generateHeremon();
		generateNoblesse();
		generateHeremonSoft();
		generatePirateLeather();
		generatePirate();
		generateNobleseWitch();

		// neue sets
		generateWEdge();
		generateK9();
		generateHMagnum();

		// Episode 4 Season 2
		generateMajest();
		generateMajestLeather();
		generateMajestSoft();
		generateArmageddon();
		generateArmageddonWitch();

		// Lynn
		generateSoulloop();
		generateOriental();
		generateDancing();

		// arisha
		generateApex();
		generateSilverFox();
		generateStriker();

		// 90 gear
		generateRegina_3_min();
		generateBarha_3_min();
		generateGuardian_3_min();
		generateCloth_3_min();
	}

	public static void staticExportSets() {
		HashSet<ItemSet> setnames = new HashSet<>();

		for (Shoes s : shoes) {
			setnames.add(s.getItemset());
		}
		for (Pants s : pants) {
			setnames.add(s.getItemset());
		}
		for (Gloves s : gloves) {
			setnames.add(s.getItemset());
		}
		for (Armor s : armors) {
			setnames.add(s.getItemset());
		}
		for (Helm s : helms) {
			setnames.add(s.getItemset());
		}
		isets = setnames;
		try {
			File outd = new File("data" + File.separator);
			outd.mkdirs();
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("data"
							+ File.separator + "_sets.xml"), "UTF-8"));

			JAXBContext context = JAXBContext.newInstance(ItemSets.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(new ItemSets(setnames), out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void exportPricesCSV() {
		StringBuilder sb = new StringBuilder();

		sb.append("id;price;Typ;Set;Itemname;Level;Stars;Useful;Armortype;");
		sb.append("\n");

		for (Shoes s : shoes) {
			String x = s.getPrice() + "";
			x = x.replace(".", ",");
			sb.append(s.getId() + ";" + x + ";Shoes;"
					+ s.getItemset().getName() + ";" + s.getName() + ";"
					+ s.getLevel() + ";" + s.getStars() + ";"
					+ s.getItemset().getUsefulChars() + ";" + s.getTyp());
			sb.append("\n");
		}
		for (Pants s : pants) {
			String x = s.getPrice() + "";
			x = x.replace(".", ",");
			sb.append(s.getId() + ";" + x + ";Pants;"
					+ s.getItemset().getName() + ";" + s.getName() + ";"
					+ s.getLevel() + ";" + s.getStars() + ";"
					+ s.getItemset().getUsefulChars() + ";" + s.getTyp());
			sb.append("\n");
		}
		for (Gloves s : gloves) {
			String x = s.getPrice() + "";
			x = x.replace(".", ",");
			sb.append(s.getId() + ";" + x + ";Gloves;"
					+ s.getItemset().getName() + ";" + s.getName() + ";"
					+ s.getLevel() + ";" + s.getStars() + ";"
					+ s.getItemset().getUsefulChars() + ";" + s.getTyp());
			sb.append("\n");
		}
		for (Armor s : armors) {
			String x = s.getPrice() + "";
			x = x.replace(".", ",");
			sb.append(s.getId() + ";" + x + ";Armor;"
					+ s.getItemset().getName() + ";" + s.getName() + ";"
					+ s.getLevel() + ";" + s.getStars() + ";"
					+ s.getItemset().getUsefulChars() + ";" + s.getTyp());
			sb.append("\n");
		}
		for (Helm s : helms) {
			String x = s.getPrice() + "";
			x = x.replace(".", ",");
			sb.append(s.getId() + ";" + x + ";Helm;" + s.getItemset().getName()
					+ ";" + s.getName() + ";" + s.getLevel() + ";"
					+ s.getStars() + ";" + s.getItemset().getUsefulChars()
					+ ";" + s.getTyp());
			sb.append("\n");
		}

		try {
			File outd = new File("data" + File.separator);
			outd.mkdirs();
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("data"
							+ File.separator + "prices.csv"), "UTF-8"));

			out.write(sb.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void importPrices() {
		List<String> slist = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("data"
							+ File.separator + "prices.csv"), "UTF-8"));

			String line = br.readLine();
			slist.add(line);
			while (line != null) {
				line = br.readLine();
				slist.add(line);
			}
			br.close();
		} catch (Exception e) {
		}

		for (Shoes s : shoes) {
			itemmap.put(s.getId(), s);
		}
		for (Pants s : pants) {
			itemmap.put(s.getId(), s);
		}
		for (Gloves s : gloves) {
			itemmap.put(s.getId(), s);
		}
		for (Armor s : armors) {
			itemmap.put(s.getId(), s);
		}
		for (Helm s : helms) {
			itemmap.put(s.getId(), s);
		}

		for (int i = 1; i < slist.size() - 1; i++) {
			String x = slist.get(i);
			String[] split = x.split(";");
			int id = new Integer(split[0]);
			double newprice = new Double(split[1].replace(",", "."));

			Item itam = itemmap.get(id);

			if (itam != null) {
				itam.setPrice(newprice);
			}

		}

	}

	private static void exportItems() {
		try {
			File outd = new File("data" + File.separator);
			outd.mkdirs();
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("data"
							+ File.separator + "static.xml"), "UTF-8"));

			JAXBContext context = JAXBContext.newInstance(Items.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(new Items(isets, shoes, pants, gloves, armors, helms),
					out);
			System.out.println("Static Export finished");
			System.out.println("Shoes: " + shoes.size());
			System.out.println("Pants: " + pants.size());
			System.out.println("Glove: " + gloves.size());
			System.out.println("Armor: " + armors.size());
			System.out.println("Helms: " + helms.size());
			System.out.println("Sets : " + sets);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		staticImAndExport();
		staticExportSets();
		File prices = new File("data" + File.separator + "prices.csv");
		if (!prices.exists()) {
			System.out.println("prices.csv not found, generating it...");
			exportPricesCSV();
		} else {
			System.out.println("prices.csv found, correcting prices");
			importPrices();
		}
		exportItems();
	}
}
