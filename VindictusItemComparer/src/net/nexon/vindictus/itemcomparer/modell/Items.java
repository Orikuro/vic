package net.nexon.vindictus.itemcomparer.modell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import net.nexon.vindictus.itemcomparer.modell.ext.Armor;
import net.nexon.vindictus.itemcomparer.modell.ext.Gloves;
import net.nexon.vindictus.itemcomparer.modell.ext.Helm;
import net.nexon.vindictus.itemcomparer.modell.ext.Pants;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Pre;
import net.nexon.vindictus.itemcomparer.modell.ext.Scroll_Suf;
import net.nexon.vindictus.itemcomparer.modell.ext.Shoes;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Items {

	private List<Shoes> shoes;
	private List<Pants> pants;
	private List<Gloves> gloves;
	private List<Armor> armors;
	private List<Helm> helms;

	private HashSet<ItemSet> anitemset;
	private HashSet<Scroll_Pre> acrollpres;
	private HashSet<Scroll_Suf> ascrollsufs;

	public Items() {

		shoes = new ArrayList<>();
		pants = new ArrayList<>();
		gloves = new ArrayList<>();
		armors = new ArrayList<>();
		helms = new ArrayList<>();
		anitemset = new HashSet<>();
		acrollpres = new HashSet<>();
		ascrollsufs = new HashSet<>();
	}

	public Items(List<Shoes> shoes, List<Pants> pants, List<Gloves> gloves,
			List<Armor> armors, List<Helm> helms) {
		super();
		this.shoes = shoes;
		this.pants = pants;
		this.gloves = gloves;
		this.armors = armors;
		this.helms = helms;
	}

	public Items(HashSet<ItemSet> isets2, List<Shoes> shoes2,
			List<Pants> pants2, List<Gloves> gloves2, List<Armor> armors2,
			List<Helm> helms2) {
		super();
		this.shoes = shoes2;
		this.pants = pants2;
		this.gloves = gloves2;
		this.armors = armors2;
		this.helms = helms2;
		anitemset = isets2;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	public List<Pants> getPants() {
		return pants;
	}

	public void setPants(List<Pants> pants) {
		this.pants = pants;
	}

	public List<Gloves> getGloves() {
		return gloves;
	}

	public void setGloves(List<Gloves> gloves) {
		this.gloves = gloves;
	}

	public List<Armor> getArmors() {
		return armors;
	}

	public void setArmors(List<Armor> armors) {
		this.armors = armors;
	}

	public List<Helm> getHelms() {
		return helms;
	}

	public void setHelms(List<Helm> helms) {
		this.helms = helms;
	}

	public HashSet<ItemSet> getIsets() {
		return anitemset;
	}

	public void setIsets(HashSet<ItemSet> isets) {
		this.anitemset = isets;
	}

	public HashSet<Scroll_Pre> getPres() {
		return acrollpres;
	}

	public void setPres(HashSet<Scroll_Pre> pres) {
		this.acrollpres = pres;
	}

	public HashSet<Scroll_Suf> getSufs() {
		return ascrollsufs;
	}

	public void setSufs(HashSet<Scroll_Suf> sufs) {
		this.ascrollsufs = sufs;
	}

}
