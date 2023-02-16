import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class MinAbsoluteDiff {
    // T.C: O(NlogN), Space Complexity: O(N)
    public List<List<Integer>> minimumAbsDifferenceUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        Arrays.sort(arr);

        // Finding the min abs diff possible for input arr
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            if(Math.abs(arr[i] - arr[i+1]) < minAbsDiff) {
                minAbsDiff = Math.abs(arr[i] - arr[i+1]);
            }
        }

        for(int j = 0; j < arr.length; j++) {
            if(!map.containsKey(Integer.valueOf(arr[j]))) {
                map.put(arr[j] - minAbsDiff, arr[j]);
                map.put(arr[j] + minAbsDiff, arr[j]);
            } else if(map.containsKey(Integer.valueOf(arr[j]))) {
                output.add(new ArrayList<Integer>(Arrays.asList(map.get(arr[j]), arr[j])));

                if(arr[j] - minAbsDiff == map.get(arr[j])) {
                    map.put(arr[j] + minAbsDiff, arr[j]);
                } else {
                    map.put(arr[j] - minAbsDiff, arr[j]);
                }
            }
        }
        return output;
    }

    // T.C: O(NlogN) and O(N) apart from Arrays.sort(), Space Complexity: O(1) 
    public List<List<Integer>> minimumAbsDifferenceWithoutUsingHashMap(int[] arr) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        Arrays.sort(arr);

        // Finding the min abs diff possible for input arr
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            if(Math.abs(arr[i] - arr[i+1]) < minAbsDiff) {
                minAbsDiff = Math.abs(arr[i] - arr[i+1]);
            }
        }

        for(int j = 0; j < arr.length - 1; j++) {
            if(Math.abs(arr[j] - arr[j+1]) == minAbsDiff) {
                output.add(new ArrayList<Integer>(Arrays.asList(arr[j], arr[j+1])));
            }
        }
        return output;
    }
}
