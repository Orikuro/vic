package net.nexon.vindictus.itemcomparer.modell.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.nexon.vindictus.itemcomparer.modell.Item;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

@XmlAccessorType(XmlAccessType.FIELD)
public class Gloves extends Item {

	public Gloves(Gloves item) {
		super(item);
		
	}

	public Gloves() {
		super();
		
	}

	public Gloves(ItemSet iset, String name, int level, ItemTyp typ, int def,
			int str, int vint, int agi, int crit_res) {
		super(iset, name, level, typ, def, str, vint, agi, crit_res);
	}

}
