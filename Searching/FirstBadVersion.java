// https://leetcode.com/problems/first-bad-version

public class FirstBadVersion {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while(true) {
            int mid = start + (end - start)/2;
            if(!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                if(!isBadVersion(mid - 1)) {
                   return mid; 
                }
                end = mid - 1;
            }
        }
    }
}
