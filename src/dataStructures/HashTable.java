package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	
	private List<List<Integer>> data = new ArrayList<List<Integer>>(1000);
	
	private int hash(Integer x) {
		return x.hashCode();
	}
	
	public void insert(Integer x) {
		data.get(hash(x)).add(x);
	}
	
	public boolean search(Integer x) {
		List<Integer> res = data.get(hash(x));
		for(Integer i : res) {
			if(i == x) {
				return true;
			}
		}
		return false;
	}
	
}
