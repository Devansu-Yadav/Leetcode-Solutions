// Problem - https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositiveNo {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] <= k) {
                k++;
            }
            i++;
        }
        return k;
    }
}