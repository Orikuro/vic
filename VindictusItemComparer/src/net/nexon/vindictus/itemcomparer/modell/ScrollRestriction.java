package net.nexon.vindictus.itemcomparer.modell;

import java.util.ArrayList;
import java.util.List;

import net.nexon.vindictus.itemcomparer.modell.enu.ItemTyp;

public class ScrollRestriction {

	private List<ItemTyp> itemtype;
	private List<String> itemslots;

	public ScrollRestriction(List<ItemTyp> itemtype, List<String> itemslots) {
		super();
		this.itemtype = itemtype;
		this.itemslots = itemslots;
	}

	public ScrollRestriction(List<ItemTyp> itemtype) {
		super();
		this.itemtype = itemtype;
		itemslots = new ArrayList<>();
		itemslots.add("Armor");
		itemslots.add("Helm");
		itemslots.add("Pants");
		itemslots.add("Gloves");
		itemslots.add("Shoes");
	}

	public List<ItemTyp> getItemtype() {
		return itemtype;
	}

	public void setItemtype(List<ItemTyp> itemtype) {
		this.itemtype = itemtype;
	}

	public List<String> getItemslots() {
		return itemslots;
	}

	public void setItemslots(List<String> itemslots) {
		this.itemslots = itemslots;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemslots == null) ? 0 : itemslots.hashCode());
		result = prime * result
				+ ((itemtype == null) ? 0 : itemtype.hashCode());
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
		ScrollRestriction other = (ScrollRestriction) obj;
		if (itemslots == null) {
			if (other.itemslots != null)
				return false;
		} else if (!itemslots.equals(other.itemslots))
			return false;
		if (itemtype == null) {
			if (other.itemtype != null)
				return false;
		} else if (!itemtype.equals(other.itemtype))
			return false;
		return true;
	}

}
