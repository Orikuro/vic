package net.nexon.vindictus.itemcomparer.modell;

public class Helm extends Item {

	public Helm(Helm item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public Helm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Helm(ItemSet iset,String name,int level, ItemTyp typ,int def, int str, int vint, int agi, int crit_res) {
		super( iset, name, level, typ,def,  str, vint, agi, crit_res); 
	}


}
