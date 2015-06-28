package net.nexon.vindictus.itemcomparer.modell;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSet {

	public void calcBonus() {
		setDefBonus();
		setIntBonus();
		setAtkBonus();
		setMatkBonus();
		setStaBonus();
	}

	private static int counter = 0;

	@XmlAttribute
	@XmlID
	private String id;

	@XmlTransient
	private int[] totaldefBonus = new int[7];
	@XmlTransient
	private int[] totalIntBonus = new int[7];
	@XmlTransient
	private double[] totalAtkBonus = new double[7];
	@XmlTransient
	private int[] totalMatkBonus = new int[7];
	@XmlTransient
	private int[] totalStaBonus = new int[7];

	
	public int getDefBonus(int count) {

		return totaldefBonus[count];

	}

	private void setDefBonus() {
		for (int i = 0; i < boni.size(); i++) {
			totaldefBonus[i + 2] = boni.get(i).getDef()
					+ (int) (boni.get(i).getAgi() * 0.5f);
		}
	}

	private void setIntBonus() {
		for (int i = 0; i < boni.size(); i++) {
			totalIntBonus[i + 2] = boni.get(i).getVint();
		}
	}

	private void setAtkBonus() {
		for (int i = 0; i < boni.size(); i++) {
			totalAtkBonus[i + 2] = (2.7 * boni.get(i).getStr())
					+ boni.get(i).getAtk();
		}
	}

	private void setMatkBonus() {
		for (int i = 0; i < boni.size(); i++) {
			totalMatkBonus[i+2] = boni.get(i).getVint() * 2;
		}
	}

	private void setStaBonus() {
		for (int i = 0; i < boni.size(); i++) {
			totalStaBonus[i+2] = boni.get(i).getSta();
		}
	}
	
	public int getIntBonus(int count) {

		return totalIntBonus[count];
	}

	public double getAtkBonus(int count) {

		return totalAtkBonus[count];
	}

	public int getMatkBonus(int count) {

		return totalMatkBonus[count];
	}

	public int getStaBonus(int count) {

		return totalStaBonus[count];
	}
	
	@Override
	public String toString() {
		return String.format("%s", name);
	}

	private String name;

	private List<ItemSetBonus> boni;

	private String usefulChars = "evie fiona lann vella karok kai hurk";

	public ItemSet() {
		id = counter++ + "";
	}

	public ItemSet(String setname, List<ItemSetBonus> boni2) {
		name = setname;
		boni = boni2;
		setDefBonus();
		setIntBonus();
		setAtkBonus();
		setMatkBonus();
		id = counter++ + "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemSetBonus> getBoni() {
		return boni;
	}

	public void setBoni(List<ItemSetBonus> boni) {
		this.boni = boni;
		setDefBonus();
		setIntBonus();
		setAtkBonus();
		setMatkBonus();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSet other = (ItemSet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getUsefulChars() {
		return usefulChars;
	}

	public void setUsefulChars(String usefulChars) {
		this.usefulChars = usefulChars;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
