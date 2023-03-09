class FlippingAnImage {
    // T.C: O(N^2), Space Complexity: O(1)
    public int[][] flipAndInvertImage(int[][] image) {
        int r = image.length;

        for(int i = 0; i < r; i++) {
            reverseAndInvert(image[i]);
        }
        return image;
    }

    public void reverseAndInvert(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            // first invert both elements
            arr[i] = toggle(arr[i]);
            arr[j] = toggle(arr[j]);

            // Now swap both elements.
            swap(arr, i, j);
            i++;
            j--;
        }

        if(i == j) {
            arr[i] = toggle(arr[i]);
        }
    }

    public static int toggle(int val) {
        return val == 0 ? 1: 0;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // T.C: O(N^2), Space Complexity: O(1)
    public int[][] flipAndInvertImageBetterSol(int[][] image) {
        int r = image.length;

        for(int i = 0; i < r; i++) {
            reverseAndInvertOptimized(image[i]);
        }
        return image;
    }

    public void reverseAndInvertOptimized(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            // if arr[i] == arr[j], just toggle/invert them.
            if(arr[i] == arr[j]) {
                arr[i] = toggle(arr[i]);
                arr[j] = toggle(arr[j]);
            }
            // No need to do anything if arr[i] != arr[j], 
            // since reversing and inverting will not change their values.
            i++;
            j--;
        }

        if(i == j) {
            arr[i] = toggle(arr[i]);
        }
    }
}
