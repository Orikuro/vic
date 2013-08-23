package net.nexon.vindictus.itemcomparer.modell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import net.nexon.vindictus.itemcomparer.inport.ScrollProperty;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.enu.VChar;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

@XmlRootElement
public class Items {

	private List<Shoes> shoes;
	private List<Pants> pants;
	private List<Gloves> gloves;
	private List<Armor> armors;
	private List<Helm> helms;

	private List<ItemSet> isets;
	private List<Scroll_Pre> pres;
	private List<Scroll_Suf> sufs;
	
	private List<Shoes> shoes_changed = new ArrayList<>();
	private List<Pants> pants_changed = new ArrayList<>();
	private List<Gloves> gloves_changed = new ArrayList<>();
	private List<Armor> armors_changed = new ArrayList<>();
	private List<Helm> helms_changed = new ArrayList<>();

	private static ScrollProperty SCRPROP = new ScrollProperty();

	private static Scroll_Suf enthu = new Scroll_Suf("Enthu", -370, 270, 282,
			SCRPROP.getEnthu());
	private static Scroll_Suf force = new Scroll_Suf("Force", -28, 140, 132,
			SCRPROP.getForce());
	private static Scroll_Pre tut = new Scroll_Pre("Tutelary", 112, 0, 0,
			SCRPROP.getTut());
	private static Scroll_Suf sent = new Scroll_Suf("Sentinel", 224, -15, 0,
			SCRPROP.getSenti());
	private static Scroll_Suf resist = new Scroll_Suf("Resistant", 340, -160,
			0, SCRPROP.getRes());
	private static Scroll_Suf armadil = new Scroll_Suf(5, "Armadillo", 336, 0,
			0, SCRPROP.getArmadi());

