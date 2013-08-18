package net.nexon.vindictus.itemcomparer.modell;

public class Pants extends Item {

	public Pants(Pants item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public Pants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pants(ItemSet iset,String name,int level, ItemTyp typ,int def, int str, int vint, int agi, int crit_res) {
		super( iset, name, level, typ,def,  str, vint, agi, crit_res); 
	}

}
