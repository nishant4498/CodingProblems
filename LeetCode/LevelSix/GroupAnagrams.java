package LevelSix;
/**
 * https://leetcode.com/problems/anagrams/
 * CTCI 10.2
 * 
 * The whole idea here is to sort the string in the array and use it as a key.
 * Since all anagrams after sorting will be the same, we can use that as key in the hashmap,
 * and store the actual string in the list.
 * 
 * The list of anagrams will be stored as values in the map.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
