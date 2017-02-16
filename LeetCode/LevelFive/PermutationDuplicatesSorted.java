package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This problem is to basically find all the possible unique permutations of a string in sorted order.
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&list=	PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh
 */
public class PermutationDuplicatesSorted {	
	public List<String> permuteUnique(String str) {
		List<String> result = new ArrayList<>();
		char[] input = str.toCharArray();		
		Arrays.sort(input);
		helper(result, new StringBuilder(), new boolean[input.length], input);
		return result;
	}
	/**
	 * If we need to generate a string as output instead of list, we can use StringBuilder 
	 * in place of templist.
	 */
	public void helper(List<String> result, StringBuilder sb, boolean[] used, char[] input) {
		if (sb.length() == input.length) {
			result.add(sb.toString());
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (used[i] || i > 0 && input[i] == input[i - 1] && !used[i - 1])
				continue;
			int len = sb.length();
			sb.append(input[i]);
			used[i] = true;
			helper(result, sb, used, input);
			used[i] = false;
			sb.setLength(len);
		}
	}
	
	public static void main(String[] args) {
		//String input = "AABC";
		String input = "aabd";
		//String input = "123";
		PermutationDuplicatesSorted pds = new PermutationDuplicatesSorted();
		System.out.println(pds.permuteUnique(input));
		
		PermutationDuplicatesSortedCount pdsc = new PermutationDuplicatesSortedCount();
		System.out.println(pdsc.permute(input));
	}
}

class PermutationDuplicatesSortedCount {
	
	public List<String> permute(String input){
		List<String> result = new ArrayList<>();
		char[] chars = input.toCharArray();
		Map<Character, Integer> freqTable = generateFrequenceyTable(chars);
		int numChars = freqTable.size();
		
		char[] uniqueChars = new char[numChars];
		int[] charCount = new int[numChars];
		char[] str = new char[input.length()];
		
		int i = 0;
		for(char key : freqTable.keySet()){
			uniqueChars[i] = key;
			charCount[i] = freqTable.get(key);
			i++;
		}
		helper(uniqueChars, charCount, str, result, 0);
		return result;		
	}
	
	/**
	 * 
	 * @param input - The input string containing unique chars that need to be permuted.
	 * @param charCount - Count of each character in the input. 
	 * @param result - Each single strng permutation for the given input string.
	 * @param resultList - The list of all possible unique permutations 
	 * @param level - Depth of recursion.Max depth - length of the actual string
	 */
	public void helper(char[] input, int[] charCount,char[] result, List<String> resultList, int level){
		if(level == result.length){
			resultList.add(new String(result));
		}
		
		for(int i =0; i < input.length; i++){
			if(charCount[i] == 0){
				continue;
			}
			
			result[level] = input[i];
			charCount[i]--;
			helper(input, charCount, result, resultList, level +1);
			charCount[i]++;
		}
	}
	
	public Map<Character,Integer> generateFrequenceyTable(char[] chars){
		Map<Character, Integer> countMap = new TreeMap<>();
		for(char c : chars){
			if(countMap.containsKey(c)){
				countMap.put(c, countMap.get(c) + 1);
			}else{
				countMap.put(c, 1);
			}
		}
		return countMap;
	}	
}
