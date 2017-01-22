package third.maximum.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xudeng on 1/21/17.
 */
public class Solution {
    public int thirdMax(int[] nums) {

        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
           if (buffer.size() < 3)
           {
               if (!buffer.contains(nums[i]))
               {
                   buffer.add(nums[i]);
                   Collections.sort(buffer);
               }
           }else if (buffer.size() == 3 && !buffer.contains(nums[i]))
           {
               if (nums[i] > buffer.get(2))
               {
                   buffer.remove(0);
                   buffer.add(nums[i]);
               }else if (nums[i] > buffer.get(1) && nums[i] < buffer.get(2))
               {
                   buffer.remove(0);
                   buffer.add(1, nums[i]);
               }else if (nums[i] > buffer.get(0) && nums[i] < buffer.get(1))
               {
                   buffer.remove(0);
                   buffer.add(0, nums[i]);
               }
           }
        }
        if (buffer.size() < 3)
        {
            return buffer.get(buffer.size() -1);
        }
        return buffer.get(0);
    }

    public static void main(String args[])
    {
        int [] nums = new int[]{2,1,3, 100, 99, 3};
        Solution main = new Solution();
        System.out.println(main.thirdMax(nums));
    }

}
