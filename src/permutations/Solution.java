package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/11/17.
 */
public class Solution {


    public List<List<Integer>> permute(int[] nums) {

        List<Integer> existing = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return results;
        }
        backtrack(existing, 0, nums.length, nums, results);
        return results;
    }

    public void backtrack(List<Integer> existing,
                          int index, final int length, final int[] nums,
                          final List<List<Integer>> results)
    {
        if (index >= length)
        {
            List<Integer> result = new ArrayList<>();
            result.addAll(existing);
            results.add(result);
        }
        for(int num : nums)
        {
            if (!existing.contains(num))
            {
                existing.add(num);
                backtrack(existing, index + 1, length, nums, results);
                existing.remove(index);
            }else
            {
                continue;
            }
        }
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> results = main.permute(nums);
        for(List<Integer> result : results)
        {
            for(Integer item : result)
            {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
