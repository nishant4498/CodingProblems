package LevelSix;
/**
 * https://leetcode.com/problems/sqrtx/
 * 
 * Basically we do a binary search.
 * We start with left = 1 and right = x
 * 
 * When mid * mid > x , it means we need to reduce the right , thus right = mid -1
 * 
 * Else(mid * mid <= x) We check for (mid + 1) * (mid +1) > x, we return mid , since mid will be the 
 * integer closest to sqrt(x)
 * 
 * else we increment left = mid + 1
 *
 */
public class SqrtOfX {
	public int mySqrt(int x){
		if(x == 0) return 0;
		int left = 1, right = x;
		
		while(true){// We will definitely get a sqrt
			int mid = left + (right - left)/2;
			/**
			 * We don't write mid * mid > x, since this can lead to overflow.
			 */
			if(mid > x/mid){
				right = mid - 1;
			}else{
				if((mid + 1) > x/ (mid + 1)) return mid;
				left = mid + 1;
			}
		}
	}
}
