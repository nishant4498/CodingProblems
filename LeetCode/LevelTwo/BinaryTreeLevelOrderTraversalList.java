package LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import LevelOne.TreeNode;

public class BinaryTreeLevelOrderTraversalList {
	/* https://leetcode.com/problems/binary-tree-level-order-traversal/
	 * 1. If root is null, return empty list.
	 * 2. Add the root and the delimiter to the queue.
	 * 3. Pop the queue and add the value to the current level list.
	 * 4. When we get the delimiter , we add the currLevel to rsult and reset the currLevel to store
	 *    the nodes for the next level.
	 * 5. We always check the queue emepty condition before adding the delimiter.
	 */
	public List<List<Integer>> levelOrderList(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		List<Integer> currLevel = new ArrayList<>();
		myQueue.offer(root);
		TreeNode delimiter = null;
		myQueue.offer(delimiter);
		
		while(!myQueue.isEmpty()){
			TreeNode node = myQueue.poll();
			if(node == null){
				result.add(currLevel);
				currLevel = new ArrayList<>();
				/*
				 * VERY IMP : If we dont add this if condition this will go on in infinite loop.
				 */
				if(!myQueue.isEmpty()){
					myQueue.add(delimiter);
				}
			}else{
				currLevel.add(node.data);
				if(node.left != null){
					myQueue.offer(node.left);
				}
				if(node.right != null){
					myQueue.offer(node.right);
				}				
			}
		}		
		return result;
	}
	
	public List<List<Integer>> levelOrderListWay(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		myQueue.offer(root);
		
		while(!myQueue.isEmpty()){
			int levelCount = myQueue.size();			
			List<Integer> currLevel = new ArrayList<>();
			for(int i =0; i < levelCount ; i++){
				TreeNode node = myQueue.poll();
				if(node.left != null){
					myQueue.offer(node.left);
				}
				if(node.right != null){
					myQueue.offer(node.right);
				}
				currLevel.add(node.data);
			}
			result.add(currLevel);
				
		}		
		return result;
	}
}
