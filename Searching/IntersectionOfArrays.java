import java.util.*;

public class IntersectionOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        return intersectionOfArrays(nums1, nums2);
    }
    
    public static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        Set<Integer> output = new HashSet<Integer>();
        
        for(int i = 0; i<nums1.length; i++) {
            if(!output.contains(nums1[i])) {
                boolean inArray = isInArray(nums2, nums1[i]);
            
                if(inArray) {
                    output.add(Integer.valueOf(nums1[i]));
                }  
            }
        }
        
        Integer[] outputArr = new Integer[output.size()];
        outputArr = output.toArray(outputArr);
        int[] answerArr = Arrays.stream(outputArr).mapToInt(Integer::intValue).toArray();
        return answerArr;
    }
    
    public static boolean isInArray(int[] nums2, int target) {
        int start = 0;
        int end = nums2.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums2[mid] == target) {
                return true;
            } else if(nums2[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
