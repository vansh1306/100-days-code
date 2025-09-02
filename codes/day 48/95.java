class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return traverse(m-1, n-1, dp);
    }

    private int traverse(int i, int j, int[][] dp){
        if (i==0 && j==0) {
            return 1;
        }
        if (i<0 || j<0) {
            return 0;
        }
        if (dp[i][j] != 0) return dp[i][j];

        int up = traverse(i-1, j, dp);
        int left = traverse(i, j-1, dp);

        return dp[i][j] = up+left;
    }
}