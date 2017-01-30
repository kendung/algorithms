package jump.game.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/29/17.
 */
public class Solution {

    private boolean canJump =false;

    public boolean canJump(int[] nums) {
        List<Integer> steps = new ArrayList<>();
        tryJump(steps, nums, 0);
        return this.canJump;
    }

    private void tryJump(List<Integer> steps, int[] input, int thStep)
    {
        if (this.canJump)
        {
            return;
        }
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
            this.canJump = true;
            return;
        }
        // continue for next step
        int i = Math.min(input.length-1-currentSteps, input[currentSteps]);
        for(; i >= 1; i--)
        {
            if (this.canJump)
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
        Solution main = new Solution();
        int[] nums = new int[] {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,
            5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(main.canJump(nums));
    }

}
