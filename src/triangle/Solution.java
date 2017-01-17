package triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/16/17.
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] results = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> lastRow = triangle.get(n - 1);
            results[n - 1][i] = lastRow.get(i);
        }
        int j = n - 2;
        while (j >= 0) {
            int k = 0;
            List<Integer> jrow = triangle.get(j);
            while (k <= j) {
                results[j][k] = Math.min(results[j + 1][k],
                        results[j + 1][k + 1]) + jrow.get(k);
                k++;
            }
            j--;
        }
        return results[0][0];
    }

    public static void main(String args[])
    {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);
        Solution main = new Solution();
        System.out.println(main.minimumTotal(triangle));
    }
}
