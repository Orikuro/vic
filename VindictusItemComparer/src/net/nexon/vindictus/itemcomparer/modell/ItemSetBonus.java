package net.nexon.vindictus.itemcomparer.modell;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSetBonus {

	private int def;
	private int str;
	private int vint;
	private int agi;
	private int atk;
	private int sta;
	
	public ItemSetBonus(){
		
	}
	
	public ItemSetBonus(int sdef, int sstr, int sint, int sagi, int satk) {
		def = sdef;
		str = sstr;
		vint = sint;
		agi = sagi;
		atk = satk;
	}
	public ItemSetBonus(int deff, int strr, int intt) {
		def = deff;
		str = strr;
		vint = intt;
	}
	public ItemSetBonus(int deff, int strr) {
		def = deff;
		str = strr;
	}
	public ItemSetBonus(int deff, int strr, int intt, int agii) {
		def = deff;
		str = strr;
		vint = intt;
		agi = agii;
	}

	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getVint() {
		return vint;
	}
	public void setVint(int vint) {
		this.vint = vint;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}
	
	
}
