package net.nexon.vindictus.itemcomparer.modell;

import java.util.ArrayList;

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
		restriction = new ScrollRestriction(new ArrayList<ItemTyp>(),
				new ArrayList<String>());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atk;
		result = prime * result + def;
		result = prime * result + matk;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (atk != other.atk)
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
		if (stamina != other.stamina)
			return false;
		if (str != other.str)
			return false;
		if (vint != other.vint)
			return false;
		return true;
	}

}
