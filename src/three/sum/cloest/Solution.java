package three.sum.cloest;

import java.util.Arrays;

/**
 * Created by xudeng on 1/15/17.
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 0;
        int sum = 0;
        if (nums.length <= 3)
        {
            for(int num : nums)
            {
                min = min + num;
            }
            return min;
        }
        min = nums[0] + nums[1] + nums[2];
        for(int i = 0; i <= nums.length - 3; i++)
        {
            int j = i + 1;
            int k = nums.length -1;
            while(j < k)
            {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - min))
                {
                    min = sum;
                    if (min == target)
                    {
                        return min;
                    }
                }
               if (sum > target)
               {
                   k--;
               }else
               {
                   j++;
               }
            }

        }
        return min;
    }
}
