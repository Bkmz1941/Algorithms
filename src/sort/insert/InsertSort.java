package sort.insert;

import sort.AbstractSort;

public class InsertSort extends AbstractSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 7, 4, 2, 9, 8, 5, 3};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);
        insertSort.print(arr);
    }

    private void sort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) {
            int j = i + 1;
            int temp = listToSort[j];
            while (j > 0 && listToSort[j - 1] > temp) {
                listToSort[j] = listToSort[j - 1];
                j--;
            }
            listToSort[j] = temp;
        }
    }
}
