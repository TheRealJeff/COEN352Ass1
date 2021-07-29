package coen352ass1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DictionaryJUnitTest {
	
	
	private static ADTDictionary<Integer, String> dict;
	  
	@BeforeAll
	public static void setUp() {
		//dict = new ALDictionary<Integer, String>(10);
		//dict = new LLDictionary<Integer, String>();
		dict = new DLDictionary<Integer, String>();
		
	}

	@Test
	//Should pass
	void testClear() {
		dict.clear();
		assertEquals(0, dict.size(), "clear failed, size is non zero");
	}

	@Test
	//Should pass
	void testInsert() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertEquals(4, dict.size(), "insert failed, size is not as expected");
	}

	@Test
	//Should fail
	void testRemove() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		
		dict.remove(3);
		assertEquals("grey", dict.find(3), "remove failed");
		
	}

	@Test
	//Should fail
	void testRemoveAny() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertNotEquals("grey", dict.removeAny(), "removeAny failed");

	}

	@Test
	//Should pass
	void testFind() {
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		
		assertEquals("grey", dict.find(3), "find failed"); 
	}

	@Test
	//Should pass
	void testSize() {
		dict.clear();
		dict.insert(0, "red");
	
		
		assertEquals(1, dict.size(), "size failed, size is not as expected");
	}

}
