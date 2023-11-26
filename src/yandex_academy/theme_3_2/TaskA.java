package yandex_academy.theme_3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskA {
    public static void main(String[] args) {
        List<Map.Entry<Integer, Integer>> intervals = new ArrayList<>();
        int countInterval = 0;
        AtomicInteger result = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            countInterval = getCountIntervalsFromInput(bufferedReader);
            intervals.addAll(getPayloadDataFromInput(bufferedReader, countInterval));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ascSortByValue(intervals).forEach(el -> {
            if (el.getKey() > max.get()) {
                result.getAndIncrement();
                max.set(el.getValue());
            }
        });

        System.out.println(result);
    }

    private static int getCountIntervalsFromInput(BufferedReader bufferedReader) throws IOException {
        int result = 0;
        String inputString = bufferedReader.readLine().trim();
        if (inputString.isEmpty()) {
            System.out.println("ERROR: interval number must be number");
            return getCountIntervalsFromInput(bufferedReader);
        }
        String[] inputData = inputString.split("\\s+");
        if (inputData.length != 1) {
            System.out.println("ERROR: interval number must be one");
            return getCountIntervalsFromInput(bufferedReader);
        }
        result = Integer.parseInt(inputData[0]);
        return result;
    }

    private static List<Map.Entry<Integer, Integer>> getPayloadDataFromInput(BufferedReader bufferedReader, int countInterval) throws IOException {
        List<Map.Entry<Integer, Integer>> intervals = new ArrayList<>();
        while (countInterval > 0) {
            String inputString = bufferedReader.readLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("ERROR: interval number must be number");
                return getPayloadDataFromInput(bufferedReader, countInterval);
            }
            String[] inputData = inputString.split("\\s+");
            if (inputData.length != 2) {
                System.out.println("ERROR: interval data must have two numbers");
                return getPayloadDataFromInput(bufferedReader, countInterval);
            }
            intervals.add(Map.entry(
                    Integer.valueOf(inputData[0]),
                    Integer.valueOf(inputData[1]))
            );
            countInterval--;
        }
        return intervals;
    }

    private static List<Map.Entry<Integer, Integer>> ascSortByValue(List<Map.Entry<Integer, Integer>> listIntervals) {
        for (int i = 1; i < listIntervals.size(); i++) {
            Map.Entry<Integer, Integer> temp = listIntervals.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (
                            listIntervals.get(j).getValue() >= temp.getValue()
                    )
            ) {
                listIntervals.set(j + 1, listIntervals.get(j));
                j--;
            }

            listIntervals.set(j + 1, temp);
        }
        return listIntervals;
    }
}
/**
 * Интервалы: 1 ≤ n ≤ 100
 * Данные: 1 ≤ 50
 * <p>
 * {1: 6}
 * {1: 4}
 * {1: 3}
 * {5: 7}
 * {1: 3}
 * {4: 5}
 * {3: 5}
 * {3: 6}
 * {1: 4}
 * {2: 4}
 * {4: 6}
 * <p>
 * 3
 * {1: 10}
 * {2: 3}
 * {4: 5}
 */