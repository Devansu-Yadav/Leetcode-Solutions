import java.util.HashMap;
import java.lang.Math;

// T.C and Space Complexity: Depends on the input number
// Better Solution using Fast and Slow pointers: https://leetcode.com/problems/happy-number/solutions/519280/java-100-using-cycle-finding-algorithm/
class HappyNumber {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(!map.containsKey(n)) {
            if(n == 1) {
                return true;
            }
            map.put(n, null);
            n = sumOfSquaresOfDigits(n);
        }
        return false;
    }

    public static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}
