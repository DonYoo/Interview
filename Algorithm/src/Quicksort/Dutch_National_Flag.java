package Quicksort;

/**
 * 
 * @author DonYoo
 *


			best		Average		Worst	Space
Dutchflag	O(n)		O(n)		O(n)	O(logn)


extend version of quicksort.

3 ways partitioning.

(1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
(2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
(3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
(4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
(5) If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.

https://coderbyte.com/algorithm/dutch-national-flag-sorting-problem
https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
https://www.geeksforgeeks.org/amazon-interview-experience-sde-2/


 */
public class Dutch_National_Flag {

	public static void swap(int arr[], int first, int second){
		int temp = arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}
	
	// do it in single pass. Big O(n)
	public static void threeWaysSort(int[]arr, int low, int high){
		int mid = low;
		
		while(mid <= high){
			if(arr[mid] == 2){
				swap(arr, mid, high);
				high--;
			}
			else if(arr[mid] == 1){
				mid++;
			}
			else if(arr[mid] == 0 ){
				swap(arr, low, mid);
				low++;
				mid++;
			}
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {2,0,0,1,2,1};
		for(int i =0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		
		threeWaysSort(arr, 0, arr.length-1);
		
		System.out.println();
		for(int i =0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
