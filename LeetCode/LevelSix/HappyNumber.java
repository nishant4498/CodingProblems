package LevelSix;
/**
 * https://leetcode.com/problems/happy-number/
 * https://discuss.leetcode.com/topic/30520/explanation-of-why-those-posted-algorithms-are-mathematically-valid
 * 
 * Similar to Floyd's cycle finding algorithm in a linked list.
 * 
 * The idea is we found a number a in the process and if we find it again , there is bound to be a cycle.
 * The second thing is the sum of squares is always upper bounded and it cannot go beyond a certain limit.
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;

		while (slow > 1) {
			slow = squareSum(slow);
			if (slow == 1) return true;

			fast = squareSum(squareSum(fast));
			if (fast == 1) return true;

			if (slow == fast) return false;
		}
		return true;
	}

	public int squareSum(int n) {
		int sum = 0;
		while (n > 0) {
			int val = n % 10;
			sum += val * val;
			n = n / 10;
		}
		return sum;
	}
}
