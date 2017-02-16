package LevelFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * s = "aabb", return ["abba", "baab"]
 * s = "abc", return []. 
 * 
 * http://www.geeksforgeeks.org/print-all-palindrome-permutations-of-a-string/
 * https://discuss.leetcode.com/topic/22214/ac-java-solution-with-explanation
 * 
 * The idea is to perform these three steps:
 * 
 * 1) Generate frequency table to check if a palindrome can be generated or not(Only one should be odd).
 * 2) Take half of the characters and generate all permutations.
 * 3) If odd char, append the odd char and the reverse of each permutaion, in case of even just append the reversed version.
 * 
 * Basically the first two steps are additional, rest we can use the PermutationDuplicatesSorted logic.
 */
public class PalindromePermutationII {
	public List<String> generatePalindromePermutations(String str){
		Map<Character, Integer> freqTable = new TreeMap<>();
		List<String> result = new ArrayList<>();
		List<Character> input = new ArrayList<>();
		
		int odd = 0;
		String mid = "";
		
		for(int i = 0; i < str.length();i++){
			char c = str.charAt(i);
			if(freqTable.containsKey(c)){
				freqTable.put(c, freqTable.get(c) + 1);
			}else{
				freqTable.put(c, 1);
			}
			odd += freqTable.get(c)%2 != 0 ? 1 : -1;
		}
		
		if(odd > 1) return result;
		
		for(char key : freqTable.keySet()){
			int value = freqTable.get(key);
			
			if(value %2 != 0) mid += key;
			for(int i = 0; i < value/2; i++){
				input.add(key);
			}
		}
		
		helper(result, new StringBuilder(), new boolean[input.size()], input, mid);
		return result;		
	}
	
	public void helper(List<String> result, StringBuilder sb, boolean[] used, List<Character> input, String mid){
		if(sb.length() == input.size()){
			StringBuilder temp = new StringBuilder(sb);
			result.add(temp.toString() + mid + temp.reverse().toString());
			return;
		}
		
		for(int i =0; i < input.size(); i++){
			if(used[i] || i > 0 && input.get(i) == input.get(i-1) && !used[i-1]) continue;
			int len = sb.length();
			sb.append(input.get(i));
			used[i] = true;
			helper(result, sb, used, input, mid);
			used[i] = false;
			sb.setLength(len);
		}
	}	
	
	public static void main(String[] args) {		
		PalindromePermutationII pds = new PalindromePermutationII();
		PalindromePermutationIICount pdsc = new PalindromePermutationIICount();
		
		String input1 = "aacbb";
		System.out.println(pds.generatePalindromePermutations(input1));
		System.out.println(pdsc.generatePalindromePermutations(input1));
		
		String input2 = "aabbcadad";
		System.out.println(pds.generatePalindromePermutations(input2));
		System.out.println(pdsc.generatePalindromePermutations(input2));
	}
}
/**
 * Previous solution - Quite complicated to intialize all the arrays and 
 * 3 iterations needed through the map..so not very convenient to do.
 */
class PalindromePermutationIICount {
	public List<String> generatePalindromePermutations(String input){
		Map<Character, Integer> freqTable = generateFreqTable(input);
		List<String> resultList = new ArrayList<>();
		
		boolean foundOdd = false;
		char midChar = ' ';
		
		for(char key : freqTable.keySet()){
			if(freqTable.get(key) % 2 != 0){
				if(foundOdd){
					return resultList;
				}else{
					foundOdd = true;
					midChar = key;
				}
			}
		}
		
		int size = freqTable.size();
		int count = input.length()/2;
		
		// If there is just one odd char of length 1, we wont need its permutations.
		if(foundOdd){
			size = freqTable.get(midChar) > 1 ? size : size -1;
		}
		
		char[] uniqueChars = new char[size];
		int[] charCount = new int[size];
		char[] result = new char[count];
		
		int i = 0;

		for (char key : freqTable.keySet()) {
			if (key != midChar) {
				uniqueChars[i] = key;
				charCount[i] = freqTable.get(key) / 2;
				i++;
			} else if (freqTable.get(midChar) > 1) {
				uniqueChars[i] = key;
				charCount[i] = freqTable.get(key) / 2;
				i++;
			}
		}
		String mid = midChar == ' '? "": String.valueOf(midChar);
		permute(uniqueChars, charCount, result, resultList, 0, mid);
		return resultList;
	}
	
	public void permute(char[] uniqueChars, int[] charCount, char[] result, List<String> resultList, int level, String mid){
		if(level == result.length){
			StringBuilder sb = new StringBuilder();
			sb.append(new String(result));
			resultList.add(sb.toString() + mid + sb.reverse().toString());
			return;
		}
		
		for(int i =0; i < uniqueChars.length; i++){
			if(charCount[i] == 0) continue;
			
			result[level] = uniqueChars[i];
			charCount[i]--;
			permute(uniqueChars, charCount, result, resultList, level + 1, mid);
			charCount[i]++;
		}
	}
	
	public Map<Character, Integer> generateFreqTable(String input){
		Map<Character, Integer> freqTable = new TreeMap<>();
		for(int i =0; i < input.length(); i++){
			char c = input.charAt(i);
			if(freqTable.containsKey(c)){
				freqTable.put(c, freqTable.get(c) + 1);
			}else{
				freqTable.put(c, 1);
			}
		}
		return freqTable;
	}
}
