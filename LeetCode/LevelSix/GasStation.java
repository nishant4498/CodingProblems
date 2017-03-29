package LevelSix;
/**
 * https://leetcode.com/problems/gas-station/
 * https://discuss.leetcode.com/topic/1344/share-some-of-my-ideas
 * 
 * Basically to check for a valid start point, here is the idea.
 * 
 * If car starts at A and can not reach B. Any station between A and B can not reach B.
 * (B is the first station that A can not reach.)
 * 
 * Also if the total gas is greater than the total number of cost, there must be a solution.
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0, tank = 0;
		int n = gas.length;
		int start = 0;
		for (int i = 0; i < n; i++) {
			totalCost += cost[i];
			totalGas += gas[i];

			tank = tank + gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}

		if (totalCost <= totalGas) {
			return start;
		}
		return -1;
	}
}
