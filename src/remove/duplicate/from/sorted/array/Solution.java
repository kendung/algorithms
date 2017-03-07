package remove.duplicate.from.sorted.array;

/**
 * Created by xudeng on 3/6/17.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        if (nums.length == 1)
        {
            return 1;
        }
        int i = 0;
        int j = 1;
        int length = nums.length;
        int newlength = 1;
        while(i < length && j < length)
        {
            if (nums[i] == nums[j])
            {
                j++;
            }else if (j > i + 1)
            {
                nums[i + 1] = nums[j];
                i++;
                newlength++;
                j++;
            }else
            {
                i++;
                j++;
                newlength++;
            }
        }
        return newlength;
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        int[] nums = new int[]{};
        System.out.print(main.removeDuplicates(nums));
    }
}
