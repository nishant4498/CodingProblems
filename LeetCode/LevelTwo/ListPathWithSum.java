package LevelTwo;

import java.util.ArrayList;
import java.util.List;

import LevelOne.TreeNode;

/*
 * https://leetcode.com/problems/path-sum-ii/
 */
public class ListPathWithSum {
	public List<List<Integer>> listPathSum(TreeNode root, int sum){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		List<Integer> curr = new ArrayList<>();
		findAllPaths(root, result, curr, sum);
		return result;
	}
	
	public void findAllPaths(TreeNode root, List<List<Integer>> result , List<Integer> curr, int sum){
		if(root == null) return;
		curr.add(root.data);
		if(root.left == null && root.right == null && root.data == sum){
			result.add(curr);
			return;
		}
		
		findAllPaths(root.left, result, new ArrayList<>(curr), sum - root.data);
		findAllPaths(root.right, result, new ArrayList<>(curr), sum - root.data);		
	}
}
