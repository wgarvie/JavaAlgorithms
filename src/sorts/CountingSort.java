package sorts;

import java.util.Arrays;

public class CountingSort {

	public static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];
		for(int i = 0; i < k; i++) {
			C[i] = 0;
		}
		for(int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}		
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
		}	
		for(int i = A.length-1; i >= 0; i--) {
			B[C[A[i]]-1]  = A[i];
			C[A[i]] -= 1;
		}
	}
	
	public static void main (String[] args) {
		int[] A = {2,5,3,0,2,3,0,3};
		int[] B = new int[A.length];
		int k = 5;
		countingSort(A,B,k);
		System.out.println(Arrays.toString(B));
		A = new int[]{2,10,7,1,2,0,2,3,7,2};
		B = new int[A.length];
		k = 10;
		countingSort(A,B,k);
		System.out.println(Arrays.toString(B));
	}
	
}
