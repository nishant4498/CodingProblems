package Level8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * In this approach
 * add - O(n) - we add all possible pairs sum to the sum datastructure while adding.
 * find - O(1)
 *
 */
public class TwoSumIIIDesign {
	Set<Integer> sum;
    Set<Integer> nums;
    
    /** Initialize your data structure here. */
    public TwoSumIIIDesign() {
        sum = new HashSet<>();
        nums = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(nums.contains(number)){
            sum.add(2 * number);
        }else{
            Iterator<Integer> iter = nums.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
        }
        nums.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}

/**
 * In this approach, add is O(1) - we simply add to the map.
 * Find is O(n)- we take each element in the map and search for its complement.
 *
 */

class TwoSum {
    Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, 2);
        }else{
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i : map.keySet()){
            int target = value - i;
            if(map.containsKey(target)){
                if(i == target && map.get(i) < 2){
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
