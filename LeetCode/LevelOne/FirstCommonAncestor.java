package LevelOne;
public class FirstCommonAncestor {
	/*
	 * This method is similar to finding the intersection of two linked lists.
	 * We first find the difference bw the depth of nodes anf move the deeper one upwards
	 * The link to parents needs to be stored.
	 */
	public TreeNode commonAncestorWithParentLink(TreeNode p, TreeNode q){
		int delta = depth(p) - depth(q);
		TreeNode deep = (delta > 0) ? p : q;//get deeper node.
		TreeNode shallow = (delta > 0) ? q : p;//get shallower node.
		
		deep = goUpBy(deep, Math.abs(delta));
		
		while(deep != shallow && deep != null && shallow != null){
			deep = deep.parent;
			shallow = shallow.parent;
		}
		
		return deep == null || shallow == null ? null : deep; 
	} 
	/*
	 * Check for any of the p and q in both left and right subtree.
	 * We keep on moving until we see that that both nodes are on one side.
	 * The LCA is the node where p is on one side and q on the other side.
	 */
	public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q)
			return root;
		
		TreeNode l = lowestCommonAncestorRecursion(root.left, p, q);
		TreeNode r = lowestCommonAncestorRecursion(root.right, p, q);
		
		//This is the point of LCA.
		if(l != null && r != null) return root;
		
		if(l == null && r == null) return null;
		
		return l == null ? r : l;
	}
	
	private TreeNode goUpBy(TreeNode node, int delta){
		while(delta > 0 && node != null){
			node = node.parent;
			delta--;
		}
		return node;
	}
	/*
	 * According to my understanding condition should be node.parent != null
	 * since this would give the depth of root as 1 which is wrong.(It should be zero).
	 */
	private int depth(TreeNode node){
		int depth = 0;		
		while(node != null){
			node = node.parent;
			depth++;
		}
		return depth;
	}
}
