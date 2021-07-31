package coen352ass1;

// objects of this class will have all information from first two Excel sheets
public class InventoryRecord {
	private String sku;
	private String description;
	private String bin;
	private String location;
	private String unit;
	private String orderNum;
	private long qty;
	private long reorderQty;
	private long cost;
	private long pickQty;

	public InventoryRecord()
	{
		description = "";
		bin = "";
		location = "";
		unit = "";
		qty = 0;
		reorderQty = 0;
		cost = 0;
		orderNum = "";
		pickQty = 0;
	}

	public InventoryRecord(String s, String dsc, String bn, String loc, String un, long qt, long r_qt, long cs, String oNum, long pick)
	{
		sku = s;
		description = dsc;
		bin = bn;
		location = loc;
		unit = un;
		qty = qt;
		reorderQty = r_qt;
		cost = cs;
		orderNum = oNum;
		pickQty = pick;
	}

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
	
	public String getOrderNum()
	{
		return orderNum;
	}
	
	public void setOrderNum(String oNum)
	{
		orderNum = oNum;
	}
	
	public long getPickQty()
	{
		return pickQty;
	}
	
	public void setPickQty(long pick)
	{
		pickQty = pick;
	}


	// determine if the InventoryRecord is reordered: if reorder quantity exceeds the quantity, the inventory is reordered
	public boolean reordered()
	{
		return (reorderQty > qty);
	}

	// calculate the inventory value by finding product of quantity and cost per item
	public double inventory_value()
	{
		return qty * cost;
	}

	//determine is passed record is identical to the record calling the method
	public boolean sameAs(InventoryRecord toCompare) // will be needed for the finding of record given a key
	{
		return 
		(description == toCompare.description) &&
		(bin == toCompare.bin) &&
		(location == toCompare.location) &&
		(unit == toCompare.unit) &&
		(qty == toCompare.qty) &&
		(reorderQty == toCompare.reorderQty) &&
		(cost == toCompare.cost) &&
		(pickQty == toCompare.pickQty) &&
		(orderNum == toCompare.orderNum);
		// two InventoryRecord objects are called the same iff all fields are the same (except SKU)
	}
}
