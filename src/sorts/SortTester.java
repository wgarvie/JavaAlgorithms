package sorts;

public class SortTester {

	public static void main(String[] args) {
		int[] arr = {6,4,8,2};
		printArray(arr);
		InsertionSort.insertionSort(arr);
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
}
