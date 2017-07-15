package two.sum.version.two;

/**
 * Created by xudeng on 7/14/17.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target){
        int [] result = new int[2];
        int i = 0;
        int j = nums.length -1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if (sum == target){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }else if (sum < target){
                i = i + 1;
            }else{
                j = j - 1;
            }
        }
        return null;
    }
}
