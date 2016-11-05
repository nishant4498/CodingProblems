package LevelTwo;
/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Basically the right side view of a Binary Tree is the last node in each level in the level order 
 * traversal.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import LevelOne.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.offer(root);

		while (!q.isEmpty()) {
			int levelCount = q.size();

			for (int i = 0; i < levelCount; i++) {
				TreeNode curr = q.poll();

				if (curr.left != null) {
					q.offer(curr.left);
				}

				if (curr.right != null) {
					q.offer(curr.right);
				}
				
				if (i == levelCount - 1) {
					result.add(curr.data);
				}
			}
		}

		return result;
	}
}
