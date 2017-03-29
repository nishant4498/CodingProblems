package LevelSix;
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
 * 
 * The idea is to divide the two arrays into two halfs such that elements in the left half are smaller than the 
 * elemnts in the right half.
 * 
 * 1) Let's look at the division below:
 * 
 *       left_part           |        right_part
 *	A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 *	B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
 *
 * To ensure that left_part is less than right part the following condition has to be satisfied.This
 * is basically our stop condition. 
 * 		a) A[i-1] <= B[j]
 *      b) B[j-1] <= A[i]
 *      
 * 2) - Also we take i and j such that (i + j) = mid point of the array.
 *      Thus we compute (j = mid - i).
 *    - To ensure that j is not negative, we make sure that the first array is smaller in length.
 *      Since , if the first array is larger , i might be greater than mid and thus j will ne negative.
 *
 */
public class FindMedianSortedArrays {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
        int n = B.length;
        
        if(m > n){
           return findMedianSortedArrays(B, A);
        }
        
        if(m == 0){
            if(n % 2 == 0){
                return (B[n/2] + B[n/2 -1])/2.0;
            }else{
                return (double)B[n/2];
            }
        }
        
        int i = 0, j  = 0, iMin = 0, iMax = m, mid = (m + n + 1)/2;
        
        int maxLeft = 0, minRight = 0;
        
        while(iMin <= iMax){
            i = (iMin + iMax)/2;
            j = mid - i;
            if(i < m && B[j - 1] > A[i]){//Since left part is greater, we need to move i further in
            	iMin = i + 1;            //the first array, that will also move j back(j = mid - i).
            }else if(i > 0 && A[i-1] > B[j]){//Left part is greater so we need to move i back.
                iMax = i - 1;
            }else{//Our both conditions staisfied. We have got the dividing point.
                if(i == 0){
                    maxLeft = B[j-1];
                }else if(j == 0){
                    maxLeft = A[i-1];
                }else{
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                break;
            }
        }
        
        if((m + n) % 2 == 1){
            return (double)maxLeft;
        }
        
        if(i == m){
            minRight = B[j];
        }else if(j == n){
            minRight = A[i];
        }else{
            minRight = Math.min(A[i], B[j]); 
        }
        
        return (maxLeft + minRight)/2.0;
	}
	
	public static void main(String[] args) {
		int[] A = {1,6,8,10};
		int[] B = {2,4,7,9,15};
		
		findMedianSortedArrays(A, B);
	}
}
