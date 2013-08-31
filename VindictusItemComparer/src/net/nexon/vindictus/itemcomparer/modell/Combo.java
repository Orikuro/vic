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
		int itemdef = shoes.getTotaldef() + gloves.getTotaldef()
				+ pants.getTotaldef() + helm.getTotaldef()
				+ armor.getTotaldef();

		int setdef = calcSetDef();

		this.def = itemdef + setdef;
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

		int totalmatk = shoes.getTotalmatk() + pants.getTotalmatk()
				+ gloves.getTotalmatk() + helm.getTotalmatk()
				+ armor.getTotalmatk();

		this.matk = calcSetMatk() + totalmatk;
	}

	private void setAtk() {

		int totalatk = shoes.getTotalatk() + pants.getTotalatk()
				+ armor.getTotalatk() + helm.getTotalatk()
				+ gloves.getTotalatk();

		this.atk = calcSetAtk() + totalatk;
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
		price = s.getTotalPrice() + p.getTotalPrice() + g.getTotalPrice()
				+ a.getTotalPrice() + h.getTotalPrice();
		c_res = s.getCrit_res() + p.getCrit_res() + g.getCrit_res()
				+ a.getCrit_res() + h.getCrit_res();
		setSta();
	}

	private void setSta() {
		int staeq = shoes.getTotalsta() + pants.getTotalsta()
				+ gloves.getTotalsta() + armor.getTotalsta()
				+ helm.getTotalsta();
		sta = staeq;
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
