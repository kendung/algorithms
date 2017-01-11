package minimum.size.subarray.sum;

/**
 * Created by xudeng on 1/10/17.
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        int result;
        int currentMinimum = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= s)
            {
                return 1;
            }
            int sum = nums[i];
            result = 1;
            for (int j = i+1; j < nums.length; j++)
            {
                sum = sum + nums[j];
                result ++;
                if (sum >=s)
                {
                    if (currentMinimum == -1)
                    {
                        currentMinimum = result;
                    }else if (result < currentMinimum)
                    {
                        currentMinimum = result;
                    }
                    break;
                }
            }
        }
        if (currentMinimum == -1)
        {
            return 0;
        }
        return currentMinimum;
    }

    public static void main(String args[])
    {
        MinimumSizeSubArraySum main = new MinimumSizeSubArraySum();
        int [] nums = new int[]{2, 3, 1, 2, 4,3};
        System.out.println(main.minSubArrayLen(7, nums));
    }
}
