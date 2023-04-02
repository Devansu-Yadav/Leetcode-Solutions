import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

// T.C: O(NlogN), Space Complexity: O(1)
// Better Solutions: https://leetcode.com/problems/find-k-closest-elements/solutions/202785/very-simple-java-o-n-solution-using-two-pointers/ ,
// https://leetcode.com/problems/find-k-closest-elements/solutions/106426/java-c-python-binary-search-o-log-n-k-k/


class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        if(x < arr[0]) {
            // adding first k elements since x is smaller than 
            // all elements within the array.
            for(int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if(x > arr[arr.length - 1]) {
            // adding k elements from the end of the array, 
            // since x > all elements in the array.
            for(int i = arr.length - 1; i >= arr.length - k; i--) {
                res.add(arr[i]);
            }
        } 
        else {
            // x lies within the range of the array.
            int left = 0, right = arr.length - 1;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(arr[mid] == x) {
                    addKClosestElements(res, mid, mid, arr, k, x);
                    break;
                } else if(arr[mid] < x && arr[mid + 1] > x) {
                    addKClosestElements(res, mid, mid + 1, arr, k, x);
                    break;
                } else if(arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void addKClosestElements(List<Integer> res, int l, int r, int[] arr, int k, int x) {
        while(l >= 0 && r < arr.length && k > 0) {
            if(l == r) {
                res.add(arr[l]);
                l--;
                r++;
            } else if(Math.abs(arr[l] - x) <= Math.abs(arr[r] - x) && arr[l] <= arr[r]) {
                res.add(arr[l]);
                l--;
            } else {
                res.add(arr[r]);
                r++;
            }
            k--;
        }

        // add remaining closest elements
        while(k > 0 && l >= 0) { 
            res.add(arr[l]);
            l--;
            k--;
        }

        while(k > 0 && r < arr.length) {
            res.add(arr[r]);
            r++;
            k--;
        }
    }
}
