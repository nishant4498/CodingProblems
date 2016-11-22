package LevelThree;
/*
 * https://www.youtube.com/watch?v=_nCsPn7_OgI
 */
public class LongestPalindromicSubsequence {
	
	public static void main(String[] args){
		System.out.println(longestPalindromicSubsequence("agbdba"));// 5 abdba
		System.out.println(longestPalindromicSubsequence("BBABCBCAB"));// 7 BABCBAB
	}
	
	public static int longestPalindromicSubsequence(String s){
		int n = s.length();
		int[][] LPS = new int[n][n];
		
		//Initialize for length = 1
		
		for(int i =0; i< n; i++){
			LPS[i][i] = 1;
		}
		
		//Initialize for length = 2
		for(int i=0; i < n-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				LPS[i][i+1] = 2;
			}
		}
		// For length 3 or more.
		for(int k =3; k <= n; k++){
			for(int i =0; i< n-k+1; i++){
				int j = i + k -1;
				if(s.charAt(i) == s.charAt(j)){ //Here we do not check for LPS[i + 1][j - 1] as in case of substring.  
					LPS[i][j] = 2 + LPS[i+1][j-1];
				}else{
					LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);// This is different than substring.
				}
			}
		}
		
		return LPS[0][n-1];	//Result is found at this location.
		
	}
}
