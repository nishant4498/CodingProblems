package ModerateProblems;
/**
 * CTCI 16.1
 */
public class NumberSwapper {

	public static void main(String[] args) {
		int a = 5, b = 10;
		int[] result = swapNumber(a, b);
		System.out.println("After Swapping: "+ result[0]+ " " + result[1]);
		
		int c = 20, d = 25;
		int[] result1 = swapNumberXOR(c, d);
		System.out.println("After Swapping: "+ result1[0]+ " " + result1[1]);
	}
	
	public static int[] swapNumber(int a, int b){
		a = a + b;
		b = a - b;
		a = a - b;
		int[] result = new int[2];
		result[0] = a;
		result[1] = b;
		return result;
	}
	
	public static int[] swapNumberXOR(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		int[] result = new int[2];
		result[0] = a;
		result[1] = b;
		return result;
	}

}
