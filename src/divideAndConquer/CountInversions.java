package divideAndConquer;

public class CountInversions {
	
	public static int sortAndCountSplitInversions(int[] arr, int li, int mid, int ri) {
		int len = arr.length;
		int count = 0;
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
		return count;
	}
	
	public static int countInversionsHelper(int[] arr, int li, int ri) {
		int count = 0;
		if(li < ri) {
			int mid = (li+ri)/2;
			countInversionsHelper(arr, li, mid);
			countInversionsHelper(arr, mid+1, ri);
			count += sortAndCountSplitInversions(arr, li, mid, ri);
		}
		return count;
	}
	
	public static int countInversions(int[] arr) {
		return countInversionsHelper(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,6,1,2,5};
		System.out.println(countInversions(arr));
	}
	
}
