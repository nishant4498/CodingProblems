package TreesAndGraphs;
/*
 * Create a Binary search tree of minimal possible height from a sorted array.
 */
public class MinimalTree {

	public static void main(String[] args) {
		
	}
	
	public TreeNode createMinimalBST(int[] arr){
		return createMinimalBST(arr, 0, arr.length -1);
	}
	
	private TreeNode createMinimalBST(int[] arr, int start, int end){
		if(start > end){
			return null;
		}
		
		int mid = (start + end)/2;
		
		TreeNode curr = new TreeNode(arr[mid]);
		curr.left = createMinimalBST(arr, start, mid -1);
		curr.right = createMinimalBST(arr, mid + 1, end);
		
		return curr;
	}
}
