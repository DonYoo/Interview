package HashTables;

import java.util.ArrayList;


/**
 * 
 * 
 * @author DonYoo
 *
 * @param <K>
 * @param <V>
 * 

			Access	search	insert	delete	space
HashTable	O(1)	O(1)	O(1)	O(1)	O(n)


 */
class HashNode<K, V>{
	HashNode<K, V> next;
	K key;
	V value;
	
	public HashNode(K key, V value){
		next = null;
		this.key = key;
		this.value = value;
	}
}


public class myHashTable<K, V> {

	private int capacity_size = 11;
	public int current_size = 0;
	
	ArrayList<HashNode<K, V>> bucket;

	public myHashTable(){
		bucket = new ArrayList<>();
		// initialize
		for(int i=0; i<capacity_size; i++){
			bucket.add(null);
		}
	}
	
	// get the hash code of key and divided by size. use that value to search index from arrayList
	public int getBucketIndex(K key){
		int hashCode = key.hashCode() / capacity_size;
		return hashCode;
	}
		
	private void doubleCapacity() {
		capacity_size *= 2;
		// copy original to temp.
		ArrayList<HashNode<K, V>> tempBucket = bucket;
		bucket = new ArrayList<>();
		
		// initialize new bucket with new size
		for(int i=0; i<capacity_size; i++){
			bucket.add(null);
		}
		// copy over to new bucket with new hashcode.
		for(HashNode<K, V>eachNode : tempBucket){
			while(eachNode != null){
				put(eachNode.key, eachNode.value);
				eachNode = eachNode.next;
			}
		}
	}
	
	public void put(K key, V value){
		//check if current value is less than .7 of capacity size
		if(current_size >= capacity_size *.7){
			doubleCapacity();
		}
		
		int index = getBucketIndex(key);
		// get the chain node.
		HashNode<K, V> chain = bucket.get(index);
		HashNode<K, V> tail = chain;
		// go through the chain because there might be the duplicate hashcode.
		while (tail != null){
			// if the keys are the same, don't do anything.
			if(tail.key.equals(key)){
				return;
			}
			tail = tail.next;
		}
		// make a newHash as new input
		HashNode<K, V> newchain = new HashNode<>(key, value);
		// add input in front of the chain.
		newchain.next = chain;
		// set the bucket with new hashcode chain ***********************************************
		bucket.set(index, newchain);
		// increment current size.
		current_size++;
	}


	public V get(K key){
		int index = getBucketIndex(key);
		HashNode<K, V> chain = bucket.get(index);
		while (chain != null){
			if(chain.key.equals(key)){
				return chain.value;
			}
			chain = chain.next;
		}
		return null;
	}
	
	public V remove(K key){
		int index = getBucketIndex(key);
		HashNode<K,V> chain = bucket.get(index);
		HashNode<K,V> tail = chain;
		
		// if the head is the one to be removed
		if(chain.key.equals(key)){
			bucket.set(index, chain.next);
			return chain.value;
		}
		
		// prev for previous node to jump to current next node.
		HashNode<K, V> prev = tail;
		tail = tail.next;
		
		// iterate through
		while(tail != null){
			if(tail.key.equals(key)){
				// skip and connect the next node. 
				prev.next = tail.next;
				return tail.value;
			}
			prev = tail;
			tail = tail.next;
		}
		return null;		
	}
	
	
	public static void main(String[] args) {
		myHashTable<Integer, String> sampleTable = new myHashTable<>();
		sampleTable.put(1, "Don");
		sampleTable.put(2, "Ron");
		sampleTable.put(3, "Thom");
		sampleTable.put(11, "Alex");
		System.out.println(sampleTable.get(2));
		sampleTable.remove(2);
		
		System.out.println(sampleTable.get(2));
		
	}

}
