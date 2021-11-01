// Problem - https://leetcode.com/problems/koko-eating-bananas/
import java.util.Arrays;
import java.lang.Math;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        return minSpeed(piles, h);
    }
    
    public static int minSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        
        while(start < end) {
            int k = start + (end - start)/2;
            int hr = 0;
            
            for(int p: piles) {
                hr += Math.ceil(p*1.0 / k);
            }
            
            if(hr > h) {
               start = k + 1;
            } else {
                end = k;
            }
        }
        return start;
    }
}
