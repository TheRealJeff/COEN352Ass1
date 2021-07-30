package coen352ass1;

public class WarehouseInventory implements ADTDictionary {

	//TODO: implement new methods from the ADT and determine what other code items we need from the 9 tasks of problem 5
	//TODO: create new test file for this class that will correspond to the 9 tasks of problem 5

	@Override
	public void clear() {

	}

	@Override
	public void insert(Object k, Object o) {

	}

	@Override
	public Object remove(Object k) {
		return null;
	}

	@Override
	public Object removeAny() {
		return null;
	}

	@Override
	public Object find(Object k) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}








	/*
	DLDictionary <String, InventoryRecord> records;
	public WarehouseInventory()
	{
		records = new DLDictionary <String, InventoryRecord> ();
	}
	// since it is not specified whether the insert function should accept a KVpair or a String and InventoryRecord object, I program both
	public void insert(String sku, InventoryRecord inv)
	{
		records.insert(sku, inv);
	}
	public void insert(KVpair <String, InventoryRecord> toAdd)
	{
		records.insert(toAdd.key(), toAdd.value());
	}
	public void insert(String [] skuArr, InventoryRecord[] invArr)
	{
		// if records are added in this way, we need to ensure arrays have the same length
		if(skuArr.length == invArr.length)
		{
			for(int i = 0; i < invArr.length; i++)
			{
				records.insert(skuArr[i], invArr[i]);
			}
		}
		else
		{
			System.out.println("Array sizes do not match. Records not added.");
		}
		
	}
	public void insert(KVpair <String, InventoryRecord> [] recs)
	{
		for(int i = 0; i < recs.length; i++)
		{
			records.insert(recs[i].key(), recs[i].value());
		}
	}
	public InventoryRecord remove(String key)
	{
		return records.remove(key); // use remove function of DLDictionary
	}
	public void removeAll()
	{
		records.clear();
	}
	public InventoryRecord find(String toFind)
	{
		return records.find(toFind);
	}
	public int num_of_inventories()
	{
		return records.size();
	}

	 */
	
}
/*

STILL NEED TO IMPLEMENT
6. Return the key or a set of keys with a given value
7. Retrieve records that have the value �Reordered�
9. Return the total value of al the inentories
*/