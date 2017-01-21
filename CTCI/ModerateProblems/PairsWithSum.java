package ModerateProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 16.24
 */
public class PairsWithSum {
	public List<Pair> getPairsWithSum(int[] nums, int sum){
		List<Pair> result = new ArrayList<>();
		if(nums == null || nums.length == 0 ) return result;
		Set<Integer> set = new HashSet<>();
		
		for(int i =0; i < nums.length; i++){
			int num = nums[i];
			int compliment = sum - num;
			// we check that the number has already been not seen to avoid duplicates
			if(set.contains(compliment) && !set.contains(num)){
				result.add(new Pair(num, compliment));
			}			
			set.add(num);
		}
		
		return result;
	}
}

class Pair{
	int num1;
	int num2;
	
	public Pair(int n1, int n2){
		this.num1 = n1;
		this.num2 = n2;
	}
}
