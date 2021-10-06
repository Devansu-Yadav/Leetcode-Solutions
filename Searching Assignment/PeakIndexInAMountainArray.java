public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        return findPeakElement(arr);
    }
    
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
