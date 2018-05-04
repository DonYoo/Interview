package Quicksort;

/**
 * 
 * @author DonYoo

			best		Average		Worst	Space
Quicksort	O(nlogn)	O(nlogn)	O(n^2)	O(logn)

https://www.geeksforgeeks.org/quick-sort/

The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, 
put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, 
and put all greater elements (greater than x) after x. All this should be done in linear time.

 *
 *
 */
public class myQuicksort {

	// pass by reference with integer array.
	public static void quickSort(int[] arr, int low, int high){
		
		// baseline, partition (semi-sort)
		if(low < high){
			int midIndex = partition(arr, low, high);
			
			// sort left part
			quickSort(arr, low, midIndex-1);
			// sort right part
			quickSort(arr, midIndex+1, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int temp = 0;
		int indexofSmall = low;
		
		// iterate through and swap if left values are smaller than pivot.
		for(int j=low; j<high; j++){
			if(arr[j] < pivot){
				//swap
				temp = arr[indexofSmall];
				arr[indexofSmall] = arr[j];
				arr[j] = temp;
				indexofSmall++;
			}
		}
		//swap pivot and end of index of small + 1
		temp = arr[indexofSmall];
		arr[indexofSmall] = pivot;
		arr[high] = temp;		
		return indexofSmall;
	}

	public static void main(String[] args) {
		int[] sample = {10,80,30,90,40,50,70};
		for(int i =0; i<sample.length; i++){
			System.out.print(sample[i] + " ");
		}
		
		System.out.println();
		quickSort(sample, 0, sample.length-1);
		
		for(int i =0; i<sample.length; i++){
			System.out.print(sample[i] + " ");
		}
	}
}
