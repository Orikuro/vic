package net.nexon.vindictus.itemcomparer.modell;

import java.util.List;

public class ItemSet {

	private int[] totaldefBonus = new int[6];
	private int[] totalIntBonus = new int[6];
	private double[] totalAtkBonus = new double[6];
	private int[] totalMatkBonus = new int[6];

	public int getDefBonus(int count) {

		return totaldefBonus[count];

	}

	private void setDefBonus() {
		totaldefBonus[2] = boni.get(0).getDef()
				+ (int) (boni.get(0).getAgi() * 0.5f);
		totaldefBonus[3] = boni.get(1).getDef()
				+ (int) (boni.get(1).getAgi() * 0.5f);
		totaldefBonus[4] = boni.get(2).getDef()
				+ (int) (boni.get(2).getAgi() * 0.5f);
		totaldefBonus[5] = boni.get(3).getDef()
				+ (int) (boni.get(3).getAgi() * 0.5f);

	}

	private void setIntBonus() {
		totalIntBonus[2] = boni.get(0).getVint();
		totalIntBonus[3] = boni.get(1).getVint();
		totalIntBonus[4] = boni.get(2).getVint();
		totalIntBonus[5] = boni.get(3).getVint();

	}

	private void setAtkBonus() {
		totalAtkBonus[2] = (2.7 * boni.get(0).getStr()) + boni.get(0).getAtk();
		totalAtkBonus[3] = (2.7 * boni.get(1).getStr()) + boni.get(1).getAtk();
		totalAtkBonus[4] = (2.7 * boni.get(2).getStr()) + boni.get(2).getAtk();
		totalAtkBonus[5] = (2.7 * boni.get(3).getStr()) + boni.get(3).getAtk();

	}

	private void setMatkBonus() {
		totalMatkBonus[2] = boni.get(0).getVint() * 2;
		totalMatkBonus[3] = boni.get(1).getVint() * 2;
		totalMatkBonus[4] = boni.get(2).getVint() * 2;
		totalMatkBonus[5] = boni.get(3).getVint() * 2;

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

	@Override
	public String toString() {
		return String.format("%s", name);
	}

	private String name;

	private List<ItemSetBonus> boni;

	private String usefulChars = "evie fiona lann vella karok kai hurk";

	public ItemSet() {

	}

	public ItemSet(String setname, List<ItemSetBonus> boni2) {
		name = setname;
		boni = boni2;
		setDefBonus();
		setIntBonus();
		setAtkBonus();
		setMatkBonus();
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
		if (boni.size()==4){
			setDefBonus();
			setIntBonus();
			setAtkBonus();
			setMatkBonus();
		}
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

}
