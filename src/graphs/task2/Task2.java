package graphs.task2;

import graphs.GeneratorInputs;

/**
 * 200. Number of Islands
 * <a href="https://leetcode.com/problems/number-of-islands/description/">link</a>
 */
public class Task2 {
    public static void main(String[] args) {
        GeneratorInputs generator = new GeneratorInputs();
        Solution solution = new Solution();
        System.out.printf("Answer: %b", 1 == solution.numIslands(generator.VARIANT_1));
    }
}
