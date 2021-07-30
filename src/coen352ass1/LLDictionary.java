package coen352ass1;


// problem 1: implementing a linked-list based implementation
public class LLDictionary<Key, E> implements ADTDictionary<Key, E> {

	//TODO: implement new methods from the ADT

	// store a linked list of key-value pairs
	private LList<KVpair <Key, E>> pairs;
	
	LLDictionary()
	{
		pairs = new LList<KVpair <Key, E>> ();
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
		pairs.moveToStart(); // start at beginning of list
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
		//Removes the last KV pair in the LList
		if ( size() != 0 ) {
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

}
