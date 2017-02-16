package LevelOne;
import java.util.Arrays;

/*
 * http://www.programcreek.com/2012/11/quicksort-array-in-java/
 * http://www.java2novice.com/java-sorting-algorithms/quick-sort/
 * https://www.youtube.com/watch?v=aQiWF4E8flQ
 */
public class QuickSortDemo {
	public static void main(String[] args){
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
 
		quickSort(x, low, high);
		System.out.println(Arrays.toString(x));
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(arr == null || arr.length ==0 ){
			return;
		}
		
		if(low >= high) return;
		int mid = low + (high - low)/2;
		
		int pivot = arr[mid];
		
		// make left < pivot and right > pivot
		int i = low , j = high;
		/*
		 * We choose a pivot and keep swapping the numbers on the left and right until
		 * both the pointers meet.
		 * Then we call quicksort for both the partitions separately.
		 */
		while(i <= j){
			 /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
			while(arr[i] < pivot){
				i++;
			}
			
			while(arr[j] > pivot){
				j--;
			}
			
			if(i <= j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}			
		}
		
		if(low < j){
			quickSort(arr, low, j); // Important point to note is The new range is low -> j.
		}
		if(high > i){
			quickSort(arr, i, high);
		}
	}
}
