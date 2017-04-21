package divideAndConquer;

public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSortHelper(arr, 0, arr.length-1);
	}
	
	public static void quickSortHelper(int[] arr, int left, int right) {
		if(right-left > 0) {
			int pivot = partition(arr, left, right);
			quickSortHelper(arr, left, pivot-1);
			quickSortHelper(arr, pivot+1, right);
		}
	}
	
	public static int selectPivot(int[] arr, int left, int right) {
		return left;
	}
	
	//need to implement better select pivot
	//need to implement three-way partitioning to handle case with lots of the same number
	//need to use insertion sort for small arrays
	public static int partition(int[] arr, int left, int right) {
		int pivot = left;
		int i = left+1;
		boolean largerElement = false;
		for(int j = left+1; j <= right; j++) {
			if(arr[j] > arr[pivot]) {
				largerElement = true;
			}
			else if(arr[j] < arr[pivot]) {
				if(largerElement) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				i++;
			}
		}
		int temp = arr[i-1];
		arr[i-1] = arr[pivot];
		arr[pivot] = temp;
		return i - 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,1,2,3,5};
		partition(arr, 0, arr.length-1);
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		int[] arr2 = {4,1,2,3,5};
		quickSort(arr2);
		for(int a: arr2) {
			System.out.print(a + " ");
		}
		System.out.println();
		int[] arr3 = {87,48,97,50,63,94,67,23,82,86};
		quickSort(arr3);
		for(int a: arr3) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
}
