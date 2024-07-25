package sort;

/**
 * Records
 * Merge sort: record: 04:34
 * Insert sort: record: 01:34
 */
public class Training {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 7, 4, 2, 9, 8, 5, 3};
        MergeSort sorting = new MergeSort();
        sorting.sort(arr);
        sorting.print(arr);
    }

    private static class InsertSort extends AbstractSort {
        public void sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                int j = i + 1;
                int temp = list[j];
                while (j > 0 && list[j - 1] > temp) {
                    list[j] = list[j - 1];
                    j--;
                }
                list[j] = temp;
            }
        }
    }

    private static class MergeSort extends AbstractSort {
        public void sort(int[] list) {
            mergeSort(list, 0, list.length - 1);
        }

        public void mergeSort(int[] list, int startIdx, int endIdx) {
            if (startIdx >= endIdx) return;

            int midIdx = (startIdx + endIdx) / 2;

            mergeSort(list, startIdx, midIdx);
            mergeSort(list, midIdx + 1, endIdx);

            merge(list, startIdx, midIdx, endIdx);

        }

        public void merge(int[] list, int startIdx, int midIdx, int endIdx) {
            int leftArrSize = midIdx - startIdx + 1;
            int rightArrSize = endIdx - midIdx;

            int[] leftArr = new int[leftArrSize];
            int[] rightArr = new int[rightArrSize];

            for (int i = 0; i < leftArrSize; i++) {
                leftArr[i] = list[i + startIdx];
            }
            for (int i = 0; i < rightArrSize; i++) {
                rightArr[i] = list[i + midIdx + 1];
            }

            int i = 0, j = 0, k = startIdx;
            while (i < leftArrSize && j < rightArrSize) {
                if (leftArr[i] < rightArr[j]) {
                    list[k] = leftArr[i];
                    i++;
                } else {
                    list[k] = rightArr[j];
                    j++;
                }
                k++;
            }
            while (j < rightArrSize) {
                list[k] = rightArr[j];
                j++;
                k++;
            }
            while (i < leftArrSize ) {
                list[k] = leftArr[i];
                i++;
                k++;
            }
        }
    }
}
