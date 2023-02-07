// Problem:- https://curiouschild.github.io/leetcode/2019/06/21/divide-chocolate.html
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// T.C - O(Nlog(sum - min))
public class DivideChocolate {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("No of friends - ");
        int k = Integer.parseInt(sc.readLine());

        String[] inputStr = sc.readLine().split(" ");
        int sweetness[] = new int[inputStr.length];

        int i = 0;
        for(String s: inputStr) {
            sweetness[i] = Integer.parseInt(s);
            i++;
        }

        System.out.println("Maximum total sweetness of Piece I get - " + divideChocolate(sweetness, k));
    }

    public static int divideChocolate(int[] sweetness, int k) {
        if(sweetness.length == k+1) {
            return Arrays.stream(sweetness).min().getAsInt();
        }

        int start = Arrays.stream(sweetness).min().getAsInt();
        int end = Arrays.stream(sweetness).sum();
        int ans = 0;

        while(start < end) {
            int mid = start + (end - start)/2;
            int currentPieces = currentPiecesPossible(sweetness, mid);

            if(currentPieces >= k + 1) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Sum for partition possible - " + ans);
        int minSweetnessVal = Integer.MAX_VALUE;
        int currentSum = 0;
        for(int i = 0; i<sweetness.length; i++) {
            if(currentSum + sweetness[i] <= ans) {
                currentSum += sweetness[i];
            } else {
                minSweetnessVal = Math.min(currentSum, minSweetnessVal);
                currentSum = sweetness[i];
            }
        }

        return minSweetnessVal;
    }

    public static int currentPiecesPossible(int[] sweetness, int m) {
        int currentSum = 0;
        int partitions = 0;

        for(int i = 0; i<sweetness.length; i++) {
            if(sweetness[i] + currentSum <= m) {
                currentSum += sweetness[i];
            } else if(sweetness[i] + currentSum > m) {
                partitions ++;
                currentSum = sweetness[i];
            }
        }
        return partitions + 1;
    }
}
