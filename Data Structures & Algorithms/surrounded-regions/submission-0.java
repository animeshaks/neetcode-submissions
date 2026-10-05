class Solution {
    int rows;
    int cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // left
        for(int r=0; r<rows; r++) {
            dfs(board, r, 0);
        }

        // right
        for(int r=0; r<rows; r++) {
            dfs(board, r, cols-1);
        }

        // top
        for(int c=0; c<cols; c++) {
            dfs(board, 0, c);
        }

        // bottom
        for(int c=0; c<cols; c++) {
            dfs(board, rows-1, c);
        }


        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
                    board[i][j] = 'O';
                
                
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        
        // Boundary
        if(row >= rows || row < 0 || col >= cols || col < 0 || board[row][col] != 'O')
            return;

        board[row][col] = 'T'; // Not surrounded

        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }
}
