package LevelSeven;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import LevelTwo.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Idea here is to generate a string for the tree using PreOrder traversal.
 * We use a splitter "," to split every node value and "X" to denote null values.
 * 
 * While deserializing, we split the string using splitter, then run the build tree using preorder.
 *
 */
public class SerializeAndDeserializeBinaryTree {

}

class Codec {
    private static final String splitter = ",";
    private static final String NN = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NN).append(splitter);
        }else{
            sb.append(root.data).append(splitter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }
    
    
    public TreeNode buildTree(Queue<String> nodes){
        String val = nodes.poll();
        if(val.equals(NN)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
