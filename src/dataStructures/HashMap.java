package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K,V> {
	
	private List<List<Node<K,V>>> data = new ArrayList<List<Node<K,V>>>(1000);

	HashMap(int size) {
		for(int i = 0; i < size; i++) {
			data.add(new ArrayList<Node<K,V>>());
		}
	}
	
	public class Node<K,V> {
		final K key;
		V value;
		
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V newValue) {
			value = newValue;
		}
	}
		
	private int hash(K x) {
		return x.hashCode() % 1000;
	}
	
	public void insert(K key, V value) {
		Node<K,V> node = new Node<K,V>(key,value);
		Node<K,V> s = search(node.getKey());
		if(s == null){
			data.get(hash(node.getKey())).add(node);
		} else {
			s.setValue(node.value);
		}
	}
	
	public Node<K,V> search(K x) {
		List<Node<K,V>> res = data.get(hash(x));
		for(Node<K,V> i : res) {
			if(i.getKey() == x) {
				return i;
			}
		}
		return null;
	}
	
}
