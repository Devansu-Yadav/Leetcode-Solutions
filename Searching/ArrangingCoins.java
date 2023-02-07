// Problem:- https://leetcode.com/problems/arranging-coins/

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return completeRows((long) n);
    }
    
    public static int completeRows(long n) {
        if(n == 1) {
            return 1;
        }
        
        long start = 1;
        long end = n/2 + 1;
        
        while(start < end) {
            long mid = start + (end - start)/2;
            boolean isArrangeableCoins = isArrangeable(n, mid);
            if(isArrangeableCoins) {
                end = mid;
            } else if(!isArrangeableCoins) {
                start = mid + 1;
            }   
        }
        
        if(n < totalArrangeableCoins(end)) {
            return (int)end - 1;
        } 
        return (int)end;
    }
    
    public static boolean isArrangeable(long n, long rows) {
        if(n <= totalArrangeableCoins(rows)) {
            return true;
        }
        return false;
    }
    
    public static long totalArrangeableCoins(long rows) {
        long totalNoOfCoins = (rows*(rows+1))/2;
        return totalNoOfCoins;
    }    
}
