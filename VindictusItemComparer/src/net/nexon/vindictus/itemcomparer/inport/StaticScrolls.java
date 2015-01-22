package net.nexon.vindictus.itemcomparer.inport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import net.nexon.vindictus.itemcomparer.modell.ScrollRestriction;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;

public class StaticScrolls {

	private static ScrollProperty SCRPROP = new ScrollProperty();

	private static List<ItemTyp> CLOTH = new ArrayList<>();
	private static List<ItemTyp> CLOTH_LIGHT = new ArrayList<>();
	private static List<ItemTyp> HEAVY = new ArrayList<>();
	private static List<ItemTyp> HEAVY_PLATE = new ArrayList<>();
	private static List<ItemTyp> ALL_ITEMS = new ArrayList<>();

	private static List<String> ARMOR = new ArrayList<>();
	private static List<String> PANTS_HELM = new ArrayList<>();
	private static List<String> SHOES_GLOVES = new ArrayList<>();

	static {
		CLOTH.add(ItemTyp.CLOTH);
		CLOTH_LIGHT.add(ItemTyp.CLOTH);
		CLOTH_LIGHT.add(ItemTyp.LIGHT);
		HEAVY.add(ItemTyp.HEAVY);
		HEAVY_PLATE.add(ItemTyp.HEAVY);
		HEAVY_PLATE.add(ItemTyp.PLATE);
		ALL_ITEMS.add(ItemTyp.CLOTH);
		ALL_ITEMS.add(ItemTyp.LIGHT);
		ALL_ITEMS.add(ItemTyp.HEAVY);
		ALL_ITEMS.add(ItemTyp.PLATE);

		ARMOR.add("Armor");
		PANTS_HELM.add("Pants");
		PANTS_HELM.add("Helm");
		SHOES_GLOVES.add("Shoes");
		SHOES_GLOVES.add("Gloves");

	}

	private final static ScrollRestriction CLOTH_LIGHT_ALL = new ScrollRestriction(
			CLOTH_LIGHT);
	private final static ScrollRestriction HEAVY_ALL = new ScrollRestriction(
			HEAVY);
	private final static ScrollRestriction HEAVY_PLATE_ALL = new ScrollRestriction(
			HEAVY_PLATE);

	private final static ScrollRestriction CLOTH_LIGHT_PANTS_HELM = new ScrollRestriction(
			CLOTH_LIGHT, PANTS_HELM);
	private final static ScrollRestriction HEAVY_PLATE_PANTS_HELM = new ScrollRestriction(
			HEAVY_PLATE, PANTS_HELM);

	private final static ScrollRestriction CLOTH_LIGHT_SHOES_GLOVES = new ScrollRestriction(
			CLOTH_LIGHT, SHOES_GLOVES);
	private final static ScrollRestriction HEAVY_PLATE_SHOES_GLOVES = new ScrollRestriction(
			HEAVY_PLATE, SHOES_GLOVES);

	private final static ScrollRestriction CLOTH_ARMOR = new ScrollRestriction(
			CLOTH_LIGHT);
	private final static ScrollRestriction HEAVY_ARMOR = new ScrollRestriction(
			HEAVY, ARMOR);
	private final static ScrollRestriction ONLY_ARMOR = new ScrollRestriction(
			ALL_ITEMS, ARMOR);

	private static Scroll_Pre wb = new Scroll_Pre("Well-balanced", 0, 0, 0, 0,
			0, 0, SCRPROP.getWb(), CLOTH_LIGHT_ALL, 1, 1, -1, 2, 0,
			ItemTyp.CLOTH);
	private static Scroll_Pre tut = new Scroll_Pre("Tutelary", 112, 0, 0,
			SCRPROP.getTut(), HEAVY_PLATE_ALL);

	private static Scroll_Suf sent = new Scroll_Suf("Sentinel", 224, -15, 0,
			SCRPROP.getSenti(), HEAVY_PLATE_ALL);
	private static Scroll_Suf resist = new Scroll_Suf("Resistant", 340, -160,
			0, SCRPROP.getRes(), HEAVY_PLATE_ALL);
	private static Scroll_Suf armadil = new Scroll_Suf(5, "Armadillo", 336, 0,
			0, SCRPROP.getArmadi(), HEAVY_ALL);
	private static Scroll_Suf master = new Scroll_Suf("Master", 0, 0, 0,
			SCRPROP.getMaster(), -1, 5, 5, ONLY_ARMOR);
	public final static Scroll_Suf enthu = new Scroll_Suf("Enthu", -370, 270,
			282, SCRPROP.getEnthu(), 5, CLOTH_LIGHT_ALL);
	private static Scroll_Suf force = new Scroll_Suf("Force", -28, 140, 132,
			SCRPROP.getForce(), 2, CLOTH_LIGHT_ALL);

