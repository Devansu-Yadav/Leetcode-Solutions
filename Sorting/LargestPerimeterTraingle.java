// Problem:- https://leetcode.com/problems/largest-perimeter-triangle/

import java.util.Arrays;
import java.util.Comparator;

public class LargestPerimeterTraingle {
    public int largestPerimeter(int[] nums) {
        return largePerimeter(nums);
    }
    
    public static boolean checkIfTraingle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }
    
    // Un-optimized solution
    public static int largePerimeter(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        
        for(int i = 0; i<nums.length - 2; i++) {
            if(checkIfTraingle(arr[i], arr[i+1], arr[i+2])) {
                return arr[i] + arr[i+1] + arr[i+2];
            }
        }
        return 0;
    }

    // Better Solution
    public static int largePerimeter2(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 1; i>1; i--) {
            if(checkIfTraingle(nums[i], nums[i-1], nums[i-2])) {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}
