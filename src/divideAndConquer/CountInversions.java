package divideAndConquer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountInversions {
	
	public static long sortAndCountSplitInversions(int[] arr, int li, int mid, int ri) {
		int len = arr.length;
		long count = 0;
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
				count += (mid+1) - i;
			}
			k++;
		}
		while(i <= mid) {
			merged[k++] = arr[i++];
		}
		while(j <= ri) {
			merged[k++] = arr[j++];
		}
		for(int x = 0; x < len; x++) {
			arr[x] = merged[x];
		}
		return count;
	}
	
	public static long countInversionsHelper(int[] arr, int li, int ri) {
		long count = 0;
		if(li < ri) {
			int mid = (li+ri)/2;
			count+=countInversionsHelper(arr, li, mid);
			count+=countInversionsHelper(arr, mid+1, ri);
			count += sortAndCountSplitInversions(arr, li, mid, ri);
		}
		return count;
	}
	
	public static long countInversions(int[] arr) {
		return countInversionsHelper(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = { 4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54 };
		System.out.println(countInversions(arr));
		String fileName = "/Users/we.gar/Desktop/inversionTest.txt";
		Scanner s;
		int[] array = new int[100000];
		try {
			s = new Scanner(new File(fileName));
			for (int i = 0; i < array.length; i++)
			    array[i] = s.nextInt();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(countInversions(array));
	}
	
}
