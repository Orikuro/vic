package net.nexon.vindictus.itemcomparer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.xml.ws.handler.MessageContext.Scope;

import net.nexon.vindictus.itemcomparer.inport.ScrollProperty;
import net.nexon.vindictus.itemcomparer.inport.StaticScrolls;
import net.nexon.vindictus.itemcomparer.logic.comparators.ItemLevelComparator;
import net.nexon.vindictus.itemcomparer.modell.Item;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.ScrollRestriction;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.enu.VChar;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class ItemLogic {

	private HashSet<Shoes> shoes_changed = new HashSet<>();
	private HashSet<Pants> pants_changed = new HashSet<>();
	private HashSet<Gloves> gloves_changed = new HashSet<>();
	private HashSet<Armor> armors_changed = new HashSet<>();
	private HashSet<Helm> helms_changed = new HashSet<>();

	private void deleteChanged(Items items) {
		items.getShoes().removeAll(shoes_changed);
		items.getPants().removeAll(pants_changed);
		items.getArmors().removeAll(armors_changed);
		items.getGloves().removeAll(gloves_changed);
		items.getHelms().removeAll(helms_changed);

	}

	public void duplicateItems(Items items, String prefix, String suffix) {

		if (prefix == null && suffix == null) {
			return;
		}

		prefix = prefix.trim();
		suffix = suffix.trim();

		if (prefix.length() < 1 && suffix.length() < 1) {
			return;
		}

		List<Scroll_Pre> pres = new ArrayList<>();
		List<Scroll_Suf> sufs = new ArrayList<>();

		String[] prefixes = prefix.split(",");
		for (String x : prefixes) {
			try {
				pres.add(StaticScrolls.searchPre(x.trim()));
			} catch (Exception e) {
			}
		}

		String[] suffixes = suffix.split(",");
		for (String x : suffixes) {
			try {
				sufs.add(StaticScrolls.searchSuf(x.trim()));
			} catch (Exception e) {
			}
		}

		duplicateItems(items, false, pres, sufs);
	}

	private void duplicateItems(Items items, boolean keepChanged,
			List<Scroll_Pre> pres, List<Scroll_Suf> sufs) {

		List<Item> newitems = new ArrayList<>();
		System.out.println(pres + " " + sufs);

		if (pres.size() > 0 && sufs.size() > 0) {
			for (Scroll_Pre pre : pres) {
				for (Scroll_Suf suf : sufs) {
					newitems.addAll(addScrollsToItems(items, pre, suf));
				}
			}
		}

		if (pres.size() > 0 && sufs.size() == 0) {
			for (Scroll_Pre pre : pres) {
				newitems.addAll(addScrollsToItems(items, pre, null));

			}
		}
		if (pres.size() == 0 && sufs.size() > 0) {
			for (Scroll_Suf suf : sufs) {
				newitems.addAll(addScrollsToItems(items, null, suf));
			}

		}

		if (!keepChanged) {
			deleteChanged(items);
		}

		for (Item x : newitems) {
			if (x instanceof Shoes) {
				items.getShoes().add((Shoes) x);
			}
			if (x instanceof Pants) {
				items.getPants().add((Pants) x);
			}
			if (x instanceof Armor) {
				items.getArmors().add((Armor) x);
			}
			if (x instanceof Gloves) {
				items.getGloves().add((Gloves) x);
			}
			if (x instanceof Helm) {
				items.getHelms().add((Helm) x);
			}

		}

	}

	private List<Item> addScrollsToItems(Items items, Scroll_Pre newpre,
			Scroll_Suf newsuf) {
		List<Item> newitems = new ArrayList<>();

		for (Shoes x : items.getShoes()) {
			Shoes changed = new Shoes(x);
			boolean success = changed.brynn(newpre, newsuf);
			if (success) {
				newitems.add(changed);
				shoes_changed.add(x);
			}
		}
		for (Pants x : items.getPants()) {
			Pants changed = new Pants(x);
			boolean success = changed.brynn(newpre, newsuf);
			if (success) {
				newitems.add(changed);
				pants_changed.add(x);
			}
		}
		for (Gloves x : items.getGloves()) {
			Gloves changed = new Gloves(x);
			boolean success = changed.brynn(newpre, newsuf);
			if (success) {
				newitems.add(changed);
				gloves_changed.add(x);
			}
		}
		for (Armor x : items.getArmors()) {
			Armor changed = new Armor(x);
			boolean success = changed.brynn(newpre, newsuf);
			if (success) {
				newitems.add(changed);
				armors_changed.add(x);
			}
		}
		for (Helm x : items.getHelms()) {
			Helm changed = new Helm(x);
			boolean success = changed.brynn(newpre, newsuf);
			if (success) {
				newitems.add(changed);
				helms_changed.add(x);
			}
		}

		return newitems;
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

		Scroll_Suf master;
		try {
			master = StaticScrolls.searchSuf("Master");
		} catch (Exception e) {
			return;
		}
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

	public ItemSet searchSet(Items items, String string) throws Exception {

		for (Shoes s : items.getShoes()) {
			if (s.getItemset().getName().contains(string)) {
				return s.getItemset();
			}
		}

		throw new Exception("Set not found");
	}

	public void overrideMaster(Items items, String armorprefix,
			String armorsuffix) {

		Scroll_Pre pre;
		Scroll_Suf suf;
		try {
			suf = StaticScrolls.searchSuf(armorsuffix);
			pre = StaticScrolls.searchPre(armorprefix);
		} catch (Exception e) {
			return;
		}
		HashSet<Armor> as = new HashSet<>();

		for (Armor x : items.getArmors()) {

			x.brynn(pre, suf);
			as.add(x);
		}

		List<Armor> newarmors = new ArrayList<>(as);
		items.setArmors(newarmors);

		System.out.println(items.getArmors());

	}

	public void overrideMaster(Items items, String scroll, boolean isprefix) {

		Scroll_Pre pre = null;
		Scroll_Suf suf = null;
		try {
			if (isprefix) {
				pre = StaticScrolls.searchPre(scroll);
			} else {
				suf = StaticScrolls.searchSuf(scroll);
			}
		} catch (Exception e) {
			return;
		}
		HashSet<Armor> as = new HashSet<>();

		for (Armor x : items.getArmors()) {
			if (isprefix) {
				x.brynn(pre);
			} else {
				x.brynn(suf);
			}
			as.add(x);
		}

		List<Armor> newarmors = new ArrayList<>(as);
		items.setArmors(newarmors);

		System.out.println(items.getArmors());

	}

}
