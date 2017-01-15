package one.three.two.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/14/17.
 */
public class Solution {

    public boolean find132pattern(int[] nums) {
        List<Integer> selectedIndex = new ArrayList<>();
        return findFromIndex(selectedIndex, nums, 0);
    }

    private boolean findFromIndex(List<Integer> selectedIndex, int[] nums,
                                   int index) {
        if (selectedIndex.size() == 2)
        {
            int ai = nums[selectedIndex.get(0)];
            int aj = nums[selectedIndex.get(1)];
            if (ai >= aj)
            {
                return false;
            }
        }
        if (selectedIndex.size() == 3 )
        {
            int ai = nums[selectedIndex.get(0)];
            int aj = nums[selectedIndex.get(1)];
            int ak = nums[selectedIndex.get(2)];
            if (ai < ak && ak < aj)
            {
                return true;
            }
            return false;
        }
        if (nums == null || nums.length == 0) {
            return false;
        }

        if ((nums.length - index + selectedIndex.size()) < 3)
        {
            return false;
        }
        int i = index;
        while( i < nums.length)
        {
            if (i > index && nums[i] == nums[i-1])
            {
                i ++;
                continue;
            }
            selectedIndex.add(i);
            boolean found = findFromIndex(selectedIndex, nums, i +1);
            if (found)
            {
                return true;
            }
            selectedIndex.remove(new Integer(i));
            i = i + 1 ;
        }
        return false;
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int [] nums = new int[]{0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1
                ,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,1,1,1,
                1,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,1,0,1,1,0,1,0,1,1,1
                ,0,0,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,0
                ,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,0,1,1,0,1,0,1,1,1,1,1,0
                ,1,0,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,0
                ,0,1,0,1,0,1,0,1,0,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,0};
        if (main.find132pattern(nums))
        {
            System.out.println("True");
        }else
        {
            System.out.println("False");
        }
    }
}
