package LevelSix;
/**
 * https://leetcode.com/problems/wildcard-matching/
 * https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution
 * 
 * 1. Advancing both pointers, if either we get '?' or both characters are same.
 * 2. * found in the pattern. We keep track of the index of * and then advance the pattern pointer.
 * 	  Here couple of points to watch for:
 *      - Since * can match any sequence of chracters , including space, we cannot increment i when we encounter
 *        a * in the pattern.Otherwise this kind of case will fail :
 *        s = "c" p = "*c"  - In these cases i reaches the end before j. 
 *        Thus we maintain an index where we saw * in p and corresponding match index in s. 
 * 3. Current characters did not match , no '?', last pattern pointer was *, current pattern pointer is not *,
 *     - Only advancing string pointer.
 *     - Set the j pointer to last star position.
 * 4. Current pattern pointer is not *, last pointer was not *, chracters do not match.
 * 
 * The main idea in steps 2 and 3 here is, as long as we see *, we keep moving forward in the pattern pointer,
 * since it may point to an empty space.
 * But it might be possible that we reach the end of pattern while we have more characters in the search string
 * e.g -  s = "aaaa" p ="***a" here we start with i = 0 and j = 0, continue till j = 3 by step 2.
 *        Then match chars at i = 0 and j = 3 thus move both forward.
 *        In this case i is still 1 and j = 4.
 *        In Such cases we just move back j pointer to the last star index and move i since we can match anything with
 *        a *.
 */
public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
        int i = 0, j = 0, starIndex = -1,match = 0;
        
        while(i < s.length()){          
            if(j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                starIndex = j;
                match = i;
                j++;
            }else if(starIndex != -1){
                /**
                 * Basically whenever we have previously seen a '*' and we have chracters in the string left,
                 * we can reset j = last star index and move i.
                 * This step is very critical.
                 */
            	j = starIndex;
                match++;
                i = match;
            }else{
                return false;
            }
        }
        
        while(j < p.length() && p.charAt(j) == '*') j++;
        
        return j == p.length();
    }
	
	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "*"));
	}
}
