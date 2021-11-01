// Problem - https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
import java.lang.Math;

public class MaxValueAtIndex {
    public int maxValue(int n, int index, int maxSum) {
        return maximizeValueArray(n, index, maxSum);
    }
    
    public static int maximizeValueArray(int n, int index, int maxSum) {
        maxSum -= n;
        int start = 0;
        int end = maxSum;
        
        while(start < end) {
            int mid = (start + end + 1)/2;
            boolean isPossible = isPossibleMaxValue(mid, index, maxSum, n);
            // System.out.println("Max Val - " + mid + " , IsPossible - " + isPossible);
            
            if(isPossible) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start + 1;
    }
    
    public static boolean isPossibleMaxValue(int val, int index, int maxSum, int n) {
        int firstElement = Math.max(val - index, 0);
        int lastElement = Math.max(val - (n-1-index), 0);
        
        long sum = (long)(val - firstElement + 1)*(firstElement + val)/2;
        sum += (long)(val - lastElement + 1)*(lastElement + val)/2;
        
        sum -= (long)val;
        
        if(sum <= maxSum) {
            return true;
        } 
        return false;
    }
}