import java.util.PriorityQueue;
import java.util.Comparator;

// T.C: O(nlogn), Space Complexity: O(n)
class SortByCountOfOneBits {
    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(arr.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    int bitsCountForA = countOneBits(a);
                    int bitsCountForB = countOneBits(b);

                    if(bitsCountForA == bitsCountForB) {
                        return a - b;
                    }
                    return bitsCountForA - bitsCountForB;
                }
            }
        );

        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        for(int j = 0; j < result.length; j++) {
            int num = queue.poll();
            result[j] = num;
        }
        return result;
    }

    public static int countOneBits(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
