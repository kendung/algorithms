package spiral.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/11/17.
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null)
            return result;
        int row = matrix.length;
        if (row == 0)
        {
            return result;
        }
        int column = matrix[0].length;
        int topLeftRow = 0;
        int topLeftColumn = 0;
        int bottomRightRow = row -1;
        int bottomRightColumn = column -1;
        while(topLeftRow <= bottomRightRow && topLeftColumn <= bottomRightColumn)
        {
            result.addAll(walkClockWise(matrix, topLeftRow, topLeftColumn, bottomRightRow, bottomRightColumn));
            topLeftRow ++;
            topLeftColumn ++;
            bottomRightRow --;
            bottomRightColumn --;
        }

        return result;
    }

    private List<Integer> walkClockWise(int [][] matrix, int topLeftRow, int topLeftColumn, int bottomRightRow, int bottomRightColumn)
    {
        List<Integer> result = new ArrayList<>();
        int currentRow = topLeftRow;
        int currentColumn = topLeftColumn;
        result.add(matrix[currentRow][currentColumn]);
        // go right horizontally
        while(currentColumn < bottomRightColumn)
        {
            currentColumn ++;
            result.add(matrix[currentRow][currentColumn]);
        }
        // go down vertically
        while (currentRow < bottomRightRow)
        {
            currentRow ++;
            result.add(matrix[currentRow][currentColumn]);
        }
        // go left horizontally
        while(currentColumn > topLeftColumn && currentRow != topLeftRow)
        {
            currentColumn --;
            result.add(matrix[currentRow][currentColumn]);
        }
        // go up vertically
        while(currentRow > topLeftRow && currentColumn != bottomRightColumn)
        {
            currentRow --;
            if (currentRow != topLeftRow || currentColumn != topLeftColumn)
                result.add(matrix[currentRow][currentColumn]);
        }
        return result;
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int [][]matrix = new int[][]{{2,5},{8,4},{0,-1}};
        main.spiralOrder(matrix);
    }
}
