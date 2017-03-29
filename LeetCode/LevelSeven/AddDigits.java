package LevelSeven;
/**
 * https://leetcode.com/problems/add-digits/
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 *  This process is called calculating digital root or repeated digital sum.
 *  
 *  Its formula is dr(n) = 1 + (n - 1) % 9 or 1 + (n-1) % (b - 1) , where b is the base - 10 in case of decimal. 
 */
public class AddDigits {
	public int addDigits(int num) {
		return 1 + (num - 1) % 9;
	}
	
	public int addDigitsRec(int num) {
        int sum = 0;
        String n = String.valueOf(num);
        
        for(int i =0; i < n.length(); i++){
            sum += n.charAt(i) - '0';
        }
        
        if(sum >= 10){
            return addDigitsRec(sum);
        }else{
            return sum;
        }
    }
	
}
