import java.util.Arrays;
import java.math.BigInteger;
import java.util.Comparator;

class LargestNumber {
    // T.C: O(NlogN), Space Complexity: O(N)
    public String largestNumber(int[] nums) {
        int countZeros = 0;
        for(int n : nums) {
            if(n == 0) {
                countZeros++;
            }
        }

        if(countZeros == nums.length) {
            return "0";
        }

        String[] s = new String[nums.length];
        String res = new String("");
        
        for(int i = 0; i < nums.length; i++) {
            String str = String.valueOf(nums[i]);
            s[i] = str;
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s2.compareTo(s1);
                } else {
                    // Using BigInteger to ensure values don't go out of Integer range
                    // and it's quite memory efficient too!
                    BigInteger b1 = new BigInteger(String.valueOf(s1 + s2));
                    BigInteger b2 = new BigInteger(String.valueOf(s2 + s1));
                    return b2.compareTo(b1);
                }
            }
        });

        for(String str : s) {
            res += str;
        }
        return res;
    }

    // T.C: O(NlogN), Space Complexity: O(N)
    public String largestNumberOptimized(int[] nums) {
        String[] s = new String[nums.length];
        String res = new String("");
        
        for(int i = 0; i < nums.length; i++) {
            String str = String.valueOf(nums[i]);
            s[i] = str;
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s2.compareTo(s1);
                } else {
                    // Using BigInteger to ensure values don't go out of Integer range
                    // and it's quite memory efficient too!
                    BigInteger b1 = new BigInteger(String.valueOf(s1 + s2));
                    BigInteger b2 = new BigInteger(String.valueOf(s2 + s1));
                    return b2.compareTo(b1);
                }
            }
        });

        if(s[0].charAt(0) == '0') {
            return "0";
        }

        for(String str : s) {
            res += str;
        }
        return res;
    }
}
