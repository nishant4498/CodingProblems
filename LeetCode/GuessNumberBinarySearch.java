/*
 * https://leetcode.com/articles/guess-number-higher-or-lower/
 * Idea is to use binary search to reduce the search space.
 * Also look at ternary search.
 */
public class GuessNumberBinarySearch {
	
	public static int number = 6;
	public static void main(String[] args) {		
		System.out.println(guessNum(10));
	}
	
	/*
	 * This is the iterative approach to Binary Search.
	 */
	public static int guessNum(int n){
		int low = 1;
		int high = n;
		
		while(low <= high){
			int mid = low + (high-low)/2; // To prevent overflow. 
			
			if(guess(mid) == 0) 
				return mid;
			else if(guess(mid) == 1)
				low = mid + 1;
			else
				high = mid - 1;			
		}
		return -1;
	}
	
	public static int guess(int num) {
		if (num == number)
			return 0;
		else if (number > num)
			return 1;
		else
			return -1;

	}

}
