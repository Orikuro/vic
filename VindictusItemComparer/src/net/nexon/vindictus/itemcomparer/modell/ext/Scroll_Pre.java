package net.nexon.vindictus.itemcomparer.modell.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.nexon.vindictus.itemcomparer.modell.Scroll;
import net.nexon.vindictus.itemcomparer.modell.ScrollRestriction;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

@XmlAccessorType(XmlAccessType.FIELD)
public class Scroll_Pre extends Scroll {

	public Scroll_Pre(String namee, int deff, int atkk, int matkk) {
		super(namee, deff, atkk, matkk);
	}

	public Scroll_Pre() {
	}

	public Scroll_Pre(String namee, int deff, int atkk, int matkk, double cost) {
		super(namee, deff, atkk, matkk, cost);
	}
	
	public Scroll_Pre(String namee, int deff, int atkk, int matkk, double cost, ScrollRestriction res) {
		super(namee, deff, atkk, matkk, cost, res);
	}
	
	public Scroll_Pre(String name, int def, int atk, int matk, int str, int vint,
			int stamina, double price, ScrollRestriction restriction, int crit,
			int bal, int critres, int aspd, int bonus, ItemTyp bonus_type)
	{
		super(name, def, atk, matk, str, vint,stamina,price,restriction, crit, bal, critres, aspd, bonus, bonus_type);
	}

}
