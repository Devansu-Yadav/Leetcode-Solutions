import java.util.*;

public class IntersectionOfArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        return intersectionOfArrays(nums1, nums2);
    }
    
    public static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums1.length; i++) {
            int elementIndex;
            if(!map.containsKey(nums1[i])) {
                elementIndex = isInArray(nums2, nums1[i], 0);
            } else {
                elementIndex = isInArray(nums2, nums1[i], map.get(nums1[i]) + 1);
            }
            
            if(elementIndex != -1) {
                output.add(Integer.valueOf(nums1[i]));
                map.put(nums1[i], elementIndex);
            }
            // System.out.println("Map - " + map.toString());
        }
        
        Integer[] outputArr = new Integer[output.size()];
        outputArr = output.toArray(outputArr);
        int[] answerArr = Arrays.stream(outputArr).mapToInt(Integer::intValue).toArray();
        return answerArr;
    }
    
    public static int isInArray(int[] nums2, int target, int start) {
        int end = nums2.length - 1;
        int startIndex = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums2[mid] == target) {
                startIndex = mid;
                end = mid - 1;
            } else if(nums2[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return startIndex;
    }
}
