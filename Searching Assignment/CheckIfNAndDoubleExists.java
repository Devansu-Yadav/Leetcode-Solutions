import java.util.*;


public class CheckIfNAndDoubleExists {
    public boolean checkIfExist(int[] arr) {
        return checkDouble(arr);
    }
    
    public static boolean checkDouble(int[] arr) {
        Map <Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length; i++) {
            if(map.containsKey(2*arr[i]) || (arr[i] % 2 == 0 && map.containsKey(arr[i]/2))) {
                return true;
            }
            map.put(arr[i], 2*arr[i]);
        }
        return false;
    }
}