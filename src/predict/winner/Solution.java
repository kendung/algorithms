package predict.winner;

/**
 * Created by xudeng on 3/24/17.
 */
public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        return dp(nums,0,nums.length-1) >0 ? true : false;
    }

    private int dp(int[] nums, int i, int j)
    {
        if (i == j)
        {
            return nums[i];
        }
        return Math.max(nums[i] - dp(nums, i + 1, j), nums[j] - dp(nums, i, j-1));
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        int[] nums = new int[]{1,2,3,88,9};
        System.out.print(main.PredictTheWinner(nums));
    }
}
