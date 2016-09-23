package LevelOne;
/*
 * https://leetcode.com/articles/first-bad-version/
 */
public class FirstBadVersionBinarySearch {
	public int firstBadVersion(int n){
		int left = 1;
		int right = n;
		
		while(left < right){
			int mid = left + (right - left)/2;
			if(isBadVersion(mid)){
				right = mid;// we can't keep as right = mid -1 , since mid can also be the first bad version.
			}else{
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	public boolean isBadVersion(int version){
		return true;
	}
}
