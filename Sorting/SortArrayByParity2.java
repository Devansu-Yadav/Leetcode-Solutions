// Problem:- https://leetcode.com/problems/sort-array-by-parity-ii/

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        return sortArrByParity(nums);
    }
    
    // Sorting Array by creating a New Array
    public static int[] sortArrByParity(int[] nums) {
        int newArr[] = new int[nums.length];
        
        int evenIndex = 0;
        int oddIndex = evenIndex + 1;
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] % 2 == 0) {
                newArr[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                newArr[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        
        return newArr;
    }

    public static void swapNos(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // Sorting Array in-place
    public static int[] sortArrByParityInPlace(int[] nums) {
        int evenIndex = 0;
        int oddIndex = evenIndex + 1;
        
        for(int i = 0; i<nums.length; i++) {
            if(evenIndex >= nums.length || oddIndex >= nums.length) {
                break;
            }
            
            if(nums[evenIndex] % 2 == 0 && nums[oddIndex] % 2 != 0) {
                evenIndex += 2;
                oddIndex += 2;
            } else if(nums[evenIndex] % 2 != 0 && nums[oddIndex] % 2 == 0) {
                swapNos(evenIndex, oddIndex, nums);
            } else if(nums[evenIndex] % 2 == 0 && nums[oddIndex] % 2 == 0) {
                evenIndex += 2;
            } else {
                oddIndex += 2;
            }
        }
        return nums;
    }
}
