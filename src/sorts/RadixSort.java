package sorts;

import java.util.Arrays;

public class RadixSort {

	private static int[] countingSort(int[] A, int k, int digit) {
		int[] B = new int[A.length];
		int[] C = new int[k+1];
		for(int i = 0; i < k; i++) {
			C[i] = 0;
		}
		for(int i = 0; i < A.length; i++) {
			C[getDigit(A[i],digit)] = C[getDigit(A[i],digit)] + 1;
		}		
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
		}	
		for(int i = A.length-1; i >= 0; i--) {
			B[C[getDigit(A[i],digit)]-1]  = A[i];
			C[getDigit(A[i],digit)] -= 1;
		}
		return B;
	}
	
	public static int[] radixSort(int[] A, int d) {
		for(int i = 1; i <= d; i++) {
			A = countingSort(A, 9, i);
		}
		return A;
	}
	
	private static int getDigit(int num, int digit) {
		return (int) ((num/Math.pow(10, digit-1)) % 10);
	}
	
	public static void main(String[] args) {
		System.out.println(getDigit(4967,1));
		int[] A = {329,457,657,839,436,720,355};
		A = radixSort(A, 3);
		System.out.println(Arrays.toString(A));
	}
}
