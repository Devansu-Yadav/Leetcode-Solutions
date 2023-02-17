// T.C: O(max(arr)), Space Complexity: O(max(arr))
// Better Solution: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/solutions/661696/accepted-java-o-n-o-1-beats-100/

class MaxProductOfTwoElemsInArray {
    public int maxProduct(int[] nums) {
        int[] count = new int[1001];

        for(int n: nums) {
            count[n]++;
        }

        int j = count.length - 1;
        while(j >= 0) {
            if(count[j] != 0) {
                count[j]--;
                break;
            }
            j--;
        }

        int i = j;
        while(i >= 0) {
            if(count[i] != 0) {
                count[i]--;
                break;
            }
            i--;
        }
        return (i - 1)*(j - 1);
    } 
}
