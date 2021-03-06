package coen352ass1;

import java.util.Arrays;

public class DLDictionary<Key, E extends Comparable<E>> implements ADTDictionary<Key, E> {

	DList<KVpair <Key, E>> pairs; // DList holds pairs
	DLDictionary()
	{
		pairs = new DList<KVpair <Key, E>> ();
	}
	
	/** Reinitialize dictionary */
	public void clear()
	{
		pairs.clear();
	}

	/** Insert a record
	  @param k The key for the record being inserted.
	  @param e The record being inserted. */
	public void insert(Key k, E e)
	{
		// ensure the key is unique
		KVpair<Key, E> toAdd = new KVpair <Key, E>(k, e);
		if ( find( k ) == null ) {
			pairs.append(toAdd);
		}
	}

	/** Remove and return a record.
	  @param k The key of the record to be removed.
	  @return A matching record. If multiple records match
	  "k", remove an arbitrary one. Return null if no record
	  with key "k" exists. */
	public E remove(Key k)
	{
		pairs.moveToStart();
		for(int i = 0; i < pairs.length(); i++)
		{
			if(pairs.getValue().key() == k)
			{
				// if the statement is true, cursor is at element where k was found
				E toRet = pairs.getValue().value(); // return value where key is found
				pairs.remove(); // remove pair at curr
				return toRet;
			}
			pairs.next();
		}
		return null; // key not found
	}

	/** Remove and return an arbitrary record from dictionary.
	  @return the record removed, or null if none exists. */
	public E removeAny()
	{
		//Removes the last KV pair in the DList
		if ( pairs.getValue().key() != null ) {
			pairs.moveToEnd();
			pairs.prev();
			KVpair<Key, E> e = pairs.remove();
			return e.value();
		}
		else
			return null;
	}

	/** @return A record matching "k" (null if none exists).
	  If multiple records match, return an arbitrary one.
	  @param k The key of the record to find */
	public E find(Key k)
	{
		// similar algorithm to remove method
		pairs.moveToStart(); // start at beginning of list
		for(int i = 0; i < pairs.length(); i++)
		{
			if(pairs.getValue().key() == k)
			{
				// if the statement is true, cursor is at element where k was found
				return pairs.getValue().value(); // return value where key is found
			}
			pairs.next(); // move to next element
		}
		return null; // key not found
	}

	/** @return The number of records in the dictionary. */
	public int size()
	{
		return pairs.length();
	}

	/** @return The Value of a key-value pair at a certain index
	 * @param index The index of the value needed */
	public KVpair <Key, E> getByIndex(int index) // needed in order to implement some WarehouseInventory functions
	{
		pairs.moveToPos(index);
		KVpair <Key, E> temp = pairs.getValue();
		pairs.moveToStart(); // move the curr back to start for next use
		return temp;
	}

	/**
	 * @return Int array with reverse order of the key values
	 * createIndex uses a modified Selection sort to return the reverse order of Inventory Values
	 * In terms of comparisons and swaps, the Asymptotic Analysis stays the same
	 * Comparisons: big theta ( n^2 )
	 * Swaps: big theta ( n )
	 * createIndex adds a factor of big theta ( n ) for creating an array that holds the indices
	 * It also adds some factors of constant time to account for the processing of the Dictionary items
	 */
	public int[] createIndex() {
		int [] listIndex = new int[pairs.length()];
		DList<KVpair<Key, E>> tempDict = pairs;

		for ( int i = 0; i < pairs.length(); i++ ) {
			listIndex[ i ] = i;
		}

		for ( int i = 0; i < listIndex.length - 1; i++ ) {
			int swapIndex = i;
			KVpair largeElement;

			//largeElement will be the variable to contain the largest Inventory value
			tempDict.moveToPos( i );
			largeElement = tempDict.getValue();
			tempDict.moveToEnd();
			tempDict.prev();

			for ( int j = listIndex.length - 1; j > i ; j-- ) {
				if ( tempDict.getValue().compareTo( largeElement ) > 0 ) {
					largeElement = tempDict.getValue();
					swapIndex = j;
				}
				tempDict.prev();
			}
			if ( swapIndex != i ) {
				//Swap procedure for the Dictionary
				tempDict.moveToPos(swapIndex);
				KVpair swapElement = tempDict.remove();
				tempDict.moveToPos(i);
				tempDict.insert(swapElement);
				tempDict.next();
				swapElement = tempDict.remove();
				tempDict.moveToPos(swapIndex);
				tempDict.insert(swapElement);
			}
			//Swap indices in the listIndex return array
			DSutil.swap(listIndex, i, swapIndex);
		}

		return listIndex;
	}
}
