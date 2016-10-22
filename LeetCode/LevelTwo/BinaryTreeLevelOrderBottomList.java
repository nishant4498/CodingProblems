package LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import LevelOne.TreeNode;

public class BinaryTreeLevelOrderBottomList {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		myQueue.offer(root);

		while (!myQueue.isEmpty()) {
			int levelCount = myQueue.size();
			List<Integer> currLevel = new ArrayList<>();
			for (int i = 0; i < levelCount; i++) {
				TreeNode node = myQueue.poll();
				if (node.left != null) {
					myQueue.offer(node.left);
				}
				if (node.right != null) {
					myQueue.offer(node.right);
				}
				currLevel.add(node.data);
			}
			result.add(0, currLevel);

		}
		return result;
	}
}