	private static Scroll_Pre enli = new Scroll_Pre("Enlightenment", 0, 210,
			210, 0, 0, 0, 0.0, CLOTH_LIGHT_PANTS_HELM, 2, 1, 1, 2, 35,
			ItemTyp.CLOTH);
	private static Scroll_Pre silent = new Scroll_Pre("Silent", 150, 110, 110,
			0, 0, 0, 0.0, CLOTH_LIGHT_SHOES_GLOVES, 1, 2, -2, 2, 35,
			ItemTyp.CLOTH);
	private static Scroll_Suf journey = new Scroll_Suf("Journey", 150, 250,
			250, 0, 0, 0, 0.0, CLOTH_LIGHT_PANTS_HELM, 1, 0, 3, 0, 35,
			ItemTyp.CLOTH);
	private static Scroll_Suf announc = new Scroll_Suf("Announcement", -330,
			330, 330, 0, 0, 0, 0.0, CLOTH_LIGHT_SHOES_GLOVES, 0, 4, 1, 1, 35,
			ItemTyp.CLOTH);

	private static Scroll_Pre remember = new Scroll_Pre("Remember", 100, 0, 0,
			0, 0, 0, 0.0, HEAVY_PLATE_PANTS_HELM, 2, 1, 2, 2, 35, ItemTyp.HEAVY);
	private static Scroll_Pre repe = new Scroll_Pre("Repeatsay", 150, 0, 0, 0,
			0, 0, 0.0, HEAVY_PLATE_SHOES_GLOVES, 1, 2, -1, 2, 35, ItemTyp.HEAVY);
	private static Scroll_Suf exped = new Scroll_Suf("Expedition", 280, 170,
			170, 0, 0, 0, 0.0, HEAVY_PLATE_PANTS_HELM, 0, 0, 4, 0, 35,
			ItemTyp.HEAVY);
	private static Scroll_Suf echo = new Scroll_Suf("Echo", -260, 190, 190, 0,
			0, 0, 0.0, HEAVY_PLATE_SHOES_GLOVES, 0, 4, 2, 1, 35, ItemTyp.HEAVY);

	private static Scroll_Pre time = new Scroll_Pre("Time", 160, 0, 0, 0, 0, 0,
			0.0, ONLY_ARMOR, 4, -3, 6, 0, 0, ItemTyp.CLOTH);
	private static Scroll_Suf stigma = new Scroll_Suf("Stigma", 70, 0, 0, 0, 0,
			0, 0.0, ONLY_ARMOR, 5, -1, 7, 0, 0, ItemTyp.CLOTH);

	public static List<Scroll_Pre> pres = new ArrayList<>();

	public static List<Scroll_Suf> sufs = new ArrayList<>();

	static {
		pres.add(wb);
		pres.add(tut);
		pres.add(enli);
		pres.add(silent);
		pres.add(remember);
		pres.add(repe);
		pres.add(time);

		sufs.add(force);
		sufs.add(enthu);
		sufs.add(sent);
		sufs.add(armadil);
		sufs.add(resist);
		sufs.add(journey);
		sufs.add(announc);
		sufs.add(exped);
		sufs.add(echo);
		sufs.add(stigma);
		sufs.add(master);

	}

	public static String[] prefix_Names() {

		String[] values = new String[pres.size()];

		for (int i = 0; i < pres.size(); i++) {
			values[i] = pres.get(i).getName();
		}
		Arrays.sort(values);

		return values;
	}

	public static String[] suffix_Names() {
		String[] values = new String[sufs.size()];
		for (int i = 0; i < sufs.size(); i++) {
			values[i] = sufs.get(i).getName();
		}
		Arrays.sort(values);

		return values;
	}

	public static Scroll_Pre searchPre(String name) throws Exception {
		for (Scroll_Pre x : pres) {
			if (name.equals(x.getName())) {
				return x;
			}
		}

		throw new Exception("Scroll not found");
	}

	public static Scroll_Suf searchSuf(String name) throws Exception {
		for (Scroll_Suf x : sufs) {
			if (name.equals(x.getName())) {
				return x;
			}
		}

		throw new Exception("Scroll not found");
	}
}
