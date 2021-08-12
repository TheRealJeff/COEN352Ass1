package coen352ass1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseInventoryTest {

	//Note: All tests should succeed

	@Test
	void testInsert() {
		WarehouseInventory db1 = new WarehouseInventory();

		db1.insert(new InventoryRecord("ABC123", "Item 50", "T345", "Row 1, slot 7", "Each", 10, 20, 40, "TP001-1", 3));
		assertEquals(12, db1.numInvRecords(), "Single inventory record insert did not work, size not as expected");

		db1.insert(new BinRecord("T8734", "Large bin", "Row 4, slot 2", 50, 10, 10));
		assertEquals(7, db1.numBins(), "Single bins insert did not work, size not as expected");
	}

	@Test
	void testInsertSet() {
		WarehouseInventory db2 = new WarehouseInventory();

		InventoryRecord [] invRecordSet = new InventoryRecord[3];
		invRecordSet [0] = new InventoryRecord("FEG123", "Item 52", "T345", "Row 1, slot 9", "Each", 10, 20, 40, "TP001-1", 3);
		invRecordSet [1] = new InventoryRecord("DEF123", "Item 51", "T345", "Row 1, slot 8", "Each", 40, 20, 34, "TP001-1", 3);
		invRecordSet [2] = new InventoryRecord("ABC376", "Item 53", "T345", "Row 1, slot 3", "Each", 10, 20, 40, "TP001-1", 3);
		db2.insert(invRecordSet);
		assertEquals(14, db2.numInvRecords(), "Set inventory record insert did not work, size not as expected");

		BinRecord [] binRecordSet = new BinRecord[3];
		binRecordSet [0] = new BinRecord("T6754", "Large bin", "Row 2, slot 2", 50, 10, 10);
		binRecordSet [1] = new BinRecord("T3978", "Large bin", "Row 2, slot 2", 50, 10, 10);
		binRecordSet [2] = new BinRecord("T3276", "Large bin", "Row 2, slot 2", 50, 10, 10);
		db2.insert(binRecordSet);
		assertEquals(9, db2.numBins(), "Set bin insert did not work, size not as expected");
	}
	
	@Test
	void testRemove()
	{
		WarehouseInventory db3= new WarehouseInventory();
		
		db3.removeInvRecord("SP875");
		assertEquals(db3.findInvRecord("SP875"), null);
		
		db3.removeBinRecord("T345");
		assertEquals(db3.findBinRecord("T345"), null);
	}
	
	@Test
	void testRemoveAll()
	{
		WarehouseInventory db4 = new WarehouseInventory();
		
		db4.removeAll();
		
		assertEquals(db4.numInvRecords(), 0);
		assertEquals(db4.totalInventoryValue(), 0);
	}
	
	@Test
	void testFind()
	{
		WarehouseInventory db5 = new WarehouseInventory();

		InventoryRecord invRecordCheck = new InventoryRecord("SP7875", "Item 1", "T345", "Row 2, slot 1", "Each", 20, 10, 30, "TP001-1", 3);
		assertEquals(true, invRecordCheck.sameAs(db5.findInvRecord("SP7875")));

		BinRecord binRecordCheck = new BinRecord("T345", "Large bin", "Row 2, slot 1", 50, 10, 10);
		assertEquals(true, binRecordCheck.sameAs(db5.findBinRecord("T345")));
	}

	@Test
	void testFindValue() {
		WarehouseInventory db6 = new WarehouseInventory();

		InventoryRecord inventoryRecord = new InventoryRecord("SP7875", "Item 1", "T345", "Row 2, slot 1", "Each", 20, 10, 30, "TP001-1", 3);
		assertEquals(1, db6.getByValue(inventoryRecord).length(), "Number of inventory record values found does not match");

		BinRecord binRecord = new BinRecord("T345", "Large bin", "Row 2, slot 1", 50, 10, 10);
		assertEquals(1, db6.getByValue(binRecord).length(), "Number of bin record values found does not match");
	}

	@Test
	void testFindReordered() {
		WarehouseInventory db7 = new WarehouseInventory();

		assertEquals(2, db7.getReorderedRecords().length(), "Size of list with reorder items does not match");
	}

	@Test
	void testNumberInventories() {
		WarehouseInventory db8 = new WarehouseInventory();

		assertEquals(11, db8.numInvRecords(), "Size does not match");

		assertEquals(6, db8.numBins(), "Size does not match");
	}

	@Test
	void testTotalValue() {
		WarehouseInventory db9 = new WarehouseInventory();

		assertEquals(4649, db9.totalInventoryValue(), "Total value is not correct");
	}

	@Test
	void testCreateIndex() {
		WarehouseInventory db10 = new WarehouseInventory();

		assertArrayEquals( new int[]{1, 9, 0, 3, 5, 4, 8, 10, 6, 7, 2}, db10.createIndex(), "Arrays don't match" );
	}

}
