// Problem:- https://leetcode.com/problems/third-maximum-number/
// Better solution:- https://leetcode.com/problems/third-maximum-number/discuss/90202/Java-neat-and-easy-understand-solution-O(n)-time-O(1)-space

import java.util.Arrays;
import java.util.TreeSet;
import java.util.List;

// T.C - O(NlogN), S.C:- O(N)
// Naive but pure use of Built-ins
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        return findThirdMax(nums);
    }
    
    public static int findThirdMax(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        Arrays.sort(nums);
        
        int maxElement = nums[nums.length - 1];
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(arr);
        
        TreeSet<Integer> firstMaxSet = new TreeSet<Integer>(list.subList(0, list.indexOf(maxElement)));
        
        int secondMaximum = firstMaxSet.size() == 0 ? maxElement : firstMaxSet.floor(maxElement);
        System.out.println("Second Max - " + secondMaximum);
        
        TreeSet<Integer> secondMaxSet = new TreeSet<Integer>();
        secondMaxSet = (TreeSet<Integer>)firstMaxSet.headSet(secondMaximum);
        
        int thirdMaximum = secondMaxSet.size() == 0 ? maxElement : secondMaxSet.floor(secondMaximum);
        
        System.out.println("Third Max - " + thirdMaximum);
        return thirdMaximum;
    }
}
