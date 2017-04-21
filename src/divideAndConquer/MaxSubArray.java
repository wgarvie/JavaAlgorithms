package divideAndConquer;

import java.util.Arrays;

public class MaxSubArray {

	public static int[] findMaxCrossingSubArray(int[] A, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid-1;
		for(int x = mid-1; x >= low; x--) {
			sum += A[x];
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = x;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = mid;
		for(int x = mid; x <= high; x++) {
			sum += A[x];
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = x;
			}
		}
		return new int[]{maxLeft, maxRight, leftSum+rightSum};
	}
	
	public static int[] findMaxSubArray(int[] A, int low, int high) {
		if(high == low) {
			return new int[]{low, high, A[low]};
		} else {
			int mid = (low+high+1)/2;
			int[] leftRes = findMaxSubArray(A,low,mid-1);
			int[] rightRes = findMaxSubArray(A,mid,high);
			int[] crossRes = findMaxCrossingSubArray(A, low, mid, high);
			if(leftRes[2] >= rightRes[2] && leftRes[2] >= crossRes[2]) {
				return leftRes;
			}
			else if(rightRes[2] >= leftRes[2] && rightRes[2] >= crossRes[2]) {
				return rightRes;
			} else {
				return crossRes;
			}
		}
	}
	
	public static void main (String[] args) {
		int[] arr = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] arr2 = {2, -1, 2, 3, 4, -5};
		int[] solutions = findMaxCrossingSubArray(arr, 0,arr.length/2,arr.length-1);
		System.out.println(Arrays.toString(solutions));
		System.out.println(Arrays.toString(findMaxSubArray(arr, 0, arr.length-1)));
		System.out.println();
		System.out.println(Arrays.toString(findMaxCrossingSubArray(arr2, 0, arr2.length/2, arr2.length-1)));
		System.out.println(Arrays.toString(findMaxSubArray(arr2, 0, arr2.length-1)));
		System.out.println();
		int[] arr3 = {2,2,-1,-3,-4,5,-6};
		System.out.println(Arrays.toString(findMaxCrossingSubArray(arr3, 0, arr3.length/2, arr3.length-1)));
		System.out.println(Arrays.toString(findMaxSubArray(arr3, 0, arr3.length-1)));
	}
	
}
