package net.nexon.vindictus.itemcomparer.logic.comparators;

import java.util.Comparator;

import net.nexon.vindictus.itemcomparer.modell.Item;

public class ItemLevelComparator implements Comparator<Item>{


	@Override
	public int compare(Item arg0, Item arg1) {
		Integer a = arg0.getLevel();
		Integer b = arg1.getLevel();
		return b.compareTo(a);
	}

}
