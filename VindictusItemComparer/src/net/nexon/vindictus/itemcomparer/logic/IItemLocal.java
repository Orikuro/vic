package net.nexon.vindictus.itemcomparer.logic;

import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.enu.VChar;

public interface IItemLocal {
	
	public void filterChar(Items items, VChar vchar);

	public void filterLevel(Items items, int min, int max);

	public void filterPrice(Items items, double price);

	public void filterStars(Items items, int smin, int smax);

	public void filterSetNames(Items items, String setnames);

	public boolean isNotEnough(Items items);

	public void forcePlus(Items items, int plus);

	public void duplicateForce(Items items, boolean keepChanged);

	public void duplicateEnthu(Items items, boolean keepChanged);

	public void duplicateTutSentinel(Items items, boolean keepChanged);

	public void duplicateTutArmadilo(Items items, boolean keepChanged);

	public void duplicateTutResistant(Items items, boolean keepChanged);

	public void duplicateF_Enthu(Items items, boolean keepChanged);

	public void duplicateTS_Enthu(Items items, boolean keepChanged);

	public void duplicateTA_Enthu(Items items, boolean keepChanged);

	public void duplicateTs_Ta(Items items, boolean keepChanged);

	public void duplicateTs_Tr(Items items, boolean keepChanged);

	public void duplicateTs_Tr_Ta(Items items, boolean keepChanged);

	public void duplicateTs_Ta_Enthu(Items items, boolean keepChanged);
	
	public void sortItems(Items items);
}
