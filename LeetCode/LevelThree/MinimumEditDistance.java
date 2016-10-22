package LevelThree;
/*
 * https://leetcode.com/problems/edit-distance/
 * Basically while doing matrix representation , we write first string on top horizontally and second string
 * on left vertically. Thus first string increments in j and second in i.
 * So The given problem is to convert word1 to word2 and not word2 to word1.
 * So basically if we follow the same convention , when wo go left we need to delete from word1 or insert into
 * word2.
 * When we go top, we insert into word1 and delete from word2.Replace does not change.
 * This can be little confusing, but nothing to be taken so seriously.What matters most is the right recurrence
 * and base case.
 * 
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 */
public class MinimumEditDistance {
	
	public static void main(String[] args){
		System.out.println(minEditDistance("abcdef", "azced"));
	}
	
	public static int minEditDistance(String word1, String word2){
		int m = word1.length();
		int n = word2.length();
		int[][] editDistance = new int[m+1][n+1];
		
		/*
		 * If we just have one string and other string of length 0, we need to delete all chars of first string.
		 */
		for(int i =0; i <= m ; i++){
			editDistance[i][0] = i;
		}
		
		/*
		 * same as above.
		 */
		for(int j =0; j<=n ; j++){
			editDistance[0][j] = j; 
		}
		
		for(int i =1; i<=m ; i++){
			for(int j =1; j<= n; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){// Since length of dp array is m+1 X n+1
					editDistance[i][j] = editDistance[i-1][j-1];
				}else{
					int insert = 1+ editDistance[i][j-1];
					int delete = 1+ editDistance[i-1][j];
					int replace = 1+ editDistance[i-1][j-1];
					
					int min = Math.min(insert, delete);
					min = Math.min(min, replace);
					editDistance[i][j] = min;
				}
			}
		}
		
		return editDistance[m][n];
	}
}
