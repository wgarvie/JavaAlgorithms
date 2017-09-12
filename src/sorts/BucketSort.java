package sorts;

import java.util.ArrayList;

public class BucketSort {

	public static double[] bucketSort(double[] A) {
		int n = A.length;
		ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>(n);
		for(int i = 0; i < n-1; i++) {
			B.get((int)Math.floor(n*A[i])).add(A[i]);
		}
		for(int i = 0; i < n-1; i++) {
			InsertionSort.insertionSortList(B.get(i));
		}
		//double[] result = new double[n];
		//for(int i = 0; i < n-1; i++) {
		//	for(int j = 0; j < B.get(i).size(); j++) {
		//		result[i]
		//	}
		//}
	}
	
}
