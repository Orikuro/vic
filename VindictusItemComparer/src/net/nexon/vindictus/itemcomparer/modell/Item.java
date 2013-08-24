package net.nexon.vindictus.itemcomparer.modell;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlTransient;

import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	private void calcTotaldef() {

		int agibonus = (int) (0.5f * agi * starbonus[stars - 1]);
		int defbonus = (int) (def * starbonus_def[stars - 1]);
		int sbonus = scroll_pre.getDef() + scroll_suf.getDef();

		totalDef = agibonus + def + defbonus + sbonus + getPlusDef();
	}

	public int getTotaldef() {
		return totalDef;
	}

	public void calcBonus() {
		totalprice = price + scroll_pre.getPrice() + scroll_suf.getPrice();
		plusdef = calcPlusDef();
		calcTotaldef();
		starmatk = (int) (2 * vint * starbonus[stars - 1]);
		staratk = (2.7 * str * starbonus[stars - 1]);
		stardef = (int) (0.5f * agi * starbonus[stars - 1])
				+ (int) (def * starbonus_def[stars - 1]);
		scrolldef = scroll_pre.getDef() + scroll_suf.getDef();
	
	
		scrollsta = scroll_pre.getStamina() + scroll_suf.getStamina();
		scrollatk = scroll_pre.getAtk() + scroll_suf.getAtk()
				+ (2.7 * (scroll_pre.getStr() + scroll_suf.getStr()));

		scrollmatk = scroll_pre.getMatk() + scroll_suf.getMatk() + 2
				* scroll_pre.getVint() + scroll_suf.getVint();
	}

	@XmlTransient
	private int starmatk;
	@XmlTransient
	private double staratk;
	@XmlTransient
	private int stardef;
	@XmlTransient
	private int scrolldef;
	@XmlTransient
	private int plusdef;
	@XmlTransient
	private int scrollsta;
	@XmlTransient
	private double scrollatk;
	@XmlTransient
	private int scrollmatk;

	public int getStarMatk() {
		return starmatk;
	}

	public double getStarAtk() {
		return staratk;
	}

	public int getStarDef() {
		return stardef;
	}

	public int getScrollDef() {
		return scrolldef;
	}

	private int calcPlusDef() {
		if (plus <= 0 || plus > 15) {
			return 0;
		}

		if (typ.equals(ItemTyp.PLATE)) {
			return plus_plate[plus];
		}
		if (typ.equals(ItemTyp.HEAVY)) {
			return  plus_heavy[plus];
		}
		if (typ.equals(ItemTyp.LIGHT)) {
			return  plus_light[plus];
		}

		return  plus_cloth[plus];
	}

	public int getPlusDef() {
		return plusdef;
	}

	public int getScrollSta() {
		return scrollsta;
	}

	public double getScrollAtk() {
		return scrollatk;
	}

	public int getScrollMatk() {
		return scrollmatk;
	}

	private static int counter = 0;
	private int id;

	@Override
	public String toString() {
		return String.format(" [+%s %s %s %s*, %s %s]", plus, itemset, name,
				stars, scroll_pre, scroll_suf);
	}

	public Item() {
		scroll_pre = new Scroll_Pre();
		scroll_suf = new Scroll_Suf();
		itemset = new ItemSet();
	}

	public Item(ItemSet iset, String name, int level2, ItemTyp typ, int def,
			int str, int vint, int agi, int crit_res) {
		this.setItemset(iset);
		this.setName(name);
		this.setLevel(level2);
		this.setTyp(typ);
		this.setDef(def);
		this.setStr(str);
		this.setVint(vint);
		this.setAgi(agi);
		this.setCrit_res(crit_res);
		scroll_pre = new Scroll_Pre();
		scroll_suf = new Scroll_Suf();
		stars = 2;
		plus = 0;
		id = counter++;
	}

	public Item(Item item) {
		id = counter++;
		this.name = item.name;
		this.level = item.level;
		this.typ = item.typ;
		this.def = item.def;
		this.atk = item.atk;
		this.matk = item.matk;
		this.str = item.str;
		this.vint = item.vint;
		this.agi = item.agi;
		this.crit_res = item.crit_res;
		this.stamina = item.stamina;
		this.price = item.price;
		this.stars = item.stars;
		this.scroll_pre = item.scroll_pre;
		this.scroll_suf = item.scroll_suf;
		this.itemset = item.itemset;
		totalprice = price + scroll_pre.getPrice() + scroll_suf.getPrice();
	}

	@XmlTransient
	float[] starbonus = { -0.2f, 0.00f, 0.15f, 0.2f, 0.25f };
	@XmlTransient
	float[] starbonus_def = { -0.04f, 0.00f, 0.02f, 0.04f, 0.04f };
	@XmlTransient
	int[] plus_cloth = { 0, 5, 10, 15, 22, 29, 36, 46, 56, 66, 76, 91, 106,
			121, 141, 161 };
	@XmlTransient
	int[] plus_light = { 0, 7, 14, 21, 31, 41, 51, 65, 79, 93, 107, 131, 155,
			179, 214, 249 };
	@XmlTransient
	int[] plus_heavy = { 0, 10, 20, 30, 44, 58, 72, 91, 110, 129, 148, 172,
			196, 220, 255, 290 };
	@XmlTransient
	int[] plus_plate = { 0, 13, 26, 39, 57, 75, 93, 117, 141, 165, 189, 224,
			259, 294, 339, 384 };

	private String name;
	private int level;
	private ItemTyp typ;
	private int def;
	private int atk;
	private int matk;
	private int str;
	// ... since int is a keyword in java, added v (for vindictus) ...
	private int vint;
	private int agi;
	private int crit_res;
	private int stamina;
	private double price;
	private int stars;
	private int plus;

	private Scroll_Pre scroll_pre;
	private Scroll_Suf scroll_suf;

	@XmlIDREF
	private ItemSet itemset;

	@XmlTransient
	private double totalprice;

	@XmlTransient
	private int totalDef;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getMatk() {
		return matk;
	}

	public void setMatk(int matk) {
		this.matk = matk;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}

	public int getCrit_res() {
		return crit_res;
	}

	public void setCrit_res(int crit_res) {
		this.crit_res = crit_res;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public double getTotalPrice() {
		return totalprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		totalprice = price + scroll_pre.getPrice() + scroll_suf.getPrice();
		this.price = price;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getVint() {
		return vint;
	}

	public void setVint(int vint) {
		this.vint = vint;
	}

	public Scroll_Pre getScroll_pre() {
		return scroll_pre;
	}

	public void setScroll_pre(Scroll_Pre scroll_pre) {
		totalprice = price + scroll_pre.getPrice() + scroll_suf.getPrice();
		this.scroll_pre = scroll_pre;
	}

	public Scroll_Suf getScroll_suf() {
		return scroll_suf;
	}

	public void setScroll_suf(Scroll_Suf scroll_suf) {
		totalprice = price + scroll_pre.getPrice() + scroll_suf.getPrice();
		this.scroll_suf = scroll_suf;
	}

	public ItemSet getItemset() {
		return itemset;
	}

	public void setItemset(ItemSet itemset) {
		this.itemset = itemset;
	}

	public ItemTyp getTyp() {
		return typ;
	}

	public void setTyp(ItemTyp typ) {
		this.typ = typ;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
