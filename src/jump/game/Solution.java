package jump.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/29/17.
 */
public class Solution {

    private int minimumSteps;

    public int jump(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        if (nums.length == 1)
        {
            return 0;
        }
        this.minimumSteps = nums.length - 1;
        List<Integer> steps = new ArrayList<>();
        tryJump(steps, nums, 0);
        return this.minimumSteps;
    }

    private void tryJump(List<Integer> steps, int[] input, int thStep)
    {
        if (thStep >= input.length)
        {
            return;
        }
        int currentSteps = 0;
        for(int step : steps)
        {
            currentSteps = currentSteps + step;
        }
        if (currentSteps > input.length -1)
        {
            return;
        }
        if(currentSteps == input.length -1)
        {
            if (steps.size() < this.minimumSteps)
            {
                this.minimumSteps = steps.size();
            }
        }
        // continue for next step
        for(int i = 1; i <= input[currentSteps]; i++)
        {
            if (i + currentSteps >= input.length)
            {
                return;
            }
            steps.add(i);
            tryJump(steps, input,thStep + 1);
            steps.remove(steps.size() -1);
        }
    }

    public static void main(String args[])
    {
        int[] nums = new int[]{5,6,5,3,9,8,3,1,2,8,2,4,8,3,9,1,0,9,4,6,5,9,8,7,4,2,1,0,2};
        Solution main = new Solution();
        System.out.println(main.jump(nums));
    }
}
