// Problem:- https://www.spoj.com/problems/AGGRCOW/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// T.C - O(NlogN)
public class AgressiveCows {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(sc.readLine());
        for(int j = 1; j <= t; j++) {
            String[] stringInputs = sc.readLine().split(" ");
            int N = Integer.parseInt(stringInputs[0]);
            int C = Integer.parseInt(stringInputs[1]);
            int[] positions = new int[N];

            for(int i = 0; i<N; i++) {
                positions[i] = Integer.parseInt(sc.readLine());
            }
            System.out.println(solution(N, C, positions));
        }
    }

    public static int solution(int N, int C, int[] positions) {
        Arrays.sort(positions);

        int start = 1;
        int end = positions[N - 1] - positions[0];

        while(start < end) {
            int mid = start + (end - start)/2;

            if(isArrangementPossible(N, C, positions, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static boolean isArrangementPossible(int N, int C, int[] positions, int dist) {
        int coord = positions[0];
        int count = 1;
        
        for(int i = 1; i < positions.length; i++) {
            if(positions[i] - coord >= dist) {
                count++;
                coord = positions[i];
            }

            if(count == C) {
                return true;
            }
        }
        return false;
    }
}
