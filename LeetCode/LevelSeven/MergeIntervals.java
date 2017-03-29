package LevelSeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * We need to merge all overlapping intervals.
 * Given  - [1,3],[2,6],[8,10],[15,18]
 * Return - [1,6],[8,10],[15,18]
 * 
 * Basically two intervals can be called as overlapping if the start of one is less than or equal
 * to end of another 
 * e.g [1,3] [2,6] can be merged into [1,6]
 * 
 * The main idea here is to sort intervals by their start time merge the intervals which are overlapping.
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals){
		if(intervals.size() <= 1) return intervals;
		
		/**
		 * Sort on the basis of start time
		 */
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2){
				return o1.start - o2.start;
			}
		});
		
		List<Interval> result = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for(Interval interval : intervals){
			if(interval.start <= end){
				end = Math.max(interval.end , end); // Overlapping intervals, move the end if needed
			}else{ // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		result.add(new Interval(start, end));// Add the last interval
		return result;
	}
}


class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}