// Problem - https://leetcode.com/problems/koko-eating-bananas/

import java.util.Arrays;
import java.lang.Math;

// T.C - O(Nlog(maxVal - 1))
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        return minSpeed1(piles, h);
        // return minSpeed2(piles, h);
    }
    
    public static int minSpeed1(int[] piles, int h) {
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

    public static int minSpeed2(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(canEatBananas(piles, h, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    
    public static boolean canEatBananas(int[] piles, int h, int k) {
        int hr = 0;
        
        for(int i = 0; i<piles.length; i++) {
            if(piles[i] <= k) {
                hr ++;
            } else if(piles[i] % k == 0) {
                hr += (piles[i] / k);
            } 
            else if(piles[i] % k > 0) {
                hr += (piles[i] / k + 1);
            }
        }
        
        if(hr <= h) {
            return true;
        }
        return false;
    }
}
