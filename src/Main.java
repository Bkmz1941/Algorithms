import dynamic_programming.DPAlgorithmFibonacci;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DPAlgorithmFibonacci algorithmFibonacci = new DPAlgorithmFibonacci();
        System.out.println(algorithmFibonacci.dpTopDown(6));

        // 0 1 1 2 3 5 8 13 21 34 55
    }
}