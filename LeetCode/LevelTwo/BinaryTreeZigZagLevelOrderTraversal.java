package LevelTwo;
/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * This is exactly same as level order traversal.
 * The only difference is on one level we append to end of the list, on another level we append in the beginning.
 * Basically the list is reversed on alternate levels.
 * We need an extra variable to keep track of the level count(just even or odd).
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import LevelOne.TreeNode;

public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int level = 0;

		while (!queue.isEmpty()) {
			List<Integer> currLevelList = new ArrayList<>();
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				/*
				 * This part is important.
				 */
				if (level % 2 == 0) {
					currLevelList.add(node.data);
				} else {
					currLevelList.add(0, node.data);
				}
			}
			result.add(currLevelList);
			level++;
		}
		return result;
	}
}
