package range.sum.query.edition.two;

/**
 * Created by xudeng on 2/11/17.
 */
public class NumMatrix {

    // sum of left upper corner [0,0], lower right corner [i,j]
    private int[][] sums;
    // input
    private int[][] inputs;

    public NumMatrix(int[][] matrix) {

        this.inputs = matrix;
        if (matrix.length > 0)
        {
            this.sums = new int[matrix.length][matrix[0].length];
        }
        for(int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                for(int k = 0; i <= i; k++)
                {
                    for(int x = 0; x <= j; x ++)
                    {
                        this.sums[i][j] = this.sums[i][j] + this.inputs[k][x];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.inputs.length == 0)
        {
            return 0;
        }
        if (row1 == 0 && col1 == 0)
        {
            return sums[row2][col2];
        }
        if (row1 == 0)
        {
            return (sums[row2][col2] - sums[row2][col1-1]);
        }
        if (col1 == 0)
        {
            return(sums[row2][col2] -sums[row1-1][col2]);
        }

        return sums[row2][col2] - sums[row1-1][col2] - sums[row2][col1-1] + sums[row1-1][col1-1];
    }

    public static void main(String[] args)
    {

    }


}
