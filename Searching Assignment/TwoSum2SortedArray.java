// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

public class TwoSum2SortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int outputArr[] = new int[2];
        
        for(int i = 0; i<numbers.length; i++) {
            int searchedNoIndex = binarySearch(numbers, i+1, numbers.length-1, target - numbers[i]);
            if(searchedNoIndex != -1) {
                outputArr[0] = i+1;
                outputArr[1] = searchedNoIndex+1;
                break;
            }
        }
        return outputArr;
    }
    
    public static int binarySearch(int[] arr, int start, int end, int targetNo) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(arr[mid] == targetNo) {
                return mid;
            }
            else if(arr[mid] < targetNo) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
