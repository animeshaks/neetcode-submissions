class Solution {

    private void dfs(char[][] grid, int row, int col) {

        // Boundary check
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        // Already visited / water
        if (grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Explore four directions
        dfs(grid, row + 1, col); // down
        dfs(grid, row - 1, col); // up
        dfs(grid, row, col + 1); // right
        dfs(grid, row, col - 1); // left
    }

    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    islands++;

                    // Explore the complete island
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }
}
