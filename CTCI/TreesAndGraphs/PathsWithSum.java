package TreesAndGraphs;

import java.util.HashMap;

public class PathsWithSum {
	
	public int countPathsWithSum(TreeNode root, int targetSum){
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount){
		if(node == null) return 0;//base case
		
		/*
		 * Count paths with sum at the current node
		 */
		runningSum += node.data;
		int sum = targetSum - runningSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		/*
		 * If runningSum equals targetSum , then one additional path starts at root.Add
		 * in this path.
		 */
		if(runningSum == targetSum){
			totalPaths++;
		}		
		
		incrementHashTable(pathCount , runningSum, 1);
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		/*
		 * Still did not get why to decrement the count in hash table.
		 */
		incrementHashTable(pathCount , runningSum, -1);
		
		return totalPaths;
	}
	
	public void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta){
		int newCount = hashTable.get(key) - delta;
		if(newCount == 0){
			hashTable.remove(key);
		}else{
			hashTable.put(key, newCount);
		}
	}
	
	/*
	 * Recursive approach brute force...Visits each node multiple times.
	 */
	
	public int checkPathsWithSumBruteForce(TreeNode root, int targetSum){
		if (root == null) return 0;
		
		/*Count paths with sum starting from the root */
		
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum , 0);
		
		int pathsFromLeft = countPathsWithSum(root.left, targetSum);
		int pathsFromRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsFromLeft + pathsFromRight;
	}
	
	public int countPathsWithSumFromNode(TreeNode node, int targetSum , int currentSum){
		if(node == null) return 0;
		
		currentSum += node.data;
		
		int totalPaths = 0;
		
		if(currentSum == targetSum){
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
		return totalPaths;
	}
}
