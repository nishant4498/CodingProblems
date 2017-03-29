package Level8;
/**
 * https://leetcode.com/problems/number-of-segments-in-a-string
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * 
 * Basically we need to trim the string and also trim the string parts.
 *
 */
public class CountStringSegments {
	public int countSegments(String s) {
        if(s.trim().length() == 0) return 0;
        
        String[] parts = s.split(" ");
        int count = 0;
        
        for(String str : parts){
            if(!str.trim().isEmpty()) count++;
        }
        return count;
    }
}
