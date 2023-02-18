import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

class SortArrayByIncreasingFrequency {
    // T.C: O(N^2), Space Complexity: O(N)
    public int[] frequencySort(int[] nums) {
        int[] output = new int[nums.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    int freqA = frequency(nums, a);
                    int freqB = frequency(nums, b);

                    if(freqA == freqB) {
                        return b - a;
                    }
                    return freqA - freqB;
                }
            }
        );

        for(int elem : nums) {
            queue.add(elem);
        }

        for(int i = 0; i < output.length; i++) {
            output[i] = queue.poll();
        }
        return output;
    }

    // T.C: O(NlogN), Space Complexity: O(N)
    public int[] frequencySortOptimized(int[] nums) {
        int[] output = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    int freqA = map.get(a);
                    int freqB = map.get(b);

                    if(freqA == freqB) {
                        return b - a;
                    }
                    return freqA - freqB;
                }
            }
        );

        for(int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
    
        for(int elem : nums) {
            queue.add(elem);
        }

        for(int i = 0; i < output.length; i++) {
            output[i] = queue.poll();
        }
        return output;
    }

    public static int frequency(int[] arr, int elem) {
        int count = 0;
        for(int n : arr) {
            if(n == elem) {
                count++;
            }
        }
        return count;
    }
}
