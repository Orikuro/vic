package net.nexon.vindictus.itemcomparer.inport;

import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;

public class StaticScrolls {
	
	private static ScrollProperty SCRPROP = new ScrollProperty();
	
	private static Scroll_Suf enthu = new Scroll_Suf("Enthu", -370, 270, 282,
			SCRPROP.getEnthu());
	private static Scroll_Suf force = new Scroll_Suf("Force", -28, 140, 132,
			SCRPROP.getForce());
	private static Scroll_Pre tut = new Scroll_Pre("Tutelary", 112, 0, 0,
			SCRPROP.getTut());
	private static Scroll_Pre wb = new Scroll_Pre("Well-balanced", 0, 0, 0,
			SCRPROP.getWb());
	private static Scroll_Suf sent = new Scroll_Suf("Sentinel", 224, -15, 0,
			SCRPROP.getSenti());
	private static Scroll_Suf resist = new Scroll_Suf("Resistant", 340, -160,
			0, SCRPROP.getRes());
	private static Scroll_Suf armadil = new Scroll_Suf(5, "Armadillo", 336, 0,
			0, SCRPROP.getArmadi());
	private static Scroll_Suf master = new Scroll_Suf("Master", 0, 0, 0,
			SCRPROP.getMaster());
	

}
