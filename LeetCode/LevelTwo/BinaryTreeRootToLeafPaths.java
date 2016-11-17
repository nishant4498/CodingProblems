package LevelTwo;

import java.util.ArrayList;
import java.util.List;

import LevelOne.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreeRootToLeafPaths {
	public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        findPaths(root, result, sb);
        return result;
    }
	/*
	 * Basically what we need to take care is at each path we just store the strings for that 
	 * path only. So here we calculate the length of string builder at a given level,
	 * and then reset it back to that length after computing for that level.
	 */
	public void findPaths(TreeNode root, List<String> result, StringBuilder sb){
		if(root == null){
			return;
		}
		
		int length = sb.length();
		sb.append(root.data);
		
		if(root.left == null && root.right == null){
			result.add(sb.toString());
			// here we can't return as in ListPathWithSum
		}else{
			sb.append("->");
			findPaths(root.left, result, sb);
			findPaths(root.right, result, sb);
		}
		
		sb.setLength(length);
	}
}
