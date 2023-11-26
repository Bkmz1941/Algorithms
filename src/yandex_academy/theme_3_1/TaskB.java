package yandex_academy.theme_3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Выведите число сочетаний C(n,k)
 * C(k,n) = n! / (n − k)! * k!
 */
public class TaskB {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = bufferedReader.readLine().split("\\s+");
            if (line.length != 2) throw new Exception("Error: params count must be 2");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int result = factorial(n) / (factorial(n - k) * factorial(k));
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
