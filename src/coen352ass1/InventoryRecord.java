package coen352ass1;

public class InventoryRecord {
	private String sku;
	private String description;
	private String bin;
	private String location;
	private String unit;
	private long qty;
	private long reorderQty;
	private long cost;
	private long inventoryValue;
	private boolean reorderFlag;

	/*public InventoryRecord()
	{
		description = "";
		bin = "";
		location = "";
		unit = "";
		qty = 0;
		reorder_qty = 0;
		cost = 0;
	}

	public InventoryRecord(String dsc, String bn, String loc, String un, int qt, int r_qt, double cs)
	{
		description = dsc;
		bin = bn;
		location = loc;
		unit = un;
		qty = qt;
		reorder_qty = r_qt;
		cost = cs;
	}*/

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public long getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(long reorderQty) {
		this.reorderQty = reorderQty;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public long getInventoryValue() {
		return inventoryValue;
	}

	public void setInventoryValue(long inventoryValue) {
		this.inventoryValue = inventoryValue;
	}

	public boolean isReorderFlag() {
		return reorderFlag;
	}

	public void setReorderFlag(boolean reorderFlag) {
		this.reorderFlag = reorderFlag;
	}

	//TODO: Check if we need these functions

	// determine if the InventoryRecord is reordered: if reorder quantity exceeds the quantity, the inventory is reordered
	public boolean reordered()
	{
		return (reorder_qty > qty);
	}
	// calculate the inventory value by finding product of quantity and cost per item
	public double inventory_value()
	{
		return qty * cost;
	}
	public boolean sameAs(InventoryRecord toCompare) // will be needed for the finding of record given a key
	{
		return 
		(description == toCompare.description) &&
		(bin == toCompare.bin) &&
		(location == toCompare.location) &&
		(unit == toCompare.unit) &&
		(qty == toCompare.qty) &&
		(reorder_qty == toCompare.reorder_qty) &&
		(cost == toCompare.cost);
		// two InventoryRecord objects are the same iff all fields are the same
	}
}
