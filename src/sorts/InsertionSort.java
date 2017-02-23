package sorts;

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
	
	public static void main(String[] args) {
		int[] arr = {6,4,8,2};
		Helpers.printArray(arr);
		InsertionSort.insertionSort(arr);
		Helpers.printArray(arr);
	}
	
}
