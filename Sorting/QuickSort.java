public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 12, 2, 34, 56, 100, 69, 5};
        quickSort(arr, 0, arr.length - 1);

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(arr.length == 0 || arr.length == 1) {
            return;
        }

        if(l < r) {
            int idx = partition(arr, l, r);
            quickSort(arr, l, idx - 1);
            quickSort(arr, idx + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int m = l + (r - l) / 2;
        int p = arr[m];

        swap(arr, m, r);

        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(arr[j] <= p) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}