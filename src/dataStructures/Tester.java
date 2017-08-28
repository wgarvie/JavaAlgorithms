package dataStructures;

public class Tester {

	public static void main(String[] args) {
		HashMap<String,Integer> mymap = new HashMap<String,Integer>(1000);
		mymap.insert("Hello", 40);
		System.out.println(mymap.search("Hello").getValue());
	}
	
}
