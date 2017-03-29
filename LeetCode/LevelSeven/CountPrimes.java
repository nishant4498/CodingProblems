package LevelSeven;
/**
 * https://leetcode.com/problems/count-primes/
 * 
 * 1) We write a function isPrime() that will check for each number in the range 1-n , whether
 * 	  it is prime or not. 
 * 2) One of the first things to improve complexity is we only need to check till num/2 for each number n.
 * 
 * 3) We can further see that even we can improve n/2 - Lets say n = p * q . Now since p <= q,
 * 	  we can derive that p <= sqrt(n).
 */
public class CountPrimes {
	/**
	 * Time = O(n^1.5)
	 * Space = O(1)
	 * 
	 */
	public int countPrimes(int n){
		int count = 0;
		
		for(int i = 1; i < n; i++){
			if(isPrime(i)){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 1 is not considered as Prime.
	 * 2 is considred as prime
	 */
	private boolean isPrime(int num){
		if(num <= 1) return false;
		
		//Here we use the condition i * i <= num rather than using the Math.sqrt function.
		for(int i = 2; i*i <= num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	/**
	 * Time - O(nloglogn)
	 * Space - O(n)
	 * Check the hint in the problem link for description.
	 */
	public int countPrimesOptimized(int n){
		/**
		 * 1. Create a boolean array that will keep marking the numbers that we can't be prime.
		 */
		
		boolean[] isPrime = new boolean[n];
		
		/**
		 * 2. Here we initalize all as true, so that we can mark false later.
		 */
		
		for(int i = 2; i < n ; i++){
			isPrime[i] = true;
		}
		
		/**
		 * 3. In this step we run a loop starting from i = 2 to sqrt(n).
		 * 	  Here for each i we mark the multiples of i as not primes.
		 * 	  Also for each i, we only need to start from i * i.
		 *    The reason for this is , let's say i = 5. Now all multiples of 5 before 25(5 * 5)
		 *    i.e 10, 15, 20 will be marked as not prime when i = 2,3. 
		 */
		
		for(int i = 2; i * i < n; i++){
			for(int j = i * i; j < n; j += i){
				isPrime[j] = false;
			}
		}
		
		/**
		 * In the end we just need to count the numbers of elemnts in the boolean array which are true.
		 */
		
		int count = 0;		
		for(int i = 0; i < n ; i++){
			if(isPrime[i]) count++;
		}
		return count;
	}
}
