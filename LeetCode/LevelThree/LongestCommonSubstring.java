package LevelThree;
/*
 * Basically the difference between this and subsequence is here we need to only check the LCS[i-1][j-1]
 * if x[i] = y[j].
 * The second difference id that the result is not stored in the LCS[m][n]. We need to navigate through the 
 * entire matrix to check for the result.Here we just keep updating the result in maxLength.
 */
public class LongestCommonSubstring {
	public static void main(String[] args){
		System.out.println(longestCommonSubstring("abcdaf", "acbcf"));// 2 bc
		System.out.println(longestCommonSubstring("ABCDGH", "XYABCDR"));// 4 ABCD
	}
	
	public static int longestCommonSubstring(String x, String y){
		int m = x.length();
		int n = y.length();
		
		int[][] LCS = new int[m+1][n+1];//length of matrix is one more than the length of the strings.
		int maxLength =0;
		for(int i =0; i<=m; i++){
			for(int j =0;j <=n; j++){
				if(i ==0 || j ==0){
					LCS[i][j] = 0;
				}
				else if(x.charAt(i-1) == y.charAt(j-1)){// same reason as subsequence problem.
					LCS[i][j] = 1 + LCS[i-1][j-1];
					maxLength = Math.max(maxLength, LCS[i][j]); 
				}else{
					LCS[i][j] = 0;
				}
			}
		}
		
		return maxLength;
		
	}
}
