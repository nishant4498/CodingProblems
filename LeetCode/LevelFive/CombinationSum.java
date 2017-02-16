package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * Given a set of candidate numbers C(without duplicates), a target sum T, find all unique 
 * combinations in C that sum to T.The same number may be chosen from C any number of times.
 * 
 * C = [2,3,6,7] T = 7 
 * Solution Set - [ [2,2,3] , [7] ]
 * 
 * Two important points to note here;
 * 
 * 1) Stop condition is when sum = 0 and we come out of the loop when input[i] > target.
 * 2) start in each call is updated to i and not i + 1, since we need to consider each element.
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, tempList, candidates , target, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result,List<Integer> tempList, int[] input, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = start; i < input.length; i++){
            if(input[i] > target) continue;
            tempList.add(input[i]);
            helper(result, tempList, input, target - input[i], i);
            tempList.remove(tempList.size() -1);
        }
    }
}
