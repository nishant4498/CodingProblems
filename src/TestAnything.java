import java.util.*;

public class TestAnything {
	public static void main(String[] args) {
		String str = "nishant";
		str.substring(0);
		str.substring(0,2);
		System.out.println(Arrays.toString(new char[]{'a','b','c','d','e'}));
		int[] input = {1,2,3,4,5,6};
		
		System.out.println(Math.ceil(7/2.0));
		
		int [] test = Arrays.copyOf(input,input.length);
		input[2] = 20;
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(test));
	}
	
	static int minMoves(int avg[]){
		int minStep = 0;
		int countZero = 0;
		for(int i = 0; i < avg.length; i++){
			if(avg[i] == 1){
				minStep += countZero;
			} else {
				countZero++;
			}
		}
		return minStep;
	}
	
	
	
	
}