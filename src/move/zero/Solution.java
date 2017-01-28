package move.zero;

/**
 * Created by xudeng on 1/28/17.
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return;
        }
        int i = 0;
        int j = i + 1;
        while(j < nums.length)
        {
            if (nums[i] == 0 && nums[j] != 0)
            {
                // exchange
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
                i++;
                j++;
            }else if (nums[i] == 0 && nums[j] == 0)
            {
                j++;
            }else if (nums[i] != 0 && nums[j] == 0)
            {
                j++;
                i++;
            }else if (nums[i] != 0 && nums[j] != 0)
            {
                i++;
                j++;
            }
        }

    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int [] nums = new int[]{12,3,4,0,34,89,8,0,0,78,0,999};
        main.moveZeroes(nums);
        for(int num : nums)
        {
            System.out.print(num + ",");
        }
    }
}
