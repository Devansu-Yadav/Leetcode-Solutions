public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakElementIndex = findPeakElement(mountainArr);
        System.out.println("Peak Index " + peakElementIndex);
        
        if(mountainArr.get(peakElementIndex) == target) {
            return peakElementIndex;
        }
        int left = binarySearch(mountainArr, target, 0, peakElementIndex - 1);
        if(left == -1) {
            return binarySearch(mountainArr, target, peakElementIndex + 1, mountainArr.length() - 1);
        }
        return left;
    }
    
    public static int binarySearch(MountainArray mountainArr, int target, int start, int end) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(target == mountainArr.get(mid)) {
                return mid;
            }
            
            if(isAsc) {
               if(target > mountainArr.get(mid)) {
                    start = mid + 1;
                } else if(target < mountainArr.get(mid)) {
                    end = mid - 1;
                } 
            } else {
                if(target > mountainArr.get(mid)) {
                    end = mid - 1;
                } else if(target < mountainArr.get(mid)) {
                    start = mid + 1;
                }    
            }
        }
        return -1;
    }
    
    public static int findPeakElement(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
