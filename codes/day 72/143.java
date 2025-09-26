class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) return 0; 
        int[][] dp = new int[row][col];
        for(int i = row - 1; i >= 0; i--) {
            if(obstacleGrid[i][col-1] != 1) {
                dp[i][col-1] = 1; 
            } else {
                break;
            }
        }
        for(int j = col - 1; j >= 0; j--) {
            if(obstacleGrid[row-1][j] != 1) {
                dp[row-1][j] = 1; 
            } else {
                break;
            }
        }
        for(int i = row - 2; i >= 0; i--) {
            for(int j = col - 2; j >= 0; j--) {
                if(obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                } else {
                    dp[i][j] = 0;
                }
            }
        } return dp[0][0];
    }
}