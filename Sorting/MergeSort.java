public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 12, 2, 34, 56, 100, 69, 5};
//        int[] res = mergeSort1(arr);
//
//        for (int n : res) {
//            System.out.print(n + " ");
//        }

        mergeSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortHelper(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid, temp);
        mergeSortHelper(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    public static int[] mergeSort1(int[] arr) {
        if(arr.length == 0 || arr.length == 1) {
            int[] temp = new int[arr.length];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            return temp;
        }

        int l = 0, r = arr.length - 1;
        int m = l + (r - l) / 2;

        int[] temp = new int[m - l + 1];
        System.arraycopy(arr, l, temp, 0, m-l+1);

        int[] arr1 = mergeSort1(temp);

        System.arraycopy(arr, m+1, temp, 0, r-m);
        int[] arr2 = mergeSort1(temp);

        return mergeArrays(arr1, arr2);
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int l = 0, r = 0, i = 0;

        while(l < a.length && r < b.length) {
            if(a[l] < b[r]) {
                res[i++] = a[l];
                l++;
            } else {
                res[i++] = b[r];
                r++;
            }
        }

        while(l < a.length) {
            res[i++] = a[l];
            l++;
        }

        while(r < b.length) {
            res[i++] = b[r];
            r++;
        }
        return res;
    }
}
