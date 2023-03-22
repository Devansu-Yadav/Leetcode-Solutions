import java.util.List;
import java.util.ArrayList;

// Better Sol:- https://leetcode.com/problems/pancake-sorting/solutions/494417/dew-it-true-o-n-explained-with-diagrams/
class PancakeSorting {
    // TC:- O(N^2) & 2*N flips, Space Complexity: O(1)
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        int largest = arr.length;
        for(int i = 0; i < arr.length; i++) {
            // find index of largest element in array.
            int index = findIdx(arr, largest);

            // first flip the largest elem to start
            reverseSubArr(arr, index);
            // then flip it to its correct pos from the end of array
            reverseSubArr(arr, largest - 1);

            res.add(index + 1);
            res.add(largest);

            // pick next largest number in arr as it
            // contains elements from 1 to N.
            largest--;
        }
        return res;
    }

    public static int findIdx(int[] arr, int elem) {
        int idx = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == elem) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void reverseSubArr(int[] arr, int idx) {
        int i = 0;
        int j = idx;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
