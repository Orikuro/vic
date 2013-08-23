package net.nexon.vindictus.itemcomparer.modell.ext;

import net.nexon.vindictus.itemcomparer.modell.Item;
import net.nexon.vindictus.itemcomparer.modell.ItemSet;
import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

public class Helm extends Item {

	public Helm(Helm item) {
		super(item);
	}

	public Helm() {
		super();
	}

	public Helm(ItemSet iset, String name, int level, ItemTyp typ, int def,
			int str, int vint, int agi, int crit_res) {
		super(iset, name, level, typ, def, str, vint, agi, crit_res);
	}

}
