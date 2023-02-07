// Problem - https://leetcode.com/problems/fair-candy-swap/

import java.util.stream.*;
import java.lang.Math;
import java.util.Arrays;

class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = IntStream.of(aliceSizes).sum();
        int bobSum = IntStream.of(bobSizes).sum();
        int output[] = new int[2];
        
        int smallerArray[];
        int searchArray[];
        
        if(aliceSum < bobSum) {
            smallerArray = aliceSizes;
            Arrays.sort(bobSizes);
            searchArray = bobSizes;
        } else {
            smallerArray = bobSizes;
            Arrays.sort(aliceSizes);
            searchArray = aliceSizes;
        }
        
        int diff =  Math.abs(aliceSum - bobSum)/2;
        
        for(int i = 0; i<smallerArray.length; i++) {
            int elementFound = searchElement(searchArray, smallerArray[i], diff);
            if(elementFound != -1) {
                if(aliceSum < bobSum) {
                    output[0] = smallerArray[i];
                    output[1] = elementFound;
                } else {
                    output[0] = elementFound;
                    output[1] = smallerArray[i];
                }
                break;
            }
        }
        return output;
    }
    
    public static int searchElement(int[] searchArr, int target, int diff) {
        int start = 0;
        int end = searchArr.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            int searchdiff = searchArr[mid] - target;
            
            if(searchdiff == diff) {
                return searchArr[mid];
            } else if(searchdiff < diff || searchdiff < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }    
}
