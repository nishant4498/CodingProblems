package LevelSeven;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals
 * 
 * Given a collection of intervals, find the minimum number of intervals you need to remove 
 * to make the rest of the intervals non-overlapping.
 * 
 * Basically this is interval scheduling. 
 * 
 * We should sort here by end time, since if we sort on the basis of start time, there might
 * be one interval with very less start time but very long end time. 
 * Thus the overlaps will increase and we will have to remove more intervals.
 *
 */
public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2){
				return o1.end - o2.end;
			}
		});
		
        // Arrays.sort(intervals, (o1, o2) -> o1.end - o2.end);
        
		int end = intervals[0].end;
		int count = 0;
		
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i].start >= end){
				end = intervals[i].end;
			}else{ 
				count++;
			}
		}
		return count;
    }
}
