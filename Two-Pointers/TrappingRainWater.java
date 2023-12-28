public class TrappingRainWater {
    public int trap(int[] height) {
        return calcAmt(height);
    }

    // T.C: O(N), Space Complexity: O(N)
    public static int calcAmt(int[] height) {
        int sum = 0;

        int currMaxHt = 0;
        int maxHtLeft[] = new int[height.length];
        int maxHtRight[] = new int[height.length];

        for(int i = 0; i < height.length; i++) {
            maxHtLeft[i] = currMaxHt;
            currMaxHt = Math.max(currMaxHt, height[i]);
        }

        currMaxHt = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            maxHtRight[i] = currMaxHt;
            currMaxHt = Math.max(currMaxHt, height[i]);
        }

        for(int i = 1; i < height.length - 1; i++) {
            int trappedWaterAmt = Math.min(maxHtLeft[i], maxHtRight[i]) - height[i];
            if(trappedWaterAmt > 0) {
                sum += trappedWaterAmt;
            }
        }
        return sum;
    }

    // T.C: O(N), Space Complexity: O(1)
    public static int calcAmtWithTwoPointers(int[] height) {
        int sum = 0, currWaterAmt = 0;
        int l = 0, r = height.length - 1;
        int maxHtLeft = height[l];
        int maxHtRight = height[r];

        while(l < r) {
            if(maxHtLeft <= maxHtRight) {
                l++;
                currWaterAmt = maxHtLeft - height[l];
                maxHtLeft = Math.max(maxHtLeft, height[l]);
            } else {
                r--;
                currWaterAmt = maxHtRight - height[r];
                maxHtRight = Math.max(maxHtRight, height[r]);
            }

            if(currWaterAmt > 0) {
                sum += currWaterAmt;
            }
        }
        return sum;
    }
}
