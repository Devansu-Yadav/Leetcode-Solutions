import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;

// T.C: O(KlogK) where K is the no of unique elements in array, Space complexity: O(K)
// More optimized solution: https://leetcode.com/problems/rank-transform-of-an-array/solutions/489753/java-c-python-hashmap/
class RankTransformInArray {
    public int[] arrayRankTransformUsingSortedMap(int[] arr) {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        for(int elem: arr) {
            if(!map.containsKey(elem)) {
                map.put(elem, 0);
            }
        }

        int rank = 1;
        for(Map.Entry mapElem: map.entrySet()) {
            int key = (int)mapElem.getKey();
            map.put(key, rank);
            rank++;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
