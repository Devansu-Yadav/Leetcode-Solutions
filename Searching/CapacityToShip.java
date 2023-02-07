// Problem:- https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Solution:- https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search

import java.util.Arrays;

public class CapacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        return shipCapacity(weights, days);
    }
    
    public static int shipCapacity(int[] weights, int days) {
        int start = Arrays.stream(weights).max().getAsInt();
        int end = Arrays.stream(weights).sum();
        
        while(start < end) {
            int mid = start + (end - start)/2;
            int neededDays = daysRequiredToShip(weights, mid, days);
            
            if(neededDays > days) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    public static int daysRequiredToShip(int[] weights, int capacity, int days) {
        int neededDays = 1, currentWt = 0;
        
        for(int i = 0; i<weights.length; i++) {
            if(currentWt + weights[i] > capacity) {
                neededDays += 1;
                currentWt = 0;
            }
            currentWt += weights[i];
        }
        return neededDays;
    }
}