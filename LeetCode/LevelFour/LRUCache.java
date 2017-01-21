package LevelFour;

import java.util.HashMap;
import java.util.Map;

/**
 * CTCI - 16.25
 * https://leetcode.com/problems/lru-cache/
 * The idea here is to keep a Map with Integer as key and a Linked List Node(containing key,value) as value.
 * LL reprsents the order in which the nodes have been accessed.
 * 		Head - Most recently accessed.
 * 		Tail - Least recently accessed.
 * 
 * get(key) - If the cache contains the key, we fetch it and return the value.
 *            We remove the node from its current position and set it as head(to mark 
 *            it as recently accessed).
 * 
 * put(key,value)
 * 			- If the cache contains the key, just update the value,remove the node from that position
 * 			  and update it as head
 *          - If not, create a new node,put it in the cache and set it as head.
 *          - Before inserting the new node, if cache reached its capacity, remove the last node 
 *            from LL and cache both. 
 */
public class LRUCache {
	public Map<Integer, Node> cache = new HashMap<>();
	public Node head = null;
	public Node tail = null;
	public int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			Node n = cache.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node n = cache.get(key);
			n.value = value;
			remove(n);
			setHead(n);
		} else {
			Node newNode = new Node(key, value);
			if (cache.size() >= capacity) {
				/**
				 * the key must be first removed from cache before deleting the tail.
				 */
				cache.remove(tail.key);
				remove(tail);
			}
			cache.put(key, newNode);
			setHead(newNode);
		}
	}

	public void remove(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	public void setHead(Node node) {
		node.next = head;
		if (head != null) {
			head.prev = node;
		}

		head = node;
		/**
		 * Very important to set this as null, as we might set a middle node as head.
		 */
		node.prev = null;

		if (tail == null) {
			tail = head;
		}
	}

	private static class Node {
		public int key;
		public int value;
		public Node prev;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
