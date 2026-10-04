class Solution {

    int rows;
    int cols;

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Start DFS from Pacific borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Start DFS from Atlantic borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }

        // Cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(
        int[][] heights,
        int row,
        int col,
        boolean[][] visited
    ) {

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Boundary check
            if (newRow < 0 || newRow >= rows ||
                newCol < 0 || newCol >= cols) {
                continue;
            }

            // Can move only to equal or higher cell
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, newRow, newCol, visited);
        }
    }
}