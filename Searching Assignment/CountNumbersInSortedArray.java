// Problem:- https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/


public class CountNumbersInSortedArray {
    public int countNegatives(int[][] grid) {
        return countNegativeNos(grid);
    }
    
    public static int countNegativeNos(int[][] grid) {
        int count = 0;
        
        for(int i = 0; i<grid.length; i++) {
            int arr[] = grid[i];
            int indexOfSmallestPositiveNo = smallestPositiveNo(arr);
            // System.out.println("Index - " + indexOfSmallestPositiveNo);
            
            if(indexOfSmallestPositiveNo == -1) {
                count += arr.length;    
            } else {
                count += arr.length - (indexOfSmallestPositiveNo + 1);   
            }
        }
        return count;
    }
    
    public static int smallestPositiveNo(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(arr[mid] < 0) {
                end = mid - 1;
            } else if(arr[mid] >= 0) {
                if((mid + 1 <= end) && arr[mid + 1] < 0) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        if(end >= 0 && arr[end] >= 0) {
            return end;
        }
        return -1;
    }
}
