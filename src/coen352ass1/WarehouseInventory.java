package coen352ass1;

public class WarehouseInventory {


	//TODO: create new test file for this class that will correspond to the 9 tasks of problem 5
/*
 * 
 * 	//TODO: implement new methods from the ADT and determine what other code items we need from the 9 tasks of problem 5
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
	}*/


	DLDictionary <String, InventoryRecord> invRecords; // sku will be the key
	DLDictionary <String, BinRecord> binRecords; // binNumber will be the key
	public WarehouseInventory()
	{
		invRecords = new DLDictionary <String, InventoryRecord> ();
		binRecords = new DLDictionary <String, BinRecord> ();
	}
	// insert functions: the user can insert BinRecords or InventoryRecords
	
	// inserting InventoryRecords
	public void insert(String sku, InventoryRecord inv)
	{
		invRecords.insert(sku, inv);
	}
	public void insert(InventoryRecord inv)
	{
		invRecords.insert(inv.getSku(), inv);
	}
	public void insert(String [] skuArr, InventoryRecord[] invArr)
	{
		// if records are added in this way, we need to ensure arrays have the same length
		if(skuArr.length == invArr.length)
		{
			for(int i = 0; i < invArr.length; i++)
			{
				invRecords.insert(skuArr[i], invArr[i]);
			}
		}
		else
		{
			System.out.println("Array sizes do not match. Records not added.");
		}
		
	}
	public void insert(InventoryRecord [] invArr)
	{
		for(int i = 0; i < invArr.length; i++)
		{
			invRecords.insert(invArr[i].getSku(), invArr[i]);
		}
	}
	
	// inserting BinRecords
	public void insert(String bNum, BinRecord bin)
	{
		binRecords.insert(bNum, bin);
	}
	public void insert(BinRecord bin)
	{
		binRecords.insert(bin.getBinNum(), bin);
	}
	public void insert(String [] bNumArr, BinRecord[] binArr)
	{
		// if records are added in this way, we need to ensure arrays have the same length
		if(bNumArr.length == binArr.length)
		{
			for(int i = 0; i < binArr.length; i++)
			{
				binRecords.insert(bNumArr[i], binArr[i]);
			}
		}
		else
		{
			System.out.println("Array sizes do not match. Records not added.");
		}
		
	}
	public void insert(BinRecord [] binArr)
	{
		for(int i = 0; i < binArr.length; i++)
		{
			binRecords.insert(binArr[i].getBinNum(), binArr[i]);
		}
	}
	public InventoryRecord removeInvRecord(String sku)
	{
		return invRecords.remove(sku); // use remove function of DLDictionary
	}
	public BinRecord removeBinRecord(String binNum)
	{
		return binRecords.remove(binNum);
	}
	public void removeAll()
	{
		invRecords.clear();
		binRecords.clear();
	}
	public InventoryRecord findInvRecord(String sku)
	{
		return invRecords.find(sku);
	}
	public BinRecord findBinRecord(String binNum)
	{
		return binRecords.find(binNum);
	}
	public int numInvRecords() // return the number of inventories in the database
	{
		return invRecords.size();
	}
	public long totalInventoryValue()
	{
		long sumOfValues = 0;
		for(int k = 0; k < invRecords.size(); k++)
		{
			sumOfValues += invRecords.getByIndex(k).value().inventory_value(); // add value of each InventoryRecord to the sum
		}
		return sumOfValues;
	}
	// retrieve records which are reordered
	// return them in the form of a DList
	public DList<InventoryRecord> getReorderedRecords()
	{
		DList<InventoryRecord> reorderedRecords;
		reorderedRecords = new DList<InventoryRecord> ();
		for(int k = 0; k < invRecords.size(); k++)
		{
			if(invRecords.getByIndex(k).value().reordered())
			{
				reorderedRecords.insert(invRecords.getByIndex(k).value());
			}
		}
		return reorderedRecords;
	}
	// return sku strings associated with argument value
	public DList<String> getByValue(InventoryRecord valToFind)
	{
		DList<String> keysMatchingValue;
		keysMatchingValue = new DList <String> ();
		for(int i = 0; i < invRecords.size(); i++)
		{
			if(valToFind.sameAs(invRecords.getByIndex(i).value()))
			{
				keysMatchingValue.insert(invRecords.getByIndex(i).key());
			}
		}
		return keysMatchingValue;
	}
	
	// return bin numbers associated with argument BinRecord
	public DList<String> getByValue(BinRecord valToFind)
	{
		DList<String> keysMatchingValue;
		keysMatchingValue = new DList <String> ();
		for(int i = 0; i < invRecords.size(); i++)
		{
			if(valToFind.sameAs(binRecords.getByIndex(i).value()))
			{
				keysMatchingValue.insert(binRecords.getByIndex(i).key());
			}
		}
		return keysMatchingValue;
	}
	
}

