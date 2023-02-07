// Problem:- https://leetcode.com/problems/3sum/
// Best Solution:- https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

// T.C - O(N^2)
public class threeSumQues {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumSol(nums);
    }
    
    public static List<List<Integer>> threeSumSol(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum(outputList, nums, i+1, nums.length - 1, -nums[i]);
        }
        return outputList;
    }
    
    public static void twoSum(List<List<Integer>> outputList, int[] nums, int low, int high, int target) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        
        for(int i = low; i <= high; i++) {
            if(!map.containsKey(Integer.valueOf(nums[i]))) {
                map.put(target - nums[i], new Integer[]{nums[i], i});
            }
            else if(map.containsKey(Integer.valueOf(nums[i]))) {
                outputList.add(Arrays.asList(-target, nums[i], nums[map.get(Integer.valueOf(nums[i]))[1]]));
                while(i+1 <= high && nums[i] == nums[i+1]) i++;
            }
        }
    }
}