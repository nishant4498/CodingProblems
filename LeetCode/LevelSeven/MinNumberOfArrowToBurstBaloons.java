package LevelSeven;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 
 * The basic idea here is to sort the diameters with their end points.
 * 
 * So basically start point of whichever baloon lies in the range of this end point,
 * it can be burst with the same arrow.
 *
 */
public class MinNumberOfArrowToBurstBaloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;

		Arrays.sort(points, (a, b) -> a[1] - b[1]);// Sort on the basis of end
													// points.

		int arrowPos = points[0][1];
		int count = 1;

		for (int i = 1; i < points.length; i++) {
			/**
			 * The start point of next baloon is less than current end diameter
			 * so, it can be burst with the same arrow.
			 */
			if (arrowPos >= points[i][0]) {
				continue;
			}
			count++;
			arrowPos = points[i][1];
		}
		return count;
	}
}
