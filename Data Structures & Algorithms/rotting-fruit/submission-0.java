class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Add all rotten oranges to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Multi-source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process one complete level = one minute
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int[] direction : directions) {

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Boundary check
                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols) {
                        continue;
                    }

                    // Only fresh oranges can become rotten
                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    // Make it rotten
                    grid[newRow][newCol] = 2;

                    fresh--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }

            minutes++;
        }

        // Some fresh oranges couldn't be reached
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
