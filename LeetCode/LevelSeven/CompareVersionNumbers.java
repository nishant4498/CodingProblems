package LevelSeven;
/**
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * Basically the idea here is simple:
 * 
 * 1) We split the version number into various parts and kepp comparing each part sequentially
 *    from the beginning.
 *    
 * 2) To avoid the pain of computing the length of each versions, we simply compare with
 *    0 in case we are out of range for any version number.
 * 3) We simply run the loop till the version number which is largest.
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
	       String[] parts1 = version1.split("\\.");// Important to escape these characters
	       String[] parts2 = version2.split("\\.");
	       
	       int len = Math.max(parts1.length, parts2.length);
	       
	       for(int i = 0; i < len ; i++){
	           Integer v1 = i < parts1.length ? Integer.valueOf(parts1[i]) : 0;
	           Integer v2 = i < parts2.length ? Integer.valueOf(parts2[i]) : 0;
	           
	           int diff = v1.compareTo(v2);// compareTo does exactly what we need to return.
	           
	           if(diff != 0){
	               return diff;
	           }
	       }
	       
	       return 0;
	    }
}
