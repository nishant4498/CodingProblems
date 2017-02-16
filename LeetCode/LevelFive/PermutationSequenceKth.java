package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/2
 * 
 * The whole idea here for this problem is to keep narrowing down the scope of k.
 * e.g given n = 4 and k =14 , we have
 * 1 + perm{2,3,4}
 * 2 + perm{1,3,4}
 * 3 + perm {1,2,4}
 * 4+ perm{1,2,3}
 * 
 * As we can see each of the four steps has 6 permutation - (n-1)! = 3! = 6. Thus a total of 24 permutations
 * 
 * Now we need to  find 13th(k-1 as 0 indexed) permutation, so it must be in the 3rd list i.e. 3 + perm{1,2,4}
 * 
 * 1) Way to find the index = k/(n-1)! - this will give index = 2 i.e the number 3. basically k/(n-i)! for i = 1..n
 * 
 * 2) Similarly we update k = k - index * (n-1)! [(n-i)! in general]
 * 
 * 3) We add the number at index to result and then remove it from the number list.
 * 
 * Complexity = O(n) for iterating through 1..n
 * O(n) - for deleteing elements in the list
 * 
 * so total O(n^2)
 */
public class PermutationSequenceKth {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		List<Integer> nums = new ArrayList<>();
		int[] facts = new int[n + 1];

		facts[0] = 1;

		int fact = 1;

		for (int i = 1; i <= n; i++) {
			nums.add(i);
			fact = fact * i;
			facts[i] = fact;
		}
		k--; // To match 0 based indexing.

		for (int i = 1; i <= n; i++) {
			int index = k / facts[n - i];
			sb.append(nums.get(index));
			k = k - index * facts[n - i];
			nums.remove(index);
		}

		return sb.toString();
	}
}
