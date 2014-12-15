package net.nexon.vindictus.itemcomparer.inport;

import java.util.ArrayList;
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

	private static Scroll_Pre wb = new Scroll_Pre("Well-balanced", 0, 0, 0,
			SCRPROP.getWb(), CLOTH_LIGHT_ALL);
	private static Scroll_Pre tut = new Scroll_Pre("Tutelary", 112, 0, 0,
			SCRPROP.getTut(), HEAVY_PLATE_ALL);

	private static Scroll_Suf sent = new Scroll_Suf("Sentinel", 224, -15, 0,
			SCRPROP.getSenti(), HEAVY_PLATE_ALL);
	private static Scroll_Suf resist = new Scroll_Suf("Resistant", 340, -160,
			0, SCRPROP.getRes(),HEAVY_PLATE_ALL);
	private static Scroll_Suf armadil = new Scroll_Suf(5, "Armadillo", 336, 0,
			0, SCRPROP.getArmadi(), HEAVY_ALL);
	private static Scroll_Suf master = new Scroll_Suf("Master", 0, 0, 0,
			SCRPROP.getMaster(), ONLY_ARMOR);
	public final static Scroll_Suf enthu = new Scroll_Suf("Enthu", -370, 270,
			282, SCRPROP.getEnthu(), CLOTH_LIGHT_ALL);
	private static Scroll_Suf force = new Scroll_Suf("Force", -28, 140, 132,
			SCRPROP.getForce(), CLOTH_LIGHT_ALL);

	public static List<Scroll_Pre> pres;

	public static List<Scroll_Suf> sufs;

	static {
		pres.add(wb);
		sufs.add(force);
	}
}
