package coen352ass1;

/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Container class for a key-value pair */
class KVpair <Key, E extends Comparable<E>> implements Comparable <KVpair <Key, E>>{
private Key k;
private E e;

/** Constructors */
KVpair() { 
	k = null; 
	e = null;
}

KVpair(Key kval, E eval) { 
	k = kval; 
	e = eval; 
}

/** Data member access functions */
public Key key() { return k; }

public E value() { return e; }

public int compareTo(KVpair <Key, E> other)
{
	return this.value().compareTo(other.value());
}
}