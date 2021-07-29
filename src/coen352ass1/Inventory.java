package coen352ass1;

public class Inventory {
	String description, bin, location, unit;
	int qty, reorder_qty;
	double cost;
	public Inventory()
	{
		description = "";
		bin = "";
		location = "";
		unit = "";
		qty = 0;
		reorder_qty = 0;
		cost = 0;
	}
	public Inventory(String dsc, String bn, String loc, String un, int qt, int r_qt, double cs)
	{
		description = dsc;
		bin = bn;
		location = loc;
		unit = un;
		qty = qt;
		reorder_qty = r_qt;
		cost = cs;
	}
	// not sure if setters and getters are necessary, but I will assume they are
	// followed Java convention for naming get/set functions
	public void setDescription(String dsc)
	{
		description = dsc;
	}
	public void setBin(String bn)
	{
		bin = bn;
	}
	public void setLocation(String loc)
	{
		location = loc;
	}
	public void setUnit(String un)
	{
		unit = un;
	}
	public void setQuantity(int qt)
	{
		qty = qt;
	}
	public void setReorder_Quantity(int r_qt)
	{
		reorder_qty = r_qt;
	}
	public void setCost(double cs)
	{
		cost = cs;
	} 
	public String getDescription()
	{
		return description;
	}
	public String getBin()
	{
		return bin;
	}
	public String getLocation()
	{
		return location;
	}
	public String getUnit()
	{
		return unit;
	}
	public int getQuantity()
	{
		return qty;
	}
	public int getReorderQuantity()
	{
		return reorder_qty;
	}
	public double getCost()
	{
		return cost;
	}
	// determine if the Inventory is reordered: if reorder quantity exceeds the quantity, the inventory is reordered
	public boolean reordered()
	{
		return (reorder_qty > qty);
	}
	// calculate the inventory value by finding product of quantity and cost per item
	public double inventory_value()
	{
		return qty * cost;
	}
	public boolean sameAs(Inventory toCompare) // will be needed for the finding of record given a key
	{
		return 
		(description == toCompare.description) &&
		(bin == toCompare.bin) &&
		(location == toCompare.location) &&
		(unit == toCompare.unit) &&
		(qty == toCompare.qty) &&
		(reorder_qty == toCompare.reorder_qty) &&
		(cost == toCompare.cost);
		// two Inventory objects are the same iff all fields are the same
	}
}
