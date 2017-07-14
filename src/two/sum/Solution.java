package two.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xudeng on 7/13/17.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target){
        int [] result = new int[2];
        // a map used to map num to the index in the array
        Map<Integer, List<Integer>> numToIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numToIndexMap.containsKey(nums[i])){
                numToIndexMap.get(nums[i]).add(i);
            }else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                numToIndexMap.put(nums[i], indices);
            }
        }
        // try to find out two numbers whose sum is target
        for(int i = 0; i< nums.length; i++){
            int remainder = target - nums[i];
            if (remainder != nums[i] && numToIndexMap.containsKey(remainder)){
                result[0] = i;
                result[1] = numToIndexMap.get(remainder).get(0);
            }
            if (remainder == nums[i] && numToIndexMap.get(remainder).size() > 1){
                result[0] = i;
                result[1] = numToIndexMap.get(remainder).get(1);
            }
            if (result[0] != 0 || result[1] != 0){
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,2,4,2};
        int[] result = solution.twoSum(nums, 4);
        System.out.print("[");
        System.out.print(result[0]);
        System.out.print(",");
        System.out.print(result[1]);
        System.out.print("]");
    }
}
