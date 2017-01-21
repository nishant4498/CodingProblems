package LevelTwo;

import java.util.ArrayList;
import java.util.List;

import LevelOne.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/ An example is the
 * root-to-leaf path 1->2->3 which represents the number 123.Find the total sum
 * of all root-to-leaf numbers.
 */
public class BinaryTreeSumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<String>();
        int sum = 0;
        if(root == null){
            return sum;
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb, nums);
        
        for(String num : nums){
            sum += Integer.valueOf(num);
        }
        return sum;
    }
    
    public void helper(TreeNode root, StringBuilder sb, List<String> result){
        if(root == null){
            return;
        }
        /**
         * Length must be computed before appending the data.
         */
        int length = sb.length();
        sb.append(root.data);
        if(root.left == null && root.right == null){
            result.add(sb.toString());
            /**
             * No return here.
             */
        }else{
            helper(root.left, sb, result);
            helper(root.right, sb, result);
        }
        
        /**
         * Length must be set in the end
         * Basically with every such problem where we are using StringBuilder we need to follow 
         * this approach.
         * BinaryTreeRootToLeafPaths
         */
        sb.setLength(length);
    }
}
