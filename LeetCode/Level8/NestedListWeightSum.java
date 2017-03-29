package Level8;

import java.util.List;

/**
 * http://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
 * Leetcode Locked.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2,
 * one 2 at depth 1)
 * 
 * Here is the tree for the above example: 
 * 
 *                   [2]        Depth 1
 *                   / \
 *				[1,1]   [1,1]   Depth 2
 *
 * Example 2: Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at
 * depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 *
 */
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList.size() == 0) return 0;
        return depthSum(nestedList, 1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth){
        if(nestedList.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        for(NestedInteger nestInteger : nestedList){
            if(nestInteger.isInteger()){
                sum += depth * nestInteger.getInteger();
            }else{
                sum += depthSum(nestInteger.getList() , depth + 1);
            }
        }
        
        return sum;
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
 
