package house.rob;


/**
 * Created by xudeng on 2/7/17.
 */
public class Solution {

    private int[] results;

    public int rob(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        if (nums.length == 1)
        {
            return nums[0];
        }
        results = new int[nums.length];
        for(int i = 0; i < nums.length ; i++)
        {
            results[i] = -1;
        }
        return dp(nums, 0);
    }
    private int dp(int [] nums, int from)
    {
        if (from >= nums.length)
        {
            return 0;
        }
        if (results[from] != -1)
        {
            return results[from];
        }
        // rob the FROM house in the array
        int max1 =nums[from] + dp(nums, from + 2);

        // do not rob FROM house in the array
        int max2 = dp(nums, from + 1);
        if (max1 > max2)
        {
            results[from] = max1;
            return max1;
        }else
        {
            results[from] = max2;
            return max2;
        }
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int[] houses = new int[]{2,1,1,2};
        System.out.println(main.rob(houses));
    }
}
