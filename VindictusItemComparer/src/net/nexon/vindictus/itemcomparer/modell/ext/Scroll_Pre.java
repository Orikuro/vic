package net.nexon.vindictus.itemcomparer.modell.ext;

import net.nexon.vindictus.itemcomparer.modell.Scroll;

public class Scroll_Pre extends Scroll {

	public Scroll_Pre(String namee, int deff, int atkk, int matkk) {
		super(namee, deff, atkk, matkk);
	}

	public Scroll_Pre() {
	}

	public Scroll_Pre(String namee, int deff, int atkk, int matkk, double cost) {
		super(namee, deff, atkk, matkk, cost);
	}

}
