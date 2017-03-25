package minimum.path.sum;

/**
 * Created by xudeng on 3/24/17.
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0)
        {
            return 0;
        }
        int column = grid[0].length;
        Integer[][] memo = new Integer[row][column];
        dp(grid, 0, 0, row, column, memo);
        return memo[0][0];
    }

    private int dp(int[][] grid, int i, int j, int row, int column, Integer[][] memo)
    {
        if (memo[i][j] != null)
        {
            return memo[i][j];
        }
        if(i == row -1)
        {
            int sum = 0;
            while(j <= column -1)
            {
                sum = sum + grid[i][j];
                j++;
            }
            memo[i][j] = sum;
            return sum;
        }
        if (j == column -1)
        {
            int sum = 0;
            while(i <= row -1)
            {
                sum = sum + grid[i][j];
                i++;
            }
            memo[i][j] = sum;
            return sum;
        }
        memo[i][j] = grid[i][j] +
                Math.min(dp(grid,i,j+1,row,column,memo), dp(grid,i+1,j,row,column,memo));
        return memo[i][j];
    }
}
