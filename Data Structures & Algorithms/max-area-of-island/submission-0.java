class Solution {

    int dfs(int[][] grid, int row, int col) {

        // Out of bounds
        if (row >= grid.length || row < 0 ||
            col >= grid[0].length || col < 0) {
            return 0;
        }

        // Water or already visited
        if (grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        // Current cell = 1
        int area = 1;

        area += dfs(grid, row + 1, col);
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row, col + 1);
        area += dfs(grid, row, col - 1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {

                    int islandArea = dfs(grid, i, j);

                    max = Math.max(max, islandArea);
                }
            }
        }

        return max;
    }
}