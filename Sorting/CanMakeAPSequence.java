import java.util.Arrays;
import java.lang.Math;

// T.C: O(NlogN), Space Complexity: O(1)\
// Another approach using HashSet - https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/solutions/1836976/intuitive-explained-solutions-o-n-o-nlogn-codes/
class CanMakeAPSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int diff = Math.abs(arr[0] - arr[1]);
        for(int i = 1; i < arr.length - 1; i++) {
            if(diff != Math.abs(arr[i] - arr[i+1])) {
                return false;
            }
        }
        return true;
    } 
}
