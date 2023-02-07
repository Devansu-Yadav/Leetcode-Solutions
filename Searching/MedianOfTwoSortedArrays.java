// Problem:- https://leetcode.com/problems/median-of-two-sorted-arrays
// Best Solution - 

// T.C - O(n+m)
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianOfSortedArrays(nums1, nums2);
    }
    
    public double findMedianOfSortedArrays(int[] nums1, int[] nums2) {
        int medLeft = 0;
        int medRight = 0;
        int index1 = 0;
        int index2 = 0;
        
        for(int i = 0; i<=(nums1.length + nums2.length)/2; i++) {
            medLeft = medRight;
            
            if(index1 == nums1.length) {
                medRight = nums2[index2];
                index2++;
            } else if(index2 == nums2.length) {
                medRight = nums1[index1];
                index1++;
            } else if(nums1[index1] < nums2[index2]) {
                medRight = nums1[index1];
                index1++;
            } else {
                medRight = nums2[index2];
                index2++;
            }
        }
        
        if((nums1.length + nums2.length) % 2 == 0) {
            return ((double)(medLeft + medRight))/2;
        }
        
        return (double)medRight;
    }
}
