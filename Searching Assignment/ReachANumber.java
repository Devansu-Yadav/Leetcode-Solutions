// Problem - https://leetcode.com/problems/reach-a-number/

import java.lang.Math;

class ReachANumber {
    public int reachNumber(int target) {
        return reachDest(target);
    }
    
    public static int reachDest(int target) {
        int dest = Math.abs(target);
        int stepSum = 0, steps = 0;
        
        while(stepSum < dest) {
            steps++;
            stepSum += steps;
        }
        
        while((stepSum - dest)% 2 != 0) {
            steps++;
            stepSum += steps;
        }
        return steps;
    }
}