package graphs.task2;

public class Solution {
    boolean[][] seen;
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int answer = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    seen[i][j] = true;
                    answer += 1;
                    dfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    public boolean valid(int row, int col, char[][] grid) {
        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
    }

    public void dfs(int row, int col, char[][] grid) {
        for (int[] direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];

            if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }
}
