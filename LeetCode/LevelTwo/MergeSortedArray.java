package LevelTwo;

/*
 * https://leetcode.com/problems/merge-sorted-array/
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
 * additional elements from nums2
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		/*
		 * Idea is to keep inserting the elements fron both the arrays in the end of nums1 array.
		 */
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}

		while (i >= 0) {
			nums1[k] = nums1[i];
			i--;
			k--;
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}

	}
}
