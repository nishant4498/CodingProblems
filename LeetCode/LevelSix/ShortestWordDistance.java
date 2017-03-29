package LevelSix;
/**
 * CTCI - 17.11
 *
 * https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.4.html
 */
public class ShortestWordDistance {
	public static int computeShortestDistance(String[] words, String wordOne, String wordTwo){
		int index1 = -1, index2 =-1;
		int minDistance = Integer.MAX_VALUE;
		
		for(int i =0; i< words.length ;i++){
			if(words[i].equals(wordOne)){
				index1 = i;
			}
			if(words[i].equals(wordTwo)){
				index2 = i;
			}
			
			if(index1 != -1 && index2 != -1){
				minDistance = Math.min(minDistance, Math.abs(index1 - index2));				
			}			
		}
		return minDistance;		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] a = {"the", "quick", "brown", "fox", "quick"};
		String[] a = {"the", "shame", "brown", "the", "shame","hello","hello"};
		System.out.println(computeShortestDistance(a, "shame", "hello"));
	}
}
