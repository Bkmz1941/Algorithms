package yandex_academy.theme_3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Выведите число сочетаний с повторением С(n,k)
 * С(n,k) = (k + n − 1)! / (n − 1)!⋅* k!
 */
public class TaskC {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = bufferedReader.readLine().split("\\s+");
            if (line.length != 2) throw new Exception("Error: input params count must be 2");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int result = factorial(k + n - 1) / (factorial(n - 1) * factorial(k));
            System.out.println(result);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static int factorial(int number) {
        if (number <= 1) return 1;
        return number * factorial(number - 1);
    }
}
