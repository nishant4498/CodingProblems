package DesignProblems;

import java.util.ArrayList;

public class HashTable<K,V> {	
	private static class LinkedListNode<K,V>{
		public LinkedListNode<K,V> next;
		public LinkedListNode<K,V> prev;
		
		public K key;
		public V value;
		
		public LinkedListNode(K k, V val){
			this.key = k;
			this.value = val;
		}
		
	}
	
	public ArrayList<LinkedListNode<K,V>> arr;
	
	public HashTable(int capacity){
		arr = new ArrayList<>();
		arr.ensureCapacity(capacity);
	}
	
	public void put(K key, V value){
		LinkedListNode<K, V> node = getNodeForKey(key);
		/**
		 * If the node for that key is already present, we just replace the value for that node.
		 */
		if(node != null){
			node.value = value;
			return;
		}
		
		node = new LinkedListNode<K,V>(key, value);
		
		int index = getIndexForKey(key);
		if(arr.get(index) != null){
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.add(index, node);		
	}
	/**
	 * Important thing to note here that it returns the value...Not the node itself.
	 */
	public V get(K key){
		LinkedListNode<K, V> node =  getNodeForKey(key);
		if(node != null){
			return node.value;
		}
		return null;
	}
	
	public void remove(K key){
		LinkedListNode<K, V> node = getNodeForKey(key);
		if(node.prev != null){
			node.prev.next = node.next;
		}else{
			int hashKey = getIndexForKey(key);
			arr.add(hashKey , node.next);
			return;
		}
		if(node.next != null){			
			node.next.prev = node.prev;			
		}
	}
	
	public LinkedListNode<K, V> getNodeForKey(K key){
		int index = getIndexForKey(key);
		LinkedListNode<K, V> curr = arr.get(index);
		while(curr != null){
			if(curr.key == key){
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}
	
	public int getIndexForKey(K key){
		return (key.hashCode() % arr.size());
	}

}
