package sort.timsort;

import sort.AbstractSort;

public class TimSort extends AbstractSort {
    private static final int RUN = 4;

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 7, 4, 2, 9, 8, 5, 3};
        TimSort sortClass = new TimSort();
        sortClass.sort(arr);
        sortClass.print(arr);
    }

    private void sort(int[] arr) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i += RUN) {
            insertSort(arr, i, Math.min((i + RUN - 1), (arrLength - 1)));
        }
    }

    private void insertSort(int[] arr, int startIdx, int endIdx) {
        for (int i = startIdx; i < endIdx; i++) {
            int j = i + 1;
            int temp = arr[j];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println();
    }
}
