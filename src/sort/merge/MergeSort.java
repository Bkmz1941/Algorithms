package sort.merge;

import sort.AbstractSort;

public class MergeSort extends AbstractSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 7, 4, 2, 9, 8, 5, 3};
        MergeSort sortClass = new MergeSort();
        sortClass.sort(arr);
        sortClass.print(arr);
    }

    private void sort(int[] listToSort) {
        mergeSort(listToSort, 0, listToSort.length - 1);
    }

    private void mergeSort(int[] listToSort, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        int midIdx = (startIdx + endIdx) / 2;

        mergeSort(listToSort, startIdx, midIdx);
        mergeSort(listToSort, midIdx + 1, endIdx);

        merge(listToSort, startIdx, midIdx, endIdx);
    }

    private void merge(int[] listToSort, int startIdx, int midIdx, int endIdx) {
        int leftArrSize = midIdx - startIdx + 1;
        int rightArrSize = endIdx - midIdx;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            leftArr[i] = listToSort[i + startIdx];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArr[i] = listToSort[i + midIdx + 1];
        }

        int i = 0, j = 0, k = startIdx;

        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] < rightArr[j]) {
                listToSort[k] = leftArr[i];
                i++;
            } else {
                listToSort[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArrSize) {
            listToSort[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArrSize) {
            listToSort[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
