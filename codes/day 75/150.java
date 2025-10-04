class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
               dfs(i , 0 ,board);
            }

            if( board[i][n-1]=='O'){
                dfs(i , n-1 , board);
            }
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
               dfs(0 , i ,board);
            }

            if( board[m-1][i]=='O'){
                dfs(m-1 , i , board);
            }
        }

        for(int i=0 ; i<m ;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';

                }
            }
        }
    }

    public void dfs(int i, int j, char board[][]) {

        board[i][j] = 'T';

        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int d = 0; d < 4; d++) {
            int nr = i + dirs[d][0];
            int nc = j + dirs[d][1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                dfs(nr, nc, board);
            }
        }
    }
}