package Locked;

public class OneEditAway {

	public static void main(String[] args) {
		System.out.println(oneEditAwayModular("apple", "aple"));
		System.out.println(oneEditAwayModular("aple", "apple"));
		System.out.println(oneEditAwayModular("kpple", "apple"));
	}
	
	public static boolean oneEditAwayModular(String first, String second) {
		if (first == null || second == null || Math.abs(first.length() - second.length()) > 1)
			return false;

		if (first.length() == second.length())
			return oneEditReplace(first, second);
		else if (first.length() > second.length())
			return oneEditInsert(second, first);
		else
			return oneEditInsert(first, second);
	}
	/*
	 * If there are more than one different chracters just return false
	 */
	public static boolean oneEditReplace(String s1, String s2){
		boolean foundDifference = false;
		for(int i =0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if (foundDifference){
					return false;
				}					
				foundDifference = true;
			}
		}
		return true;
	}
	
	public static boolean oneEditInsert(String shorter , String longer){
		int index1 = 0 , index2 = 0;
		int shorterLen = shorter.length();
		int longerLen = longer.length();
		
		while(index2 < longerLen && index1 < shorterLen){
			if(shorter.charAt(index1) != longer.charAt(index2)){
				/*
				 * Basically when we find a different string first time both the
				 * indices should be same.If characters are differnt and indices
				 * are also diff , this means that this is the second diff
				 * character in the two strings.
				 * 
				 * Simply we can also use a boolean flag to see if a diff has been found already
				 */
				if(index1 != index2){
					return false;
				}
				index2++; // increment the longer string index.We just do this once since next time will be 2nd mismatch.
			}else{ // compare the next two chars
				index1++;
				index2++;
			}
		}		
		return true;
	}

}
