package sorts;

public class HeapSort {
	
	public static int parent(int i) {
		return (i-1)/2;
	}
	
	public static int left(int i) {
		return (i*2)+1;
	}
	
	public static int right(int i) {
		return (i*2)+2;
	}
	
	public static void maxHeapify(int[] A, int index, int heapSize) {
		int l = left(index);
		int r = right(index);
		int largest;
		if(l < heapSize && A[l] > A[index]) {
			largest = l;
		} else {
			largest = index;
		}
		if(r < heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if(largest != index) {
			int temp = A[index];
			A[index] = A[largest];
			A[largest] = temp;
			maxHeapify(A,largest,heapSize);
		}
	}
	
	public static void buildMaxHeap(int[] A) {
		int heapSize = A.length;
		for(int i = (heapSize-1)/2; i >= 0; i--) {
			maxHeapify(A, i, heapSize);
		}
	}
	
	public static void heapSort(int[] A) {
		buildMaxHeap(A);
		int heapSize = A.length;
		for(int i = A.length - 1; i >= 1; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize--;
			maxHeapify(A,0,heapSize);
		}
	}
	
	public static void main(String[] args) {
		//int[] arr = {16,14,10,8,7,9,3,2,4,1};
		int[] arr = {16,4,10,14,7,9,3,2,8,1};
		maxHeapify(arr,1,10);
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		int[] arr2 = {4,1,3,2,16,9,10,14,8,7};
		buildMaxHeap(arr2);
		for(int a: arr2) {
			System.out.print(a + " ");
		}
		System.out.println();
		int[] arr3 = {4,1,3,2,16,9,10,14,8,7};
		heapSort(arr3);
		for(int a: arr3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
	}
}
