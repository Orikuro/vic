package net.nexon.vindictus.itemcomparer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import net.nexon.vindictus.itemcomparer.inport.ScrollProperty;
import net.nexon.vindictus.itemcomparer.logic.comparators.ItemLevelComparator;
import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.enu.VChar;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class ItemLogic implements IItemLocal {

	private static ScrollProperty SCRPROP = new ScrollProperty();
	private static Scroll_Suf enthu = new Scroll_Suf("Enthu", -370, 270, 282,
			SCRPROP.getEnthu());
	private static Scroll_Suf force = new Scroll_Suf("Force", -28, 140, 132,
			SCRPROP.getForce());
	private static Scroll_Pre tut = new Scroll_Pre("Tutelary", 112, 0, 0,
			SCRPROP.getTut());
	private static Scroll_Pre wb = new Scroll_Pre("Well-balanced", 0, 0, 0,
			SCRPROP.getWb());
	private static Scroll_Suf sent = new Scroll_Suf("Sentinel", 224, -15, 0,
			SCRPROP.getSenti());
	private static Scroll_Suf resist = new Scroll_Suf("Resistant", 340, -160,
			0, SCRPROP.getRes());
	private static Scroll_Suf armadil = new Scroll_Suf(5, "Armadillo", 336, 0,
			0, SCRPROP.getArmadi());
	private static Scroll_Suf master = new Scroll_Suf("Master", 0, 0, 0,
			SCRPROP.getMaster());

	private List<Shoes> shoes_changed = new ArrayList<>();
	private List<Pants> pants_changed = new ArrayList<>();
	private List<Gloves> gloves_changed = new ArrayList<>();
	private List<Armor> armors_changed = new ArrayList<>();
	private List<Helm> helms_changed = new ArrayList<>();

	private void deleteChanged(Items items) {
		items.getShoes().removeAll(shoes_changed);
		items.getPants().removeAll(pants_changed);
		items.getArmors().removeAll(armors_changed);
		items.getGloves().removeAll(gloves_changed);
		items.getHelms().removeAll(helms_changed);

	}

	@Override
	public void duplicateEnthu(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, enthu);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, enthu);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, enthu);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, enthu);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, enthu);
		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	public void duplicateTutSentinel(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);
		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	public void duplicateForce(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, force);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, force);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, force);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, force);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, force);
		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	public void duplicateF_Enthu(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, enthu);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, enthu);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, enthu);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, enthu);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed, wb, force);
		List<Pants> new_p2 = addScrollsToPants(items, allowed, wb, force);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed, wb, force);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed, wb, force);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed, wb, force);

		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	@Override
	public void duplicateTS_Enthu(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, enthu);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, enthu);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, enthu);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, enthu);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_tut, tut, sent);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_tut, tut, sent);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_tut, tut, sent);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_tut, tut, sent);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_tut, tut, sent);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTA_Enthu(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, enthu);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, enthu);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, enthu);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, enthu);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_tut, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_tut, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_tut, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_tut, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_tut, tut, armadil);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTutResistant(Items items, boolean keepChanged) {

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_tut, tut, resist);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_tut, tut, resist);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_tut, tut,
				resist);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_tut, tut, resist);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_tut, tut, resist);

		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s2.size() + new_p2.size() + new_g2.size()
				+ new_a2.size() + new_h2.size() + " new Items added");

	}

	public void duplicateTutArmadilo(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_tut, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_tut, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_tut, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_tut, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_tut, tut, armadil);

		if (!keepChanged) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s2.size() + new_p2.size() + new_g2.size()
				+ new_a2.size() + new_h2.size() + " new Items added");

	}

	public void duplicateTs_Tr_Ta(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(items, allowed, tut, resist);
		List<Pants> new_p3 = addScrollsToPants(items, allowed, tut, resist);
		List<Gloves> new_g3 = addScrollsToGloves(items, allowed, tut, resist);
		List<Armor> new_a3 = addScrollsToArmor(items, allowed, tut, resist);
		List<Helm> new_h3 = addScrollsToHelm(items, allowed, tut, resist);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		items.getShoes().addAll(new_s3);
		items.getPants().addAll(new_p3);
		items.getGloves().addAll(new_g3);
		items.getArmors().addAll(new_a3);
		items.getHelms().addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Ta_Enthu(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		HashSet<ItemTyp> allowed_enth = new HashSet<>();
		allowed_enth.add(ItemTyp.CLOTH);
		allowed_enth.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(items, allowed_enth, wb, enthu);
		List<Pants> new_p3 = addScrollsToPants(items, allowed_enth, wb, enthu);
		List<Gloves> new_g3 = addScrollsToGloves(items, allowed_enth, wb, enthu);
		List<Armor> new_a3 = addScrollsToArmor(items, allowed_enth, wb, enthu);
		List<Helm> new_h3 = addScrollsToHelm(items, allowed_enth, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		items.getShoes().addAll(new_s3);
		items.getPants().addAll(new_p3);
		items.getGloves().addAll(new_g3);
		items.getArmors().addAll(new_a3);
		items.getHelms().addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Ta(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Tr(Items items, boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed, tut, resist);
		List<Pants> new_p2 = addScrollsToPants(items, allowed, tut, resist);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed, tut, resist);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed, tut, resist);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed, tut, resist);

		if (!keepChanged) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void filterSetNames(Items items, String ignore) {
		if (ignore.length() == 0) {
			return;
		}
		String setname;

		List<String> names = new ArrayList<String>();

		if (!ignore.contains(",")) {
			names.add(ignore);
		} else {
			String[] igar = ignore.split(",");
			for (String x : igar) {
				names.add(x.trim());
			}
		}

		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();
		for (String igname : names) {
			for (Shoes s : items.getShoes()) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					sho.add(s);
					count++;
				}
			}
			for (Pants s : items.getPants()) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					pan.add(s);
					count++;
				}
			}
			for (Gloves s : items.getGloves()) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					glo.add(s);
					count++;
				}
			}
			for (Armor s : items.getArmors()) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					arm.add(s);
					count++;
				}
			}
			for (Helm s : items.getHelms()) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					hel.add(s);
					count++;
				}
			}
		}
		items.getShoes().removeAll(sho);
		items.getPants().removeAll(pan);
		items.getHelms().removeAll(hel);
		items.getArmors().removeAll(arm);
		items.getGloves().removeAll(glo);
		System.out.println(count + " Items removed due to ignore ( " + ignore
				+ " )");

	}

	public void filterPrice(Items items, double price) {
		if (price == Double.MAX_VALUE) {
			return;
		}

		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : items.getShoes()) {
			if (s.getTotalPrice() > price) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : items.getPants()) {
			if (s.getTotalPrice() > price) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : items.getGloves()) {
			if (s.getTotalPrice() > price) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : items.getArmors()) {
			if (s.getTotalPrice() > price) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : items.getHelms()) {
			if (s.getTotalPrice() > price) {
				hel.add(s);
				count++;
			}
		}

		items.getShoes().removeAll(sho);
		items.getPants().removeAll(pan);
		items.getHelms().removeAll(hel);
		items.getArmors().removeAll(arm);
		items.getGloves().removeAll(glo);
		System.out.println(count + " Items removed due to price ( " + price
				+ " )");
	}

	public void filterLevel(Items items, int min, int max) {
		int level = 0;
		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : items.getShoes()) {
			level = s.getLevel();
			if (level < min || level > max) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : items.getPants()) {
			level = s.getLevel();
			if (level < min || level > max) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : items.getGloves()) {
			level = s.getLevel();
			if (level < min || level > max) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : items.getArmors()) {
			level = s.getLevel();
			if (level < min || level > max) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : items.getHelms()) {
			level = s.getLevel();
			if (level < min || level > max) {
				hel.add(s);
				count++;
			}
		}
		items.getShoes().removeAll(sho);
		items.getPants().removeAll(pan);
		items.getHelms().removeAll(hel);
		items.getArmors().removeAll(arm);
		items.getGloves().removeAll(glo);
		System.out.println(count + " Items removed due to level difference "
				+ min + " - " + max);
	}

	public void filterChar(Items items, VChar vchar) {
		if (vchar.equals(VChar.all)) {
			return;
		}
		String chars;
		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : items.getShoes()) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : items.getPants()) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : items.getGloves()) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : items.getArmors()) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : items.getHelms()) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				hel.add(s);
				count++;
			}
		}
		items.getShoes().removeAll(sho);
		items.getPants().removeAll(pan);
		items.getHelms().removeAll(hel);
		items.getArmors().removeAll(arm);
		items.getGloves().removeAll(glo);
		System.out.println(count
				+ " Items removed due to char difference (only " + vchar + ")");
	}

	@Override
	public boolean isNotEnough(Items items) {
		if (items.getShoes().size() == 0 || items.getPants().size() == 0
				|| items.getGloves().size() == 0
				|| items.getArmors().size() == 0
				|| items.getHelms().size() == 0) {
			return true;
		}
		return false;
	}

	public void filterStars(Items items, int smin, int smax) {
		if (smin < 1) {
			smin = 1;
		}
		if (smax < 1) {
			smax = 1;
		}
		if (smin > 5) {
			smin = 5;
		}
		if (smax > 5) {
			smax = 5;
		}

		int istar = 0;
		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : items.getShoes()) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : items.getPants()) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : items.getGloves()) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : items.getArmors()) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : items.getHelms()) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				hel.add(s);
				count++;
			}
		}
		items.getShoes().removeAll(sho);
		items.getPants().removeAll(pan);
		items.getHelms().removeAll(hel);
		items.getArmors().removeAll(arm);
		items.getGloves().removeAll(glo);
		System.out.println(count + " Items removed due to stars difference ( "
				+ smin + " - " + smax + " )");

	}

	public void forcePlus(Items items, int plus) {
		if (plus < 0 || plus > 15)
			return;

		for (Shoes x : items.getShoes()) {
			x.setPlus(plus);
		}
		for (Gloves x : items.getGloves()) {
			x.setPlus(plus);
		}
		for (Pants x : items.getPants()) {
			x.setPlus(plus);
		}
		for (Armor x : items.getArmors()) {
			x.setPlus(plus);
		}
		for (Helm x : items.getHelms()) {
			x.setPlus(plus);
		}
		System.out.println("Forced +" + plus);

	}

	// TODO: zusammenfassbar?
	private List<Shoes> addScrollsToShoes(Items items,
			HashSet<ItemTyp> allowedTypes, Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Shoes> newitems = new ArrayList<>();
		for (Shoes x : items.getShoes()) {

			ItemTyp typ = x.getTyp();

			if (allowedTypes.contains(typ)) {
				Scroll_Pre pre = x.getScroll_pre();
				Scroll_Suf suf = x.getScroll_suf();
				Shoes newitem = new Shoes(x);
				boolean toadd = false;

				if (newsuf != null && !newsuf.equals(suf)) {
					newitem.setScroll_suf(newsuf);
					toadd = true;
				}
				if (newpre != null && !newpre.equals(pre)) {
					newitem.setScroll_pre(newpre);
					toadd = true;
				}
				if (toadd) {
					newitems.add(newitem);
					shoes_changed.add(x);
				} else {
					System.out.println(x.getName() + " already got Enthu");
				}
			}
		}
		return newitems;
	}

	private List<Pants> addScrollsToPants(Items items,
			HashSet<ItemTyp> allowedTypes, Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Pants> newitems = new ArrayList<>();
		for (Pants x : items.getPants()) {

			ItemTyp typ = x.getTyp();

			if (allowedTypes.contains(typ)) {
				Scroll_Pre pre = x.getScroll_pre();
				Scroll_Suf suf = x.getScroll_suf();
				Pants newitem = new Pants(x);
				boolean toadd = false;

				if (newsuf != null && !newsuf.equals(suf)) {
					newitem.setScroll_suf(newsuf);
					toadd = true;
				}
				if (newpre != null && !newpre.equals(pre)) {
					newitem.setScroll_pre(newpre);
					toadd = true;
				}
				if (toadd) {
					newitems.add(newitem);
					pants_changed.add(x);
				} else {
					System.out.println(x.getName() + " already got Enthu");
				}
			}
		}
		return newitems;
	}

	private List<Gloves> addScrollsToGloves(Items items,
			HashSet<ItemTyp> allowedTypes, Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Gloves> newitems = new ArrayList<>();
		for (Gloves x : items.getGloves()) {

			ItemTyp typ = x.getTyp();

			if (allowedTypes.contains(typ)) {
				Scroll_Pre pre = x.getScroll_pre();
				Scroll_Suf suf = x.getScroll_suf();
				Gloves newitem = new Gloves(x);
				boolean toadd = false;

				if (newsuf != null && !newsuf.equals(suf)) {
					newitem.setScroll_suf(newsuf);
					toadd = true;
				}
				if (newpre != null && !newpre.equals(pre)) {
					newitem.setScroll_pre(newpre);
					toadd = true;
				}
				if (toadd) {
					newitems.add(newitem);
					gloves_changed.add(x);
				} else {
					System.out.println(x.getName() + " already got Enthu");
				}
			}
		}
		return newitems;
	}

	private List<Armor> addScrollsToArmor(Items items,
			HashSet<ItemTyp> allowedTypes, Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Armor> newitems = new ArrayList<>();
		for (Armor x : items.getArmors()) {

			ItemTyp typ = x.getTyp();

			if (allowedTypes.contains(typ)) {
				Scroll_Pre pre = x.getScroll_pre();
				Scroll_Suf suf = x.getScroll_suf();
				Armor newitem = new Armor(x);
				boolean toadd = false;

				if (newsuf != null && !newsuf.equals(suf)) {
					newitem.setScroll_suf(newsuf);
					toadd = true;
				}
				if (newpre != null && !newpre.equals(pre)) {
					newitem.setScroll_pre(newpre);
					toadd = true;
				}
				if (toadd) {
					newitems.add(newitem);
					armors_changed.add(x);
				} else {
					System.out.println(x.getName() + " already got Enthu");
				}
			}
		}
		return newitems;
	}

	private List<Helm> addScrollsToHelm(Items items,
			HashSet<ItemTyp> allowedTypes, Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Helm> newitems = new ArrayList<>();
		for (Helm x : items.getHelms()) {

			ItemTyp typ = x.getTyp();

			if (allowedTypes.contains(typ)) {
				Scroll_Pre pre = x.getScroll_pre();
				Scroll_Suf suf = x.getScroll_suf();
				Helm newitem = new Helm(x);
				boolean toadd = false;

				if (newsuf != null && !newsuf.equals(suf)) {
					newitem.setScroll_suf(newsuf);
					toadd = true;
				}
				if (newpre != null && !newpre.equals(pre)) {
					newitem.setScroll_pre(newpre);
					toadd = true;
				}
				if (toadd) {
					newitems.add(newitem);
					helms_changed.add(x);
				} else {
					System.out.println(x.getName() + " already got Enthu");
				}
			}
		}
		return newitems;
	}

	@Override
	public void sortItems(Items items) {
		List<Shoes> ss = items.getShoes();
		List<Pants> pp = items.getPants();
		List<Gloves> gg = items.getGloves();
		List<Armor> aa = items.getArmors();
		List<Helm> hh = items.getHelms();

		ItemLevelComparator ilcomp = new ItemLevelComparator();

		Collections.sort(ss, ilcomp);
		Collections.sort(pp, ilcomp);
		Collections.sort(gg, ilcomp);
		Collections.sort(aa, ilcomp);
		Collections.sort(hh, ilcomp);

	}

	public void overrideMaster(Items items) {

		System.out.println(items.getArmors());

		HashSet<Armor> as = new HashSet<>();

		for (Armor x : items.getArmors()) {

			x.setScroll_suf(master);
			as.add(x);
		}

		System.out.println(items.getArmors());

		List<Armor> newarmors = new ArrayList<>(as);
		items.setArmors(newarmors);

		System.out.println(items.getArmors());

	}

	public void duplicateTs_Tr_Ta_Enthu(Items items, boolean kEEP) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		HashSet<ItemTyp> allowed_enth = new HashSet<>();
		allowed_enth.add(ItemTyp.CLOTH);
		allowed_enth.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(items, allowed_enth, wb, enthu);
		List<Pants> new_p3 = addScrollsToPants(items, allowed_enth, wb, enthu);
		List<Gloves> new_g3 = addScrollsToGloves(items, allowed_enth, wb, enthu);
		List<Armor> new_a3 = addScrollsToArmor(items, allowed_enth, wb, enthu);
		List<Helm> new_h3 = addScrollsToHelm(items, allowed_enth, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s2r = addScrollsToShoes(items, allowed_tut, tut, resist);
		List<Pants> new_p2r = addScrollsToPants(items, allowed_tut, tut, resist);
		List<Gloves> new_g2r = addScrollsToGloves(items, allowed_tut, tut,
				resist);
		List<Armor> new_a2r = addScrollsToArmor(items, allowed_tut, tut, resist);
		List<Helm> new_h2r = addScrollsToHelm(items, allowed_tut, tut, resist);

		HashSet<ItemTyp> allowedf = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		if (!kEEP) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_s2r);
		items.getPants().addAll(new_p2r);
		items.getGloves().addAll(new_g2r);
		items.getArmors().addAll(new_a2r);
		items.getHelms().addAll(new_h2r);

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		items.getShoes().addAll(new_s3);
		items.getPants().addAll(new_p3);
		items.getGloves().addAll(new_g3);
		items.getArmors().addAll(new_a3);
		items.getHelms().addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Tr_Ta_Force(Items items, boolean kEEP) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		HashSet<ItemTyp> allowed_enth = new HashSet<>();
		allowed_enth.add(ItemTyp.CLOTH);
		allowed_enth.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s2r = addScrollsToShoes(items, allowed_tut, tut, resist);
		List<Pants> new_p2r = addScrollsToPants(items, allowed_tut, tut, resist);
		List<Gloves> new_g2r = addScrollsToGloves(items, allowed_tut, tut,
				resist);
		List<Armor> new_a2r = addScrollsToArmor(items, allowed_tut, tut, resist);
		List<Helm> new_h2r = addScrollsToHelm(items, allowed_tut, tut, resist);

		HashSet<ItemTyp> allowedf = new HashSet<>();
		allowedf.add(ItemTyp.CLOTH);
		allowedf.add(ItemTyp.LIGHT);

		List<Shoes> new_sf = addScrollsToShoes(items, allowedf, wb, force);
		List<Pants> new_pf = addScrollsToPants(items, allowedf, wb, force);
		List<Gloves> new_gf = addScrollsToGloves(items, allowedf, wb, force);
		List<Armor> new_af = addScrollsToArmor(items, allowedf, wb, force);
		List<Helm> new_hf = addScrollsToHelm(items, allowedf, wb, force);

		if (!kEEP) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_sf);
		items.getPants().addAll(new_pf);
		items.getGloves().addAll(new_gf);
		items.getArmors().addAll(new_af);
		items.getHelms().addAll(new_hf);

		items.getShoes().addAll(new_s2r);
		items.getPants().addAll(new_p2r);
		items.getGloves().addAll(new_g2r);
		items.getArmors().addAll(new_a2r);
		items.getHelms().addAll(new_h2r);

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Tr_Ta_F_E(Items items, boolean kEEP) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		HashSet<ItemTyp> allowed_enth = new HashSet<>();
		allowed_enth.add(ItemTyp.CLOTH);
		allowed_enth.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(items, allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(items, allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(items, allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(items, allowed_enth, wb, enthu);
		List<Pants> new_p3 = addScrollsToPants(items, allowed_enth, wb, enthu);
		List<Gloves> new_g3 = addScrollsToGloves(items, allowed_enth, wb, enthu);
		List<Armor> new_a3 = addScrollsToArmor(items, allowed_enth, wb, enthu);
		List<Helm> new_h3 = addScrollsToHelm(items, allowed_enth, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_arm, tut,
				armadil);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_arm, tut, armadil);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s2r = addScrollsToShoes(items, allowed_tut, tut, resist);
		List<Pants> new_p2r = addScrollsToPants(items, allowed_tut, tut, resist);
		List<Gloves> new_g2r = addScrollsToGloves(items, allowed_tut, tut,
				resist);
		List<Armor> new_a2r = addScrollsToArmor(items, allowed_tut, tut, resist);
		List<Helm> new_h2r = addScrollsToHelm(items, allowed_tut, tut, resist);

		HashSet<ItemTyp> allowedf = new HashSet<>();
		allowedf.add(ItemTyp.CLOTH);
		allowedf.add(ItemTyp.LIGHT);

		List<Shoes> new_sf = addScrollsToShoes(items, allowedf, wb, force);
		List<Pants> new_pf = addScrollsToPants(items, allowedf, wb, force);
		List<Gloves> new_gf = addScrollsToGloves(items, allowedf, wb, force);
		List<Armor> new_af = addScrollsToArmor(items, allowedf, wb, force);
		List<Helm> new_hf = addScrollsToHelm(items, allowedf, wb, force);

		if (!kEEP) {
			deleteChanged(items);
		}

		items.getShoes().addAll(new_sf);
		items.getPants().addAll(new_pf);
		items.getGloves().addAll(new_gf);
		items.getArmors().addAll(new_af);
		items.getHelms().addAll(new_hf);

		items.getShoes().addAll(new_s2r);
		items.getPants().addAll(new_p2r);
		items.getGloves().addAll(new_g2r);
		items.getArmors().addAll(new_a2r);
		items.getHelms().addAll(new_h2r);

		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		items.getShoes().addAll(new_s3);
		items.getPants().addAll(new_p3);
		items.getGloves().addAll(new_g3);
		items.getArmors().addAll(new_a3);
		items.getHelms().addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTr_Enthu(Items items, boolean kEEP) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(items, allowed, wb, enthu);
		List<Pants> new_p = addScrollsToPants(items, allowed, wb, enthu);
		List<Gloves> new_g = addScrollsToGloves(items, allowed, wb, enthu);
		List<Armor> new_a = addScrollsToArmor(items, allowed, wb, enthu);
		List<Helm> new_h = addScrollsToHelm(items, allowed, wb, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(items, allowed_tut, tut, resist);
		List<Pants> new_p2 = addScrollsToPants(items, allowed_tut, tut, resist);
		List<Gloves> new_g2 = addScrollsToGloves(items, allowed_tut, tut, resist);
		List<Armor> new_a2 = addScrollsToArmor(items, allowed_tut, tut, resist);
		List<Helm> new_h2 = addScrollsToHelm(items, allowed_tut, tut, resist);

		if (!kEEP) {
			deleteChanged(items);
		}
		items.getShoes().addAll(new_s);
		items.getPants().addAll(new_p);
		items.getGloves().addAll(new_g);
		items.getArmors().addAll(new_a);
		items.getHelms().addAll(new_h);

		items.getShoes().addAll(new_s2);
		items.getPants().addAll(new_p2);
		items.getGloves().addAll(new_g2);
		items.getArmors().addAll(new_a2);
		items.getHelms().addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

}
