package net.nexon.vindictus.itemcomparer.modell;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

@XmlAccessorType(XmlAccessType.FIELD)
public class Scroll {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (name != null) {
			builder.append(name);
		}
		return builder.toString();
	}

	private String name;
	private int def;
	private int atk;
	private int matk;
	private int str;
	private int vint;
	private int stamina;
	private double price;
	private ScrollRestriction restriction;
	private int crit = 0;
	private int bal = 0;
	private int critres = 0;
	private int aspd = 0;
	private int bonus = 0;
	private ItemTyp bonus_type = ItemTyp.CLOTH;

	public Scroll() {
	}

	public Scroll(String namee, int deff, int atkk, int matkk) {
		this(namee, deff, atkk, matkk, 0.0);
	}

	public Scroll(String namee, int deff, int atkk, int matkk, double cost) {
		name = namee;
		def = deff;
		atk = atkk;
		matk = matkk;
		price = cost;
		List<ItemTyp> res = new ArrayList<ItemTyp>();
		res.add(ItemTyp.CLOTH);
		res.add(ItemTyp.LIGHT);
		res.add(ItemTyp.HEAVY);
		res.add(ItemTyp.PLATE);
		restriction = new ScrollRestriction(res);
	}

	public Scroll(String namee, int deff, int atkk, int matkk, double cost,
			ScrollRestriction res) {
		name = namee;
		def = deff;
		atk = atkk;
		matk = matkk;
		price = cost;
		restriction = res;
	}

	public Scroll(String name, int def, int atk, int matk, int str, int vint,
			int stamina, double price, ScrollRestriction restriction, int crit,
			int bal, int critres, int aspd, int bonus, ItemTyp bonus_type) {
		super();
		this.name = name;
		this.def = def;
		this.atk = atk;
		this.matk = matk;
		this.str = str;
		this.vint = vint;
		this.stamina = stamina;
		this.price = price;
		this.restriction = restriction;
		this.crit = crit;
		this.bal = bal;
		this.critres = critres;
		this.aspd = aspd;
		this.bonus = bonus;
		this.bonus_type = bonus_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
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

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ScrollRestriction getRestriction() {
		return restriction;
	}

	public void setRestriction(ScrollRestriction restriction) {
		this.restriction = restriction;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getCritres() {
		return critres;
	}

	public void setCritres(int critres) {
		this.critres = critres;
	}

	public int getAspd() {
		return aspd;
	}

	public void setAspd(int aspd) {
		this.aspd = aspd;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public ItemTyp getBonus_type() {
		return bonus_type;
	}

	public void setBonus_type(ItemTyp bonus_type) {
		this.bonus_type = bonus_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aspd;
		result = prime * result + atk;
		result = prime * result + bal;
		result = prime * result + bonus;
		result = prime * result
				+ ((bonus_type == null) ? 0 : bonus_type.hashCode());
		result = prime * result + crit;
		result = prime * result + critres;
		result = prime * result + def;
		result = prime * result + matk;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((restriction == null) ? 0 : restriction.hashCode());
		result = prime * result + stamina;
		result = prime * result + str;
		result = prime * result + vint;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scroll other = (Scroll) obj;
		if (aspd != other.aspd)
			return false;
		if (atk != other.atk)
			return false;
		if (bal != other.bal)
			return false;
		if (bonus != other.bonus)
			return false;
		if (bonus_type != other.bonus_type)
			return false;
		if (crit != other.crit)
			return false;
		if (critres != other.critres)
			return false;
		if (def != other.def)
			return false;
		if (matk != other.matk)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (restriction == null) {
			if (other.restriction != null)
				return false;
		} else if (!restriction.equals(other.restriction))
			return false;
		if (stamina != other.stamina)
			return false;
		if (str != other.str)
			return false;
		if (vint != other.vint)
			return false;
		return true;
	}

}
