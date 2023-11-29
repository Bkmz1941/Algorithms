package dynamic_programming.backpack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // (0): Фонарик вес 3, ценность 1
        // (1): Радио   вес 4, ценность 6
        // (2): Термос  вес 5, ценность 4
        // (3): Молоток вес 8, ценность 7
        // (4): Топор   вес 9, ценность 6
        int[] itemsWeight = {3, 4, 5, 8, 9};
        int[] itemsPrice = {1, 6, 4, 7, 6};
        int capacity = 13;

        int[][] A;
        A = new int[itemsWeight.length + 1][];
        for (int i = 0; i < itemsWeight.length + 1; i++) {
            A[i] = new int[capacity + 1];
        }

        int itemIdx = 0;
        int capacityIdx = 0;
        for (itemIdx = 0; itemIdx <= itemsWeight.length; itemIdx++) {
            for (capacityIdx = 0; capacityIdx <= capacity; capacityIdx++) {
                if (itemIdx == 0 || capacityIdx == 0) {
                    A[itemIdx][capacityIdx] = 0;
                } else {
                    int currentItemIdx = itemIdx - 1;
                    // Если текущая вместимость больше или равна веса предмета
                    // Надо решить вписываем ли мы ценность текущего предмета или предыдущего предмета, который уместился в рюкзак
                    if (capacityIdx >= itemsWeight[currentItemIdx]) {
                        int tablePrice = A[currentItemIdx][capacityIdx];
                        int currencyWeight = capacity - itemsWeight[currentItemIdx];
                        int currencyPrice = itemsPrice[currentItemIdx];

                        A[itemIdx][capacityIdx] = Math.max(
                                tablePrice,
                                A[currentItemIdx][currencyWeight] + currencyPrice
                        );
                    } else {
                        // Вписываем ценность предыдущего предмета, который уместился в рюкзак
                        A[itemIdx][capacityIdx] = A[currentItemIdx][capacityIdx];
                    }
                }
            }
        }

        printTable(A);
    }

    private static void printTable(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
    }
}
