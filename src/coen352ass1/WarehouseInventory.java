package coen352ass1;

public class WarehouseInventory {
	DLDictionary <String, Inventory> records;
	public WarehouseInventory()
	{
		records = new DLDictionary <String, Inventory> ();
	}
	// since it is not specified whether the insert function should accept a KVpair or a String and Inventory object, I program both
	public void insert(String sku, Inventory inv)
	{
		records.insert(sku, inv);
	}
	public void insert(KVpair <String, Inventory> toAdd)
	{
		records.insert(toAdd.key(), toAdd.value());
	}
	public void insert(String [] skuArr, Inventory [] invArr)
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
	public void insert(KVpair <String, Inventory> [] recs)
	{
		for(int i = 0; i < recs.length; i++)
		{
			records.insert(recs[i].key(), recs[i].value());
		}
	}
	public Inventory remove(String key)
	{
		return records.remove(key); // use remove function of DLDictionary
	}
	public void removeAll()
	{
		records.clear();
	}
	public Inventory find(String toFind)
	{
		return records.find(toFind);
	}
	public int num_of_inventories()
	{
		return records.size();
	}
	
}
/*

STILL NEED TO IMPLEMENT
6. Return the key or a set of keys with a given value
7. Retrieve records that have the value “Reordered”
9. Return the total value of al the inentories
*/