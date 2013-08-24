package net.nexon.vindictus.itemcomparer.modell.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.nexon.vindictus.itemcomparer.modell.Scroll;

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

	public Scroll_Suf(int stam, String namee, int deff, int atkk, int matkk,
			double cost) {
		super(namee, deff, atkk, matkk, cost);
		this.setStamina(stam);
	}
}
