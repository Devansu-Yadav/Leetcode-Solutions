// Problem:- https://leetcode.com/problems/merge-sorted-array

// T.C:- O(m+n)
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeSortedArrays(nums1, nums2, m, n);
    }
    
    public static void mergeSortedArrays(int nums1[], int nums2[], int m, int n) {
        int i = 0;
        int j = 0;
        int countNums1 = 1;
        
        while(countNums1 <= m && j < n) {
            if(nums1[i] <= nums2[j]) {
                i++;
                countNums1++;
            } else {
                shiftElemsArr(nums1, i);
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
        
        while(i < nums1.length && j < n) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }
    
    public static void shiftElemsArr(int arr[], int currentIndex) {
        for(int i = arr.length - 2; i>=currentIndex; i--) {
            arr[i+1] = arr[i];
        }
    }
}
