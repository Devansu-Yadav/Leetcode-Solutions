import java.util.HashMap;

class CouplesHoldingHands {
    // T.C: O(N*N), Space Complexity: O(1)
    public int minSwapsCouplesWithoutHashMap(int[] row) {
        int i = 0;
        int swaps = 0;

        // Using modified form of Cycle sort to find minimum no of swaps
        while(i < row.length - 1) {
            int correct;
            if(row[i] % 2 == 0) {
                correct = row[i] + 1;
            } else {
                correct = row[i] - 1;
            }

            if(row[i+1] != correct) {
                swaps++;
                for(int j = i + 2; j < row.length; j++) {
                    if(row[j] == correct) {
                        swap(row, i+1, j);
                        break;
                    }
                }
            }
            i = i + 2;
        }
        return swaps;
    }

    // T.C: O(N), Space Complexity: O(N)
    public int minSwapsCouplesWithHashMap(int[] row) {
        int i = 0;
        int swaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int idx = 0; idx < row.length; idx++) {
            map.put(row[idx], idx);
        }

        // Using modified form of Cycle sort along with HashMap to find minimum no of swaps
        while(i < row.length - 1) {
            int correct;
            if(row[i] % 2 == 0) {
                correct = row[i] + 1;
            } else {
                correct = row[i] - 1;
            }

            if(row[i+1] != correct) {
                swaps++;
                if(map.containsKey(correct)) {
                    int correctIdx = map.get(correct);
                    swap(row, i+1, correctIdx);

                    // updating indexes of swapped elements in hashmap
                    map.put(row[correctIdx], correctIdx);
                    map.put(correct, i+1);
                }
            }
            i = i + 2;
        }
        return swaps;
    }

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
