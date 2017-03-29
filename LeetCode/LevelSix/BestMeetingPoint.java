package LevelSix;
/*
 * http://www.programcreek.com/2014/07/leetcode-best-meeting-point-java/
 * Leetcode locked.
 * 
 * Given a grid where 1's represent houses, and the distance to be considered is manhatten distance,
 * we need to find the minimum distance needed to tavel for all to meet.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Basically in this problem all we need to do is find the positions of the points in the x and y co-ords
 * and then the nearest point 
 */

/*
 * As long as you have different numbers of people on your left and on your right, 
 * moving a little to the side with more people decreases the sum of distances. 
 * So to minimize it, you must have equally many people on your left and on your right. 
 * Same with above/below.
 * Thus we need to have median of the rows and cols so that we will have equal number of people 
 * on both sides.
 */
public class BestMeetingPoint {
	public static int minMeetingDistance(int[][] grid){
		int m = grid.length;
		int n = grid[0].length;
		
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		for(int i =0; i< m ;i++){
			for(int j =0; j< n; j++){
				if(grid[i][j] == 1){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		int minDistance = 0;
		/**
		 * We don't need to sort the rows as we access the rows already in ascending order.
		 */
		int rowMedian = rows.get(rows.size()/2);
		for(int i: rows){
			minDistance += Math.abs(i - rowMedian);
		}
		
		/*
		 * We sort the cols as the order of the columns might not be in increasing order.
		 * The rows are always in ascending order since we iterate that way.
		 */
		Collections.sort(cols);
		
		int colMedian = cols.get(cols.size()/2);
		for(int i: cols){
			minDistance += Math.abs(i - colMedian);
		}
		
		return minDistance;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(minMeetingDistance(grid));
	}
}
