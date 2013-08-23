package net.nexon.vindictus.itemcomparer.modell.ext;

import net.nexon.vindictus.itemcomparer.modell.Item;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

public class Armor extends Item {

	public Armor(Armor item) {
		super(item);

	}

	public Armor() {
		super();

	}

	public Armor(ItemSet iset, String name, int level, ItemTyp typ, int def,
			int str, int vint, int agi, int crit_res) {
		super(iset, name, level, typ, def, str, vint, agi, crit_res);
	}

}
