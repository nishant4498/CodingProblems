package LevelThree;

public class LongestCommonSubsequence {
	public static void main(String[] args){
		System.out.println(longestCommonSubsequence("abcdaf", "acbcf"));// 4 abcf
		System.out.println(longestCommonSubsequence("ABCDGH", "AEDFHR"));// 3 ADH
		System.out.println(longestCommonSubsequence("AGGTAB","GXTXAYB"));// 4 GTAB
	}
	
	public static int longestCommonSubsequence(String x, String y){
		int m = x.length();
		int n = y.length();
		int[][] LCS = new int[m + 1][n + 1]; 
		if(m == 0 || n ==0) return 0;
		/*
		 * LCS[i][j] reprsents the length of longest subsequence with x[1..i] and y[1..j]
		 */
		for(int i =0; i <= m; i++){
			for(int j =0; j<= n ; j++){
				if(i == 0 || j ==0 ){
					LCS[i][j] = 0;
				}else{
					/*
					 * We use i-1 since the total size of the LCS is one greater than the length of strings
					 * and thus the character at index 0 in the string will be at index 1 in the array.
					 */
					if(x.charAt(i-1) == y.charAt(j-1)){
						LCS[i][j] = 1 + LCS[i-1][j-1]; 
					}else{
						LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
					}
				}
			}
		}
		
		return LCS[m][n];
	}
}
