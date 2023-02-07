// Problem:- https://leetcode.com/problems/4sum/
// Optimal Solution(Better Space complexity):- https://leetcode.com/problems/4sum/discuss/8547/7ms-java-code-win-over-100

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

// T.C:- O(N^3) --> Bad Solution (Least Optimized enough to pass all testcases)
public class fourSumSol {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSumSol(nums, target);
    }
    
    public static List<List<Integer>> fourSumSol(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            threeSum(list, nums, i+1, nums.length - 1, target - nums[i], nums[i]);
        }
        return list;
    }
    
    public static void threeSum(List<List<Integer>> outputList, int[] nums, int low, int high, int target, int firstElem) {
       for(int i = low; i <= high - 2; i++) {
            twoSum(outputList, nums, i+1, nums.length - 1, target - nums[i], firstElem, nums[i]);
        } 
    }
    
    public static void twoSum(List<List<Integer>> outputList, int[] nums, int low, int high, int target, int fourSumElem, int firstElem) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        
        for(int i = low; i <= high; i++) {
            if(!map.containsKey(Integer.valueOf(nums[i]))) {
                map.put(target - nums[i], new Integer[]{nums[i], i});
            }
            else if(map.containsKey(Integer.valueOf(nums[i]))) {
                if(!outputList.contains(Arrays.asList(fourSumElem, firstElem, nums[i], nums[map.get(Integer.valueOf(nums[i]))[1]]))) {
                 outputList.add(Arrays.asList(fourSumElem, firstElem, nums[i], nums[map.get(Integer.valueOf(nums[i]))[1]]));   
                }
                while(i+1 <= high && nums[i] == nums[i+1]) i++;
            }
        }
    }
}
