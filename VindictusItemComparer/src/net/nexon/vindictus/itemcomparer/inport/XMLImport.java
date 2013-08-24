package net.nexon.vindictus.itemcomparer.inport;

import java.io.File;

import javax.xml.bind.JAXB;

import net.nexon.vindictus.itemcomparer.modell.Items;
import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

public class XMLImport {


	public static Items importItems(String filename) throws Exception{
		Items i = JAXB.unmarshal( new File(filename), Items.class );
		initialiseItems(i);
		return i;	
	}
	
	private static void initialiseItems(Items items){
		for (Shoes s : items.getShoes()) {
			s.getItemset().calcBonus();
			s.calcBonus();
		}
		for (Pants s : items.getPants()) {
			s.getItemset().calcBonus();
			s.calcBonus();
		}
		for (Gloves s : items.getGloves()) {
			s.getItemset().calcBonus();
			s.calcBonus();
		}
		for (Armor s : items.getArmors()) {
			s.getItemset().calcBonus();
			s.calcBonus();
		}
		for (Helm s : items.getHelms()) {
			s.getItemset().calcBonus();
			s.calcBonus();
		}
		
		
	}
	
}
