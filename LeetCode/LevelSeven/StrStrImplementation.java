package LevelSeven;
/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStrImplementation {
	public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        for(int i =0; i < haystack.length(); i++){
            if(i + needle.length() > haystack.length()) return -1;
            
            if(haystack.charAt(i) == needle.charAt(0)){
                if(isPresent(haystack, needle, i)){
                    return i;
                }
            }
        }
        return -1;
    }
    
    private boolean isPresent(String haystack, String needle, int pos){
        for(int i = 0; i < needle.length(); i++,pos++){
            if(needle.charAt(i) != haystack.charAt(pos)){
                return false;
            }
        }
        return true;
    }
}
