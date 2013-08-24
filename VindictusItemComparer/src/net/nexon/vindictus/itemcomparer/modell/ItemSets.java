package net.nexon.vindictus.itemcomparer.modell;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSets {

	
	private HashSet<ItemSet> sets;
	
	public ItemSets(){
		sets = new HashSet<>();
	}
	
	public ItemSets(HashSet<ItemSet> itemsets){
		sets = itemsets;
	}


	public HashSet<ItemSet> getSets() {
		return sets;
	}


	public void setSets(HashSet<ItemSet> sets) {
		this.sets = sets;
	}
	
	
}
