import java.lang.Math;

// T.C: O(N), Space Complexity: O(1)
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        // Having one pointer at the start of the array & one at the end,
        // we start with the widest container. As the pointers move closer to each other width will
        // decrease. 
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while(i < j) {
            // Since container can only be 2-dimensional acc to ques, we use area of rect formula
            // with breadth=min height out of the selected two lines.
            maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            
            // Smallest line must be removed as it does not have the capacity to form
            // a container to hold more water, given that the width of the container is decreasing.
            if(height[i] < height[j]) {
                i++;
            } else if(height[j] < height[i]) {
                j--;
            } else {
                // if both lines have equal height, we can move both pointers closer.
                i++;
                j--;
            }
        }
        return maxArea;
    }
}
