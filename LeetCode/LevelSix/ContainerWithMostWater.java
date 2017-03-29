package LevelSix;
/**
 * https://leetcode.com/problems/container-with-most-water
 * https://leetcode.com/articles/container-most-water/
 * 
 * Basically the intution behind this approach is:
 * 1) Area b/w two lines is limited by the smaller line.
 * 2) The farther the lines, the larger the area will be.
 * 
 * Thus we start with the two ends. At each step we compute the currArea and update the maxArea, if the
 * currArea is greater.
 * 
 * To move the pointer in each step, we move the pointer of the smaller side since, the longer side will
 * give more area
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1, maxArea = 0;

		while (l < r) {
			int currArea = Math.min(height[l], height[r]) * (r - l);
			maxArea = Math.max(maxArea, currArea);

			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}
}
