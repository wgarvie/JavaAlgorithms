package sorts;

import java.util.Arrays;

public class MergeSort {

	public static int[] merge(int[] A, int[] B) {
		int i = 0;
		int j = 0;
		int[] merged = new int[A.length+B.length];
		while(i < A.length && j < B.length) {
			if(A[i] <= B[j]) {
				merged[i+j] = A[i];
				i++;
			} else{
				merged[i+j] = B[j];
				j++;
			}
		}
		for(; i < A.length; i++) {
			merged[i+j] = A[i];
		}
		for(; j < B.length; j++) {
			merged[i+j] = B[j];
		}
		return merged;
	}
	
	public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		if(len > 1) {
			int[] fH = Arrays.copyOfRange(arr, 0, len/2);
			int[] sH = Arrays.copyOfRange(arr, (len/2), len);
			fH = mergeSort(fH);
			sH = mergeSort(sH);
			return merge(fH,sH);
		}
		return arr;
	}
		
	public static void main(String[] args) {
		int[] A = {1,4,7,8};
		int[] B = {2,5,9};
		int[] merged = merge(A,B);
		Helpers.printArray(merged);
		int[] arr = {11,93,96,25,75,15,77,45,94,2,41};
		int[] sorted =  mergeSort(arr);
		Helpers.printArray(sorted);
	}
	
}
