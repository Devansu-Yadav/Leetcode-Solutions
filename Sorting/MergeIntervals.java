import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

// T.C: O(NlogN), Space Complexity: O(N)
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] newInterval = intervals[0];
        for(int j = 1; j < intervals.length; j++) {
            if(intervals[j][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[j][1]);
            } else {
                list.add(newInterval);
                newInterval = intervals[j];
            }
        }
        // Add the final mergeable interval or unmergeable interval
        list.add(newInterval);

        int[][] output = new int[list.size()][2];
        output = list.toArray(output);
        return output;
    }
}