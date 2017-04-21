package divideAndConquer;

import java.util.Random;

public class MergeSort {
	
	public static void merge(int[] A, int l, int m, int r) {
		int firstHalfLength = m - l;
		int secondHalfLength = r - m + 1;
		int[] firstHalf = new int[firstHalfLength];
		int[] secondHalf = new int[secondHalfLength];
		for(int i = 0; i < firstHalfLength; i++) {
			firstHalf[i] = A[l + i];
		}
		for(int i = 0; i < secondHalfLength; i++) {
			secondHalf[i] = A[m + i];
		}
		int i = 0;
		int j = 0;
		for(int x = l; x <= r; x++) {
			if(j == secondHalfLength || (i < firstHalfLength && firstHalf[i] <= secondHalf[j])){
				A[x] = firstHalf[i];
				i++;
			} else {
				A[x] = secondHalf[j];
				j++;
			}
		}
	}
	
	public static void mergeSortHelper(int[] arr, int l, int r) {
		if(l < r) {
			int mid = (l + r + 1)  / 2;
			mergeSortHelper(arr, l, mid-1);
			mergeSortHelper(arr, mid, r);
			merge(arr,l,mid,r);
		}
	}
	
	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,2,4,6,2};
		mergeSort(arr);
		for(int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		Random rand = new Random();
		int[] arr2 = new int[9];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = rand.nextInt(1000)+1;
		}
		for(int x: arr2) {
			System.out.print(x + " ");
		}
		System.out.println();
		mergeSort(arr2);
		for(int x: arr2) {
			System.out.print(x + " ");
		}
		
	}
	
}
