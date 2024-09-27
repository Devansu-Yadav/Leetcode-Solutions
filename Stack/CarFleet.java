package Stack;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class CarFleet {
    // T.C: O(nlogn), S.C: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new HashMap<>();
        int count = 1;

        for(int i = 0; i < position.length; i++) {
            map.put(position[i], (double)(target - position[i]) / speed[i]);
        }

        Arrays.sort(position);

        int refIdx = position.length - 1;
        for(int i = position.length - 2; i >= 0; i--) {
            if(map.get(position[i]) > map.get(position[refIdx])) {
                count++;
                refIdx = i;
            }
        }
        return count;
    }
}
