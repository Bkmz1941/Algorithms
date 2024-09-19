package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DPAlgorithmFibonacci {
    private final Map<Integer, Integer> _cache = new HashMap<>();

    /**
     * O(n)
     * n = 6, 11
     * n = 5, 9
     * n = 4, 7
     * n = 3, 5
     */
    public int dpTopDown(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (_cache.containsKey(n)) {
            return _cache.get(n);
        }

        _cache.put(n, dpTopDown(n - 1) + dpTopDown(n - 2));
        return _cache.get(n);
    }

    /**
     * O(2^n)
     * n = 6, 25
     * n = 5, 15
     * n = 4, 9
     * n = 3, 5
     */
    public int nodp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return nodp(n - 1) + nodp(n - 2);
    }

    public int tabulation(int n) {
        int[] arr = new int[n + 1];

        // [0, 1, 1, 2, 3, 5, 8]
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
