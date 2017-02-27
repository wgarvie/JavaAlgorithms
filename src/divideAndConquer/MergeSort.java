package divideAndConquer;

import java.util.Arrays;

//completed MergeSort by splitting arrays using indices

public class MergeSort {

	/*public static int[] merge(int[] A, int[] B) {
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
	}*/
	
	public static void merge(int[] arr, int li, int mid, int ri) {
		int len = arr.length;
		int[] merged = new int[len];
		for(int x = 0; x < len; x++) {
			merged[x] = arr[x];
		}
		int i = li;
		int j = mid+1;
		int k = li;
		while(i <= mid && j <= ri) {
			if(arr[i] <= arr[j]) {
				merged[k] = arr[i];
				i++;
			} else{
				merged[k] = arr[j];
				j++;
			}
			k++;
		}
		for(; i <= mid; i++) {
			merged[k] = arr[i];
			k++;
		}
		for(; j < ri; j++) {
			merged[k] = arr[j];
			k++;
		}
		for(int x = 0; x < len; x++) {
			arr[x] = merged[x];
		}
	}
	
	public static void mergeSortHelper(int[] arr, int li, int ri) {
		if(li < ri) {
			int mid = (li + ri)/2;
			mergeSortHelper(arr, li, mid);
			mergeSortHelper(arr, mid+1, ri);
			merge(arr, li, mid, ri);
		}
	}
	
	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr, 0, arr.length-1);
	}
	
	/*public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		if(len > 1) {
			int[] fH = Arrays.copyOfRange(arr, 0, len/2);
			int[] sH = Arrays.copyOfRange(arr, (len/2), len);
			fH = mergeSort(fH);
			sH = mergeSort(sH);
			return merge(fH,sH);
		}
		return arr;
	}*/
		
	public static void main(String[] args) {
		int[] A = {1,3,2};
		merge(A, 0, 1, 2);
		System.out.println(Arrays.toString(A));
		int[] arr = {11,93,96,25,75,15,77,45,94,2,41};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = {3,2,1};
		System.out.println(Arrays.toString(arr2));
		mergeSort(arr2);
		System.out.println(Arrays.toString(arr2));

	}
	
}
