package yandex_academy.theme_3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskA {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = bufferedReader.readLine();
            int inputNumber = Integer.parseInt(line);
            int result = inputNumber--;
            while (inputNumber != 0) {
                result = result * inputNumber;
                inputNumber--;
            }
            System.out.println(result);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }
}
