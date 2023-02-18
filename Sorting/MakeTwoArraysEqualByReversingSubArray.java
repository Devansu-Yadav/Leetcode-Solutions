import java.util.HashMap;

class MakeTwoArraysEqualByReversingSubArray {
    // T.C: O(N), Space Complexity: O(N)
    public boolean canBeEqualWithHashMap(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < target.length; i++) {
            if(map.containsKey(target[i])) {
                map.put(target[i], map.get(target[i])+1);
            } else {
                map.put(target[i], 1);
            }
        }

        for(int j = 0; j < arr.length; j++) {
            if(!map.containsKey(arr[j]) || map.get(arr[j]) == 0) {
                return false;
            }
            map.put(arr[j], map.get(arr[j])-1);
        }
        return true;
    }

    public boolean canBeEqualByReversingSubArray(int[] target, int[] arr) {
        for(int i = 0; i < target.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == target[i]) {
                    reverseSubArray(arr, i, j);
                    break;
                } else if(j == arr.length - 1) { // 'j' reached the end so couldn't reverse.
                    return false;
                }
            }
        }
        return true;
    }

    // T.C: Worst case - approx O(N^2), Best case - O(N), Space Complexity: O(1)
    public static void reverseSubArray(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
