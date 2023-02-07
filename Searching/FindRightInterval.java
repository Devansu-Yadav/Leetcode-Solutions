// Problem:- https://leetcode.com/problems/find-right-interval/
// Optimized Solution using TreeMap - https://leetcode.com/problems/find-right-interval/discuss/91789/Java-clear-O(n-logn)-solution-based-on-TreeMap

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        return rightInterval(intervals); 
     }
     
     public static int[] rightInterval(int[][] intervals) {
         ArrayList<Integer> arr = new ArrayList<>();
         int[] output = new int[intervals.length];
         HashMap<Integer, Integer> m = new HashMap<>();
         
         for(int i = 0; i<intervals.length; i++) {
             m.put(intervals[i][0], i);
             arr.add(intervals[i][0]);
         }
         
         Collections.sort(arr);
         
         // System.out.println("Map " + m.toString());
         System.out.println("Start Intervals array " + arr.toString());
         
         for(int i = 0; i<intervals.length; i++) {
             int rightInterval = binarySearch(arr, intervals[i][1]);
             
             System.out.println("Right Interval - " + rightInterval);
             
             if(rightInterval != Integer.MIN_VALUE) {
                 output[i] = m.get(rightInterval);
             } else {
                 // System.out.println("Failed for - " + "[" + intervals[i][0] + ", " + intervals[i][1]  + "]");
                 output[i] = -1;
             }
         }
         // System.out.println("Output " + output.toString());
         return output;
     }
     
     public static int binarySearch(ArrayList<Integer> arr, int target) {
         int start = 0;
         int end = arr.size() - 1;
         
         while(start <= end) {
             int mid = start + (end - start)/2;
             // System.out.println("Target " + target);
             // System.out.println("Condition " + (arr.get(mid).intValue() >= target && arr.get(mid - 1).intValue() < target));
             
             if(mid == start && arr.get(mid).intValue() >= target) {
                 return arr.get(mid).intValue();
             } else if(mid - 1 >= start && (arr.get(mid).intValue() >= target && arr.get(mid - 1).intValue() < target)) {
                 return arr.get(mid).intValue();
             }
             else if(arr.get(mid).intValue() < target) {
                 start = mid + 1;
             } else {
                 end = mid;
             }
         }
         return Integer.MIN_VALUE;
     }
}
