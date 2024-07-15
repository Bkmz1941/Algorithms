package graphs.task3;

import graphs.GeneratorInputs;

/**
 * 1971. Find if Path Exists in Graph
 * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/description/">link</a>
 */
public class Task3 {
    public static void main(String[] args) {
        GeneratorInputs generator = new GeneratorInputs();
        Solution solution = new Solution();
        System.out.printf("Answer: %b", solution.validPath(3, generator.VARIANT_3, 0, 2));
    }
}
