package net.nexon.vindictus.itemcomparer.modell.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.nexon.vindictus.itemcomparer.modell.Scroll;
import net.nexon.vindictus.itemcomparer.modell.ScrollRestriction;

@XmlAccessorType(XmlAccessType.FIELD)
public class Scroll_Suf extends Scroll {

	public Scroll_Suf(String namee, int deff, int atkk, int matkk) {
		super(namee, deff, atkk, matkk);
	}

	public Scroll_Suf() {	
	}

	public Scroll_Suf(String namee, int deff, int atkk, int matkk, double cost) {
		super(namee, deff, atkk, matkk, cost);
	}
	
	public Scroll_Suf(String namee, int deff, int atkk, int matkk, double cost, ScrollRestriction res) {
		super(namee, deff, atkk, matkk, cost, res);
	}

	public Scroll_Suf(int stam, String namee, int deff, int atkk, int matkk,
			double cost) {
		super(namee, deff, atkk, matkk, cost);
		this.setStamina(stam);
	}
	
	public Scroll_Suf(int stam, String namee, int deff, int atkk, int matkk,
			double cost, ScrollRestriction res) {
		super(namee, deff, atkk, matkk, cost, res);
		this.setStamina(stam);
	}
}
