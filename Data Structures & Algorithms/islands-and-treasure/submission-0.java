class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure cells to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            // Four directions
            int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
            };

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check boundaries
                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Only process empty land
                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // Distance from current cell + 1
                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}