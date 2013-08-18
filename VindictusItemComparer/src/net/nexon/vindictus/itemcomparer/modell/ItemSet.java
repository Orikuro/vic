package net.nexon.vindictus.itemcomparer.modell;

import java.util.List;

public class ItemSet {
	
	@Override
	public String toString() {
		return String.format("%s", name);
	}

	private String name;
	
	private List<ItemSetBonus> boni;

	private String usefulChars = "evie fiona lann vella karok kai hurk";

	public ItemSet(){
		
	}
	
	public ItemSet(String setname, List<ItemSetBonus> boni2) {
		name = setname;
		boni = boni2;
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
	}

	public int getDefBonus(int count){
		
		if (count > 5 || count <2) return 0;
		int bonidef = boni.get(count-2).getDef();
		int agidef = (int)(boni.get(count-2).getAgi()*0.5f);
		return bonidef+agidef;
	}

	public int getIntBonus(int count){
		
		if (count > 5 || count <2) return 0;
		
		return boni.get(count-2).getVint();
	}
	public double getAtkBonus(int count){
		
		if (count > 5 || count <2) return 0;
		double strbonus = (2.7*boni.get(count-2).getStr());
		return boni.get(count-2).getAtk()+strbonus;
	}	
	public int getMatkBonus(int count){
		
		if (count > 5 || count <2) return 0;

		return boni.get(count-2).getVint()*2;
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
