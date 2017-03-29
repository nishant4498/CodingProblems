package LevelSix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 * 
 * We need to design a data structure which supports insert, delete and get random in O(1).
 * 
 * Since we have to get in O(1) we get an intution that we need to use hash map.
 * 
 * 1) We define a - List<Integer> which stores the values in the list
 *                  Map<Integer, Integer> which stores the key and its position in the list.
 * 
 * 2) Insert - If the value is already there in Map we return false.
 *           - We insert in the map the value , and the current size of the list.
 *           - Then we insert the value in the list.
 * 
 * 3) Delete - Delete is little tricky since we need to update all the indices in the map if we 
 *             delete a middle element in the list.
 *           - A nice way to hadle this is to swap the item to be deleted in the list with the last item
 *           - This way we just need to update the index of last element in the map.
 *           - Then we can delte that item from the map and also deleet the last element in the list.
 * 
 * 
 * 4) Random - Just delete a random element from the list by selecting the index in the range 0 - nums.size()
 *           - we use list.get(rand.nextInt(nums.size()))
 *
 */
public class InsertDeleteGetRandom {
	List<Integer> nums;
    Map<Integer, Integer> map;
    Random rand;
    
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int pos = map.get(val);
        /**
         * Swaps the value to be deleted with the last element.
         * Then we delete the last element. This way we don't need to upfate positions in the map.
         */
        if(pos < nums.size() -1){
            int lastVal = nums.get(nums.size()-1);
            nums.set(pos, lastVal);
            map.put(lastVal,pos);
        }
        
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * For handling the duplicates we just need to keep in the map a set of positions
 * 
 * Map<Integer, Set<Integer>> map - If 1 is inserted multiple times, there will be multiple entries for 1.
 * 
 */
