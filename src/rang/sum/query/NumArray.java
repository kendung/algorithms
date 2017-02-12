package rang.sum.query;

/**
 * Created by xudeng on 2/11/17.
 */
public class NumArray {

    // for index i, represents sum of  the nums[0] .... nums[i]
    private int[] sums;
    // input array
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        for(int i = 0; i < nums.length; i ++)
        {
            if (i == 0)
            {
                sums[i] = nums[i];
            }else
            {
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + this.nums[i];
    }

    public static void main(String args[])
    {
        NumArray main = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.print(main.sumRange(2,5));
    }
}
