package LevelTwo;

/*
 * https://leetcode.com/problems/fizz-buzz/
 * Mutiple of 3- Fizz
 * Multiple of 5 - Buzz
 * Both - FizzBuzz
 * None - Number.
 */

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		List<String> result = fizzBuzz(15);
		for(String str: result){
			System.out.print(str + " ");
		}
	}
	
	public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        for(int i =1; i<=n;i++){
            if(i % 3 == 0 && i % 5 ==0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else{
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }

}