	public void duplicateEnthu(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(allowed, null, enthu);
		List<Pants> new_p = addScrollsToPants(allowed, null, enthu);
		List<Gloves> new_g = addScrollsToGloves(allowed, null, enthu);
		List<Armor> new_a = addScrollsToArmor(allowed, null, enthu);
		List<Helm> new_h = addScrollsToHelm(allowed, null, enthu);
		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	public void duplicateTutSentinel(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(allowed, tut, sent);
		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	public void duplicateForce(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(allowed, null, force);
		List<Pants> new_p = addScrollsToPants(allowed, null, force);
		List<Gloves> new_g = addScrollsToGloves(allowed, null, force);
		List<Armor> new_a = addScrollsToArmor(allowed, null, force);
		List<Helm> new_h = addScrollsToHelm(allowed, null, force);
		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + " new Items added");

	}

	private void deleteChanged() {
		shoes.removeAll(shoes_changed);
		pants.removeAll(pants_changed);
		armors.removeAll(armors_changed);
		gloves.removeAll(gloves_changed);
		helms.removeAll(helms_changed);

	}

	public void duplicateForceAndEnthu(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(allowed, null, enthu);
		List<Pants> new_p = addScrollsToPants(allowed, null, enthu);
		List<Gloves> new_g = addScrollsToGloves(allowed, null, enthu);
		List<Armor> new_a = addScrollsToArmor(allowed, null, enthu);
		List<Helm> new_h = addScrollsToHelm(allowed, null, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(allowed, null, force);
		List<Pants> new_p2 = addScrollsToPants(allowed, null, force);
		List<Gloves> new_g2 = addScrollsToGloves(allowed, null, force);
		List<Armor> new_a2 = addScrollsToArmor(allowed, null, force);
		List<Helm> new_h2 = addScrollsToHelm(allowed, null, force);

		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTutSentAndEnthu(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(allowed, null, enthu);
		List<Pants> new_p = addScrollsToPants(allowed, null, enthu);
		List<Gloves> new_g = addScrollsToGloves(allowed, null, enthu);
		List<Armor> new_a = addScrollsToArmor(allowed, null, enthu);
		List<Helm> new_h = addScrollsToHelm(allowed, null, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_tut, tut, sent);
		List<Pants> new_p2 = addScrollsToPants(allowed_tut, tut, sent);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_tut, tut, sent);
		List<Armor> new_a2 = addScrollsToArmor(allowed_tut, tut, sent);
		List<Helm> new_h2 = addScrollsToHelm(allowed_tut, tut, sent);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTA_Enthu(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.CLOTH);
		allowed.add(ItemTyp.LIGHT);

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(allowed, null, enthu);
		List<Pants> new_p = addScrollsToPants(allowed, null, enthu);
		List<Gloves> new_g = addScrollsToGloves(allowed, null, enthu);
		List<Armor> new_a = addScrollsToArmor(allowed, null, enthu);
		List<Helm> new_h = addScrollsToHelm(allowed, null, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_tut, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(allowed_tut, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_tut, tut, armadil);
		List<Armor> new_a2 = addScrollsToArmor(allowed_tut, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(allowed_tut, tut, armadil);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTutResistant(boolean keepChanged) {

		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);
		allowed_tut.add(ItemTyp.PLATE);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_tut, tut, resist);
		List<Pants> new_p2 = addScrollsToPants(allowed_tut, tut, resist);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_tut, tut, resist);
		List<Armor> new_a2 = addScrollsToArmor(allowed_tut, tut, resist);
		List<Helm> new_h2 = addScrollsToHelm(allowed_tut, tut, resist);

		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s2.size() + new_p2.size() + new_g2.size()
				+ new_a2.size() + new_h2.size() + " new Items added");

	}

	// TODO: zusammenfassbar?
	private List<Shoes> addScrollsToShoes(HashSet<ItemTyp> allowedTypes,
			Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Shoes> newitems = new ArrayList<>();
		for (Shoes x : shoes) {

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

	private List<Pants> addScrollsToPants(HashSet<ItemTyp> allowedTypes,
			Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Pants> newitems = new ArrayList<>();
		for (Pants x : pants) {

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

	private List<Gloves> addScrollsToGloves(HashSet<ItemTyp> allowedTypes,
			Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Gloves> newitems = new ArrayList<>();
		for (Gloves x : gloves) {

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

	private List<Armor> addScrollsToArmor(HashSet<ItemTyp> allowedTypes,
			Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Armor> newitems = new ArrayList<>();
		for (Armor x : armors) {

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

	private List<Helm> addScrollsToHelm(HashSet<ItemTyp> allowedTypes,
			Scroll_Pre newpre, Scroll_Suf newsuf) {
		List<Helm> newitems = new ArrayList<>();
		for (Helm x : helms) {

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

	public Items() {

		shoes = new ArrayList<>();
		pants = new ArrayList<>();
		gloves = new ArrayList<>();
		armors = new ArrayList<>();
		helms = new ArrayList<>();
	}

	public Items(List<Shoes> shoes, List<Pants> pants, List<Gloves> gloves,
			List<Armor> armors, List<Helm> helms) {
		super();
		this.shoes = shoes;
		this.pants = pants;
		this.gloves = gloves;
		this.armors = armors;
		this.helms = helms;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	public List<Pants> getPants() {
		return pants;
	}

	public void setPants(List<Pants> pants) {
		this.pants = pants;
	}

	public List<Gloves> getGloves() {
		return gloves;
	}

	public void setGloves(List<Gloves> gloves) {
		this.gloves = gloves;
	}

	public List<Armor> getArmors() {
		return armors;
	}

	public void setArmors(List<Armor> armors) {
		this.armors = armors;
	}

	public List<Helm> getHelms() {
		return helms;
	}

	public void setHelms(List<Helm> helms) {
		this.helms = helms;
	}

	public void filterLevel(int min, int max) {
		int level = 0;
		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : shoes) {
			level = s.getLevel();
			if (level < min || level > max) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : pants) {
			level = s.getLevel();
			if (level < min || level > max) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : gloves) {
			level = s.getLevel();
			if (level < min || level > max) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : armors) {
			level = s.getLevel();
			if (level < min || level > max) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : helms) {
			level = s.getLevel();
			if (level < min || level > max) {
				hel.add(s);
				count++;
			}
		}
		shoes.removeAll(sho);
		pants.removeAll(pan);
		helms.removeAll(hel);
		armors.removeAll(arm);
		gloves.removeAll(glo);
		System.out.println(count + " Items removed due to level difference "
				+ min + " - " + max);
	}

	public void filterChar(VChar vchar) {
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

		for (Shoes s : shoes) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : pants) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : gloves) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : armors) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : helms) {
			chars = s.getItemset().getUsefulChars();
			if (!chars.contains(vchar.toString())) {
				hel.add(s);
				count++;
			}
		}
		shoes.removeAll(sho);
		pants.removeAll(pan);
		helms.removeAll(hel);
		armors.removeAll(arm);
		gloves.removeAll(glo);
		System.out.println(count
				+ " Items removed due to char difference (only " + vchar + ")");
	}

	public boolean isNotEnough() {
		if (shoes.size() == 0 || pants.size() == 0 || gloves.size() == 0
				|| armors.size() == 0 || helms.size() == 0) {
			return true;
		}
		return false;
	}

	public void filterStars(int smin, int smax) {
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

		for (Shoes s : shoes) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : pants) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : gloves) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : armors) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : helms) {
			istar = s.getStars();
			if (istar < smin || istar > smax) {
				hel.add(s);
				count++;
			}
		}
		shoes.removeAll(sho);
		pants.removeAll(pan);
		helms.removeAll(hel);
		armors.removeAll(arm);
		gloves.removeAll(glo);
		System.out.println(count + " Items removed due to stars difference ( "
				+ smin + " - " + smax + " )");

	}

	public void forcePlus(int plus) {
		if (plus < 0 || plus > 15)
			return;

		for (Shoes x : shoes) {
			x.setPlus(plus);
		}
		for (Gloves x : gloves) {
			x.setPlus(plus);
		}
		for (Pants x : pants) {
			x.setPlus(plus);
		}
		for (Armor x : armors) {
			x.setPlus(plus);
		}
		for (Helm x : helms) {
			x.setPlus(plus);
		}
		System.out.println("Forced +" + plus);

	}

	public void duplicateTutArmadilo(boolean keepChanged) {
		HashSet<ItemTyp> allowed_tut = new HashSet<>();
		allowed_tut.add(ItemTyp.HEAVY);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_tut, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(allowed_tut, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_tut, tut, armadil);
		List<Armor> new_a2 = addScrollsToArmor(allowed_tut, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(allowed_tut, tut, armadil);

		if (!keepChanged) {
			deleteChanged();
		}

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s2.size() + new_p2.size() + new_g2.size()
				+ new_a2.size() + new_h2.size() + " new Items added");

	}

	public void duplicateTs_Tr_Ta(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(allowed, tut, resist);
		List<Pants> new_p3 = addScrollsToPants(allowed, tut, resist);
		List<Gloves> new_g3 = addScrollsToGloves(allowed, tut, resist);
		List<Armor> new_a3 = addScrollsToArmor(allowed, tut, resist);
		List<Helm> new_h3 = addScrollsToHelm(allowed, tut, resist);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_arm, tut, armadil);
		List<Armor> new_a2 = addScrollsToArmor(allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		shoes.addAll(new_s3);
		pants.addAll(new_p3);
		gloves.addAll(new_g3);
		armors.addAll(new_a3);
		helms.addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Ta_Enthu(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		HashSet<ItemTyp> allowed_enth = new HashSet<>();
		allowed_enth.add(ItemTyp.CLOTH);
		allowed_enth.add(ItemTyp.LIGHT);

		List<Shoes> new_s = addScrollsToShoes(allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(allowed, tut, sent);

		List<Shoes> new_s3 = addScrollsToShoes(allowed_enth, null, enthu);
		List<Pants> new_p3 = addScrollsToPants(allowed_enth, null, enthu);
		List<Gloves> new_g3 = addScrollsToGloves(allowed_enth, null, enthu);
		List<Armor> new_a3 = addScrollsToArmor(allowed_enth, null, enthu);
		List<Helm> new_h3 = addScrollsToHelm(allowed_enth, null, enthu);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_arm, tut, armadil);
		List<Armor> new_a2 = addScrollsToArmor(allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		shoes.addAll(new_s3);
		pants.addAll(new_p3);
		gloves.addAll(new_g3);
		armors.addAll(new_a3);
		helms.addAll(new_h3);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Ta(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		HashSet<ItemTyp> allowed_arm = new HashSet<>();
		allowed_arm.add(ItemTyp.HEAVY);

		List<Shoes> new_s = addScrollsToShoes(allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(allowed, tut, sent);

		List<Shoes> new_s2 = addScrollsToShoes(allowed_arm, tut, armadil);
		List<Pants> new_p2 = addScrollsToPants(allowed_arm, tut, armadil);
		List<Gloves> new_g2 = addScrollsToGloves(allowed_arm, tut, armadil);
		List<Armor> new_a2 = addScrollsToArmor(allowed_arm, tut, armadil);
		List<Helm> new_h2 = addScrollsToHelm(allowed_arm, tut, armadil);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void duplicateTs_Tr(boolean keepChanged) {
		HashSet<ItemTyp> allowed = new HashSet<>();
		allowed.add(ItemTyp.HEAVY);
		allowed.add(ItemTyp.PLATE);

		List<Shoes> new_s = addScrollsToShoes(allowed, tut, sent);
		List<Pants> new_p = addScrollsToPants(allowed, tut, sent);
		List<Gloves> new_g = addScrollsToGloves(allowed, tut, sent);
		List<Armor> new_a = addScrollsToArmor(allowed, tut, sent);
		List<Helm> new_h = addScrollsToHelm(allowed, tut, sent);

		List<Shoes> new_s2 = addScrollsToShoes(allowed, tut, resist);
		List<Pants> new_p2 = addScrollsToPants(allowed, tut, resist);
		List<Gloves> new_g2 = addScrollsToGloves(allowed, tut, resist);
		List<Armor> new_a2 = addScrollsToArmor(allowed, tut, resist);
		List<Helm> new_h2 = addScrollsToHelm(allowed, tut, resist);

		if (!keepChanged) {
			deleteChanged();
		}
		shoes.addAll(new_s);
		pants.addAll(new_p);
		gloves.addAll(new_g);
		armors.addAll(new_a);
		helms.addAll(new_h);

		shoes.addAll(new_s2);
		pants.addAll(new_p2);
		gloves.addAll(new_g2);
		armors.addAll(new_a2);
		helms.addAll(new_h2);

		System.out.println(new_s.size() + new_p.size() + new_g.size()
				+ new_a.size() + new_h.size() + new_s2.size() + new_p2.size()
				+ new_g2.size() + new_a2.size() + new_h2.size()
				+ " new Items added");

	}

	public void filterSetNames(String ignore) {
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
			for (Shoes s : shoes) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					sho.add(s);
					count++;
				}
			}
			for (Pants s : pants) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					pan.add(s);
					count++;
				}
			}
			for (Gloves s : gloves) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					glo.add(s);
					count++;
				}
			}
			for (Armor s : armors) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					arm.add(s);
					count++;
				}
			}
			for (Helm s : helms) {
				setname = s.getItemset().getName();
				if (setname.toLowerCase().contains(igname)) {
					hel.add(s);
					count++;
				}
			}
		}
		shoes.removeAll(sho);
		pants.removeAll(pan);
		helms.removeAll(hel);
		armors.removeAll(arm);
		gloves.removeAll(glo);
		System.out.println(count + " Items removed due to ignore ( " + ignore
				+ " )");

	}

	public void filterPrice(double price) {
		if (price == Double.MAX_VALUE) {
			return;
		}

		int count = 0;
		List<Shoes> sho = new ArrayList<>();
		List<Pants> pan = new ArrayList<>();
		List<Gloves> glo = new ArrayList<>();
		List<Armor> arm = new ArrayList<>();
		List<Helm> hel = new ArrayList<>();

		for (Shoes s : shoes) {
			if (s.getTotalPrice() > price) {
				sho.add(s);
				count++;
			}
		}
		for (Pants s : pants) {
			if (s.getTotalPrice() > price) {
				pan.add(s);
				count++;
			}
		}
		for (Gloves s : gloves) {
			if (s.getTotalPrice() > price) {
				glo.add(s);
				count++;
			}
		}
		for (Armor s : armors) {
			if (s.getTotalPrice() > price) {
				arm.add(s);
				count++;
			}
		}
		for (Helm s : helms) {
			if (s.getTotalPrice() > price) {
				hel.add(s);
				count++;
			}
		}

		shoes.removeAll(sho);
		pants.removeAll(pan);
		helms.removeAll(hel);
		armors.removeAll(arm);
		gloves.removeAll(glo);
		System.out.println(count + " Items removed due to price ( " + price
				+ " )");
	}

}
