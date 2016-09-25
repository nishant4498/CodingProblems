package TreesAndGraphs;

import java.util.Random;

public class GetRandomNode {

}
/*
 * Ths idea of this approach is to keep track of the size of the left and right subtree of each node.
 * Based on this size we calculate the probablity of getting the random node.
 * The branch having greater size has a higher probability of being chosen. 
 */
class TreeNodeRandom{
	private int data;
	private TreeNodeRandom left;
	private TreeNodeRandom right;
	private int size;
	
	public TreeNodeRandom(int d){
		data = d;
	}
	
	public TreeNodeRandom getRandomNode(){
		int leftSize = left == null? 0 : left.size;
		
		Random random = new Random();
		/*
		 * Generates a random number between 0(inclusive) and size(exclusive).
		 */
		int index = random.nextInt(size);
		/*
		 * It is important to note that we have to compare with either leftSize or rightSize
		 * since the random number generated will not include size. 
		 */
		if(index < leftSize){
			return left.getRandomNode();
		}else if(index == leftSize){
			return this;
		}else{
			return right.getRandomNode();
		}		
	}
	
	public void insertInOrder(int d){
		if(d <= data){			
			if(left == null){
				TreeNodeRandom node = new TreeNodeRandom(d);
				left = node;
			}else{
				left.insertInOrder(d);
			}
		}else{
			if(right == null){
				TreeNodeRandom node = new TreeNodeRandom(d);
				right = node;
			}else{
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public TreeNodeRandom find(int d){
		if(d == data){
			return this;
		} else if(d <= data){
			return left != null ? left.find(d): null;
		}else{
			return right != null? right.find(d): null;
		}		
	}	
}
