package coen352ass1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseInventoryTest {

	@Test
	void testInsert() {
		WarehouseInventory db1 = new WarehouseInventory();
		db1.insert(new InventoryRecord("ABC123", "Item 50", "T345", "Row 1, slot 7", "Each", 10, 20, 40, "TP001-1", 3));
		// how to test if the record has been inserted??
	}
	
	@Test
	void testRemove()
	{
		WarehouseInventory db2 = new WarehouseInventory();
		
		// ensure we can remove an InventoryRecord
		db2.removeInvRecord("SP875");
		assertEquals(db2.findInvRecord("SP875"), null);
		
		// ensure we can remove a BinRecord
		db2.removeBinRecord("T345");
		assertEquals(db2.findBinRecord("T345"), null);
	}
	
	@Test
	void testRemoveAll()
	{
		WarehouseInventory db3 = new WarehouseInventory();
		
		// clear data
		db3.removeAll();
		
		// ensure there are no records left
		assertEquals(db3.numInvRecords(), 0);
		assertEquals(db3.totalInventoryValue(), 0);
	}
	
	@Test
	void testFind()
	{
		WarehouseInventory db3 = new WarehouseInventory();
		
		// ensure we can find inventory records
		
	}
	

}
