package combination.sum.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 2/20/17.
 */
public class Solution {

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || k > 9 || n < 1 || n > 45)
        {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        backtracking(result, 0, k, n);
        return results;
    }

    private void backtracking(List<Integer> result, int index, int k, int n)
    {
        if (index == k -1)
        {
            int sum = sum(result);
            int remaining = n - sum;
            if (remaining >0 && remaining <=9 && !result.contains(remaining))
            {
                result.add(remaining);
                List<Integer> listCopy = new ArrayList<Integer>(result);
                results.add(listCopy);
                result.remove(index);
            }
        }else
        {
            int start = (result.size() == 0)?1:(result.get(result.size() -1) + 1);
            int length = result.size();
            int currentSum = sum(result);
            int end = Math.floorDiv(n-currentSum,k-length);
            if (end > 9)
            {
                return;
            }
            for(int i = start; i <= end; i++)
            {
                result.add(index, i);
                backtracking(result, index + 1, k, n);
                result.remove(index);
            }

        }
    }

    private int sum(List<Integer> list)
    {
        int sum = 0;
        for(Integer element : list)
        {
            sum += element;
        }
        return sum;
    }

    public void print()
    {
        for(List<Integer> result: results)
        {
            for(Integer element : result)
            {
                System.out.print(element + "->");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        main.combinationSum3(5, 18);
        main.print();
    }
}
