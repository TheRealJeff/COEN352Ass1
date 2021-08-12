package coen352ass1;

public class WarehouseInventory {

	DLDictionary <String, InventoryRecord> invRecords; // sku will be the key
	DLDictionary <String, BinRecord> binRecords; // binNumber will be the key
	public WarehouseInventory()
	{
		invRecords = new DLDictionary <String, InventoryRecord> ();
		binRecords = new DLDictionary <String, BinRecord> ();
		
		// insert inventory records given in files
		// if item is not on inventory pick list, set pickQty as 0, orderNum as ""
		invRecords.insert("SP7875", new InventoryRecord ("SP7875", "Item 1", "T345", "Row 2, slot 1", "Each", 20, 10, 30, "TP001-1", 3));
		invRecords.insert("TR87680", new InventoryRecord ("TR87680", "Item 2", "T345", "Row 2, slot 1", "Each", 30, 15, 40, "", 0));
		invRecords.insert("MK676554", new InventoryRecord ("MK676554", "Item 3", "T5789", "Row 1, slot 1", "Each", 10, 5, 5, "TP001-1", 3));
		invRecords.insert("YE98767", new InventoryRecord ("YE98767", "Item 4", "T9876", "Row 3, slot 2", "Box (10 ct)", 40, 10, 15, "TP001-1", 1));
		invRecords.insert("XR23423", new InventoryRecord ("XR23423", "Item 5", "T098", "Row 3, slot 1", "Each", 12, 10, 26, "", 0));
		invRecords.insert("PW98762", new InventoryRecord ("PW98762", "Item 6", "T345", "Row 2, slot 1", "Each", 7, 10, 50, "", 0));
		invRecords.insert("BM87684", new InventoryRecord ("BM87684", "Item 7", "T349", "Row 1, slot 2", "Each", 10, 5, 10, "TP001-1", 2));
		invRecords.insert("BH67655", new InventoryRecord ("BH67655", "Item 8", "T5789", "Row 1, slot 1", "Each", 19, 10, 3, "", 0));
		invRecords.insert("WT98768", new InventoryRecord ("WT98768", "Item 9", "T9875", "Row 2, slot 2", "Package (5 ct)", 20, 30, 14, "", 0));
		invRecords.insert("TS3456", new InventoryRecord ("TS3456", "Item 10", "T349", "Row 1, slot 2", "Each", 15, 8, 60, "TP001-1", 6));
		invRecords.insert("WDG123", new InventoryRecord ("WDG123", "Item 11", "T349", "Row 1, slot 2", "Each", 25, 15, 8, "", 0));
		
		// insert bin records from files
		binRecords.insert("T345", new BinRecord ("T345", "Large bin", "Row 2, slot 1", 50, 10, 10));
		binRecords.insert("T5789", new BinRecord ("T5789", "Small bin", "Row 1, slot 1", 25, 5, 5));
		binRecords.insert("T9876", new BinRecord ("T9876", "Large bin", "Row 3, slot 2", 50, 10, 10));
		binRecords.insert("T098", new BinRecord ("T098", "Medium bin", "Row 3, slot 1", 30, 7, 10));
		binRecords.insert("T349", new BinRecord ("T349", "Small bin", "Row 1, slot 2", 25, 5, 5));
		binRecords.insert("T5789", new BinRecord ("T5789", "Large bin", "Row 4, slot 5", 50, 10, 10));
		binRecords.insert("T9875", new BinRecord ("T9875", "Large bin", "Row 2, slot 2", 50, 10, 10));
	}
	
	// insert functions: the user can insert BinRecords or InventoryRecords
	
	// inserting InventoryRecords
	public void insert(String sku, InventoryRecord invRec)
	{
		invRecords.insert(sku, invRec);
	}
	public void insert(InventoryRecord invRec)
	{
		invRecords.insert(invRec.getSku(), invRec);
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

	//remove Records
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

	//find record
	public InventoryRecord findInvRecord(String sku)
	{
		return invRecords.find(sku);
	}
	public BinRecord findBinRecord(String binNum)
	{
		return binRecords.find(binNum);
	}

	//Find number of inventories
	public int numInvRecords() // return the number of inventories in the database
	{
		return invRecords.size();
	}
	public int numBins() { //return number of bins in the database
		return binRecords.size();
	}

	//return total inventory value
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
		for(int i = 0; i < binRecords.size(); i++)
		{
			if(valToFind.sameAs(binRecords.getByIndex(i).value()))
			{
				keysMatchingValue.insert(binRecords.getByIndex(i).key());
			}
		}
		return keysMatchingValue;
	}
	
	public void HeapSort()
	{
	// create array of inventory records (same contents as linked list invRecords)
	InventoryRecord [] arr = new InventoryRecord [invRecords.size()];

	for(int i = 0; i < invRecords.size(); i++)
	{
	arr[i] = invRecords.getByIndex(i).value();
	}

	// perform heapsort
	// use algorithm as seen in class

	MaxHeap <InventoryRecord> hp = new MaxHeap<InventoryRecord> (arr, arr.length, arr.length);

	for(int j = 0; j < arr.length; j++)
	{
	hp.removemax();
	}

	// clear contents of invRecords
	invRecords.clear();
	// insert with new order
	this.insert(arr);
	}

	public void QuickSort()
	{
	// create array of inventory records (same contents as linked list invRecords)
	InventoryRecord [] arr = new InventoryRecord [invRecords.size()];

	for(int i = 0; i < invRecords.size(); i++)
	{
		arr[i] = invRecords.getByIndex(i).value();
	}

	qsorthelp(arr, 0, arr.length - 1);


	// clear contents of invRecords
	invRecords.clear();
	// insert with new order
	this.insert(arr);
	}

	public void qsorthelp(InventoryRecord [] arr, int i, int j)
	{
	int pivot = findpivot(arr, i, j);

	// swap pivot and last element
	InventoryRecord temp = arr[pivot];
	arr[pivot] = arr[j];
	arr[j] = temp;

	// first position in right subarray will be mid
	int mid = partition(arr, i - 1, j, arr[j]);
	// swap pivot and last element
	InventoryRecord temp2 = arr[mid];
	arr[mid] = arr[j];
	arr[j] = temp2;

	if((mid - i) > 1) 
	qsorthelp(arr, i, mid - i);
	if((j - mid) > 1)
	qsorthelp(arr, mid + 1, j);
	}


	static private int findpivot(InventoryRecord [] arr, int i, int j)
	{
		return ((i + j) / 2);
	}

	static private int partition(InventoryRecord [] arr, int left, int right, InventoryRecord pivot)
	{
		do
		{
			while(arr[++left].compareTo(pivot) < 0);

			while((right != 0) && (arr[--right].compareTo(pivot) > 0));

			// swap left and right elements

			InventoryRecord temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		} while (left < right); // stop iterating when the two iterators cross

	return left;
	}

	public  int[] createIndex() {

		int [] listIndex = invRecords.createIndex();

		return listIndex;
	}
	
}