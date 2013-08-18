package net.nexon.vindictus.itemcomparer.modell;

public class Gloves extends Item {


	public Gloves(Gloves item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public Gloves() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gloves(ItemSet iset,String name,int level, ItemTyp typ,int def, int str, int vint, int agi, int crit_res) {
		super( iset, name, level, typ,def,  str, vint, agi, crit_res); 
	}


}
