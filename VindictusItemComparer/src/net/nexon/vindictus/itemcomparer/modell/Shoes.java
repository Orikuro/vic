package net.nexon.vindictus.itemcomparer.modell;

public class Shoes extends Item {


	public Shoes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shoes(ItemSet iset,String name,int level, ItemTyp typ,int def, int str, int vint, int agi, int crit_res) {
		super( iset, name, level, typ,def,  str, vint, agi, crit_res); 
	}

	public Shoes(Shoes s) {
		super(s);
	}




}
