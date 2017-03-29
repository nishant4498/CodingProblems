package LevelSeven;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 *	
 *	Basically we can measure water if z is a multiple of gcd(x,y)
 *  i.e z % gcd(x,y) == 0
 */
public class WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z)
			return false;

		if (x == z || y == z || x + y == z)
			return true;

		return z % gcd(x, y) == 0;
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
