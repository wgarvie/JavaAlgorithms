package sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] arr) {
		for(int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j-1;
			while(i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}
	
	public static void insertionSortList(ArrayList<Double> lst) {
		for(int j = 1; j < lst.size(); j++) {
			Double key = lst.get(j);
			int i = j-1;
			while(i >= 0 && lst.get(i) > key) {
				lst.set(i+1, lst.get(i));
				i--;
			}
			lst.set(i+1, key);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,4,8,2};
		System.out.println(Arrays.toString(arr));
		InsertionSort.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		ArrayList<Double> lst = new ArrayList<Double>();
		lst.add(6.0);
		lst.add(4.0);
		lst.add(8.1);
		lst.add(2.3);
		for(Double i: lst) {
			System.out.print(i + " ");
		}
		System.out.println();
		insertionSortList(lst);
		for(Double i: lst) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
