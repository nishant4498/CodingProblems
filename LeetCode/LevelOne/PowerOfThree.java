package LevelOne;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(1));
		System.out.println(isPowerOfThree(14));
	}
	
	public static boolean isPowerOfThree(int n) {
	        if(n == 1 || n == 3){
	            return true;
	        }
	        if( n == 0){
	            return false;
	        }
	        
	        while(n > 3){
	            if( n % 3 !=  0){
	                return false;
	            }
	            n = n / 3;
	        }
	        
	        if(n == 3){
	            return true;
	        }
	        return false;
	        
	        // Below is simple but takes more time on LeetCode.
	        /*if (n < 1) {
	            return false;
	        }

	        while (n % 3 == 0) {
	            n /= 3;
	        }

	        return n == 1;   */
	    }

}
