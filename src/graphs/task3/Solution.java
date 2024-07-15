package graphs.task3;

import trees.helpers.Pair;

import java.util.*;

public class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean answer = false;

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        System.out.println(map);
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        seen.add(source);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            List<Integer> list = map.get(curr);
            for (Integer elem : list) {
                if (elem == destination) {
                    answer = true;
                    break;
                }
                if (!seen.contains((elem))) {
                    stack.add(elem);
                    seen.add(elem);
                }
            }
            if (answer) break;
        }

        return answer;
    }
}
