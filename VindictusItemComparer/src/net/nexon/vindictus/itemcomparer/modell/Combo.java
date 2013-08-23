package net.nexon.vindictus.itemcomparer.modell;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class Combo {

	public static final String OUTPUT_HEAD = "id;def;matk;atk;sta;c_res;price;shoes;pants;gloves;armor;helm;";

	private static DecimalFormat df = new DecimalFormat(",###.00");

	@Override
	public String toString() {
		String price_norm = df.format(price);
		int atk_norm = (int) atk;
		return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;", def, matk,
				atk_norm, sta, c_res, price_norm, shoes, pants, gloves, armor,
				helm);
	}

	private int def;
	private int matk;
	private double atk;
	private int sta;
	private int c_res;
	private double price;

	public int getDef() {
		return def;
	}

	public double getAtk() {
		return atk;
	}

	public int getMatk() {
		return matk;
	}

	private void setDef() {
		int itemdef = shoes.getDef() + pants.getDef() + gloves.getDef()
				+ armor.getDef() + helm.getDef();

		int setdef = calcSetDef();

		int stardef = shoes.getStarDef() + pants.getStarDef()
				+ gloves.getStarDef() + armor.getStarDef() + helm.getStarDef();

		int scrolldef = shoes.getScrollDef() + pants.getScrollDef()
				+ gloves.getScrollDef() + armor.getScrollDef()
				+ helm.getScrollDef();

		int agidef = (int) (0.5f * (shoes.getAgi() + gloves.getAgi()
				+ pants.getAgi() + armor.getAgi() + helm.getAgi()));

		int plusdef = shoes.getPlusDef() + gloves.getPlusDef()
				+ pants.getPlusDef() + armor.getPlusDef() + helm.getPlusDef();

		this.def = itemdef + setdef + stardef + scrolldef + agidef + plusdef;
	}

	private int calcSetDef() {

		int deftotal = (int) (shoes.getItemset().getDefBonus(sho_f)
				/ (sho_f * 1.0) + gloves.getItemset().getDefBonus(glo_f)
				/ (glo_f * 1.0) + pants.getItemset().getDefBonus(pan_f)
				/ (pan_f * 1.0) + armor.getItemset().getDefBonus(arm_f)
				/ (arm_f * 1.0) + helm.getItemset().getDefBonus(hel_f)
				/ (hel_f * 1.0)

		);

		return deftotal;
	}

	private double calcSetAtk() {
		double deftotal = (shoes.getItemset().getAtkBonus(sho_f)
				/ (sho_f * 1.0) + gloves.getItemset().getAtkBonus(glo_f)
				/ (glo_f * 1.0) + pants.getItemset().getAtkBonus(pan_f)
				/ (pan_f * 1.0) + armor.getItemset().getAtkBonus(arm_f)
				/ (arm_f * 1.0) + helm.getItemset().getAtkBonus(hel_f)
				/ (hel_f * 1.0)

		);

		return deftotal;
	}

	private int calcSetMatk() {
		int deftotal = (int) (shoes.getItemset().getMatkBonus(sho_f)
				/ (sho_f * 1.0) + gloves.getItemset().getMatkBonus(glo_f)
				/ (glo_f * 1.0) + pants.getItemset().getMatkBonus(pan_f)
				/ (pan_f * 1.0) + armor.getItemset().getMatkBonus(arm_f)
				/ (arm_f * 1.0) + helm.getItemset().getMatkBonus(hel_f)
				/ (hel_f * 1.0)

		);

		return deftotal;
	}

	private void setMatk() {

		int matk_from_int = shoes.getVint() * 2 + pants.getVint() * 2
				+ gloves.getVint() * 2 + armor.getVint() * 2 + helm.getVint()
				* 2;

		int matk_from_stars = shoes.getStarMatk() + pants.getStarMatk()
				+ gloves.getStarMatk() + armor.getStarMatk()
				+ helm.getStarMatk();

		int scroll_matk = shoes.getScrollMatk() + pants.getScrollMatk()
				+ gloves.getScrollMatk() + armor.getScrollMatk()
				+ helm.getScrollMatk();

		this.matk = calcSetMatk() + matk_from_int + matk_from_stars
				+ scroll_matk;
	}

	private void setAtk() {

		double atk_from_int = (2.7 * (shoes.getStr() + pants.getStr()
				+ gloves.getStr() + armor.getStr() + helm.getStr()));

		double atk_from_stars = shoes.getStarAtk() + pants.getStarAtk()
				+ gloves.getStarAtk() + armor.getStarAtk() + helm.getStarAtk();

		double scroll_atk = shoes.getScrollAtk() + pants.getScrollAtk()
				+ gloves.getScrollAtk() + armor.getScrollAtk()
				+ helm.getScrollAtk();

		this.atk = calcSetAtk() + atk_from_int + atk_from_stars + scroll_atk;
	}

	private Shoes shoes;
	private Pants pants;
	private Gloves gloves;
	private Armor armor;
	private Helm helm;

	public Combo(Shoes s, Pants p, Gloves g, Armor a, Helm h) {
		shoes = s;
		pants = p;
		gloves = g;
		armor = a;
		helm = h;
		getSets();
		setDef();
		setMatk();
		setAtk();
		price = s.getTotalPrice() + p.getTotalPrice() + g.getTotalPrice() + a.getTotalPrice()
				+ h.getTotalPrice();
		c_res = s.getCrit_res() + p.getCrit_res() + g.getCrit_res()
				+ a.getCrit_res() + h.getCrit_res();
		setSta();
	}

	private void setSta() {
		int staeq = shoes.getStamina() + pants.getStamina()
				+ gloves.getStamina() + armor.getStamina() + helm.getStamina();
		int stascr = shoes.getScrollSta() + pants.getScrollSta()
				+ gloves.getScrollSta() + armor.getScrollSta()
				+ helm.getScrollSta();

		sta = staeq + stascr;

	}

	private List<ItemSet> setlist = new ArrayList<>();

	private int sho_f;
	private int glo_f;
	private int pan_f;
	private int arm_f;
	private int hel_f;

	private void getSets() {
		ItemSet a = shoes.getItemset();
		ItemSet b = pants.getItemset();
		ItemSet c = gloves.getItemset();
		ItemSet d = armor.getItemset();
		ItemSet e = helm.getItemset();

		setlist.add(a);
		setlist.add(b);
		setlist.add(c);
		setlist.add(d);
		setlist.add(e);

		sho_f = Collections.frequency(setlist, shoes.getItemset());
		glo_f = Collections.frequency(setlist, gloves.getItemset());
		pan_f = Collections.frequency(setlist, pants.getItemset());
		arm_f = Collections.frequency(setlist, armor.getItemset());
		hel_f = Collections.frequency(setlist, helm.getItemset());

	}

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}

	public Pants getPants() {
		return pants;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}

	public double getPrice() {
		return price;
	}

}
