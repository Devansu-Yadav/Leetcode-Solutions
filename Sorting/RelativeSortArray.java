// Uses concept of count sort
// TC: O(n1) where n1 is the length of arr1
// Space Complexity: O(max(arr1))
class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length];
        int max = findMax(arr1);
        int[] count = new int[max+1];

        // store counts of elements in arr1
        for(int i = 0; i < arr1.length; i++) {
            count[arr1[i]] += 1;
        }

        int k = 0;
        // Sorting all elements of arr2 in arr1
        for(int j = 0; j < arr2.length; j++) {
            while(count[arr2[j]] > 0) {
                output[k] = arr2[j];
                k++;
                count[arr2[j]]--;
            }
        }

        // Sorting elements not in arr2
        for(int l = 0; l < count.length; l++) {
            while(count[l] > 0) {
                output[k] = l;
                k++;
                count[l]--;
            }
        }
        return output;
    }

    public static int findMax(int[] arr) {
        int max = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }    
}
