package net.nexon.vindictus.itemcomparer.modell;

public class Scroll_Suf extends Scroll {

	public Scroll_Suf(String namee, int deff, int atkk, int matkk) {
		super(namee,deff,atkk,matkk);
	}

	public Scroll_Suf() {
		// TODO Auto-generated constructor stub
	}

	public Scroll_Suf(String namee, int deff, int atkk, int matkk, double cost) {
		super(namee,deff,atkk,matkk, cost);
	}

	public Scroll_Suf(int stam, String namee, int deff, int atkk, int matkk, double cost) {
		super(namee,deff,atkk,matkk, cost);
		this.setStamina(stam);
	}
}
