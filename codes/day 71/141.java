class Solution {
    static int n , m;
    private static void solve(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!='1')return;
        grid[i][j] = '0';
        solve(grid, i+1,j);
        solve(grid, i-1,j);
        solve(grid, i,j+1);
        solve(grid, i,j-1);
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        if (m == 0) return 0;
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    solve(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}