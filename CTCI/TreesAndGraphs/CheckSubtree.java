package TreesAndGraphs;
/*
 * The problem is to find whether one Tree T2 is a subtree of a bigger Tree T1
 * There are two approaches:
 * 1) Perform Preorder traversal on both the trees with some tweaking(set the null nodes as value X) and generate
 * traversal strings. If Preorder(T1).subString(preOrder(T2)) return true;
 * 
 * 2) In this approach we traverse the bigger tree T1 and whenever we get a node matching T2's root, we compare the 
 * two trees. If it matches return true, else check for another matching root. 
 */
public class CheckSubtree {
	/*
	 * Approach one
	 * Time complexity = O(m + n)
	 */
	public boolean checkSubtreePreorder(TreeNode t1, TreeNode t2){
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getPreorderString(t1, string1);
		getPreorderString(t2, string2);
		
		return string1.indexOf(string2.toString()) != -1;
		
	}
	
	private void getPreorderString(TreeNode node, StringBuilder s){
		if(node == null){
			s.append("X");
			return;
		}
		
		s.append(node.data);
		getPreorderString(node.left, s);
		getPreorderString(node.right, s);
	}
	
	/*
	 * Approach 2
	 * Time complxity = O(n + km) 
	 * n = number of nodes in T1
	 * m = number of nodes in T2
	 * k = number of matches root of T2 in T1. 
	 */
	
	
	public boolean checkSubtree(TreeNode t1, TreeNode t2){
		if(t2 == null) return true; // Empty node is always a subtree.
		
		return isSubtree(t1, t2);
	}
	
	public boolean isSubtree(TreeNode r1, TreeNode r2){
		if(r1 == null) return false;// Big tree is null, so return false;
		
		if((r1.data == r2.data) &&  matchTree(r1, r2)) return true;
		
		return isSubtree(r1.left, r2) || isSubtree(r1.right, r2);
	}
	
	private boolean matchTree(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			return true; //Reached end of tree.
		}else if(t1 == null || t2 == null){
			return false;
		}else if(t1.data != t2.data){
			return false;
		}else{
			return checkSubtree(t1.left, t2.left) && checkSubtree(t1.right, t2.right);
		} 
	}
}
