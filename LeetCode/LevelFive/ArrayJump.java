package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * https://www.youtube.com/watch?v=cETfFsSTGJI - Tushar Roy
 * https://www.youtube.com/watch?v=vBdo7wtwlXs - Ideserve
 * 
 * http://www.allenlipeng47.com/blog/index.php/2016/09/12/jump-game-ii/ BFS Solution
 * https://discuss.leetcode.com/topic/3191/o-n-bfs-solution
 */
public class ArrayJump {

	/*
	 * This solution is O(n^2). It works fine but gives time limit ecceeded
	 * exception for just one test case.
	 * 
	 * Basically its similar to coin change problem. Here at each position we keep comparing the 
	 * minimum number of steps that need to be taken to reach that position.
	 * The final minimum number of steps will be at position jumps[n-1].  
	 */
	public static int jumpDP(int[] nums) {
		int n = nums.length;

		if (n == 0)
			return 0;
		int[] jumps = new int[n];// stores the minimum number of jumps needed to reach any index
		int[] result = new int[n];// Stores the result i.e the position from which we came to particular index
		

		jumps[0] = 0;

		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					if (jumps[j] + 1 < jumps[i]) {
						jumps[i] = jumps[j] + 1;
						result[i] = j;
					}
				}
			}
		}

		
		
		/**
		 * BEGIN To print the actual solution, we need to follow the result array from end
		 */
		
		int pos = n-1;
        List<Integer> actualJumps = new ArrayList<>();
        while(pos!= 0){
        	actualJumps.add(0,pos);
        	pos = result[pos];
        }
        
        actualJumps.add(0,0);
        for(int jump : actualJumps){
        	System.out.print(jump + ", ");
        }
		/**
		 * END
		 */
        
        return jumps[n - 1];
		
	}
}
