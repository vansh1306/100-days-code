class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;        // total rows
        int cols = matrix[0].length;     // total columns
        int row = 0;                     // start at first row
        int col = cols - 1;              // start at last column (top-right)

        // loop until we go out of bounds
        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) return true; // found target
            else if (target < current) col--;   // move left
            else row++;                         // move down
        }
        return false; // target not found
    }
}