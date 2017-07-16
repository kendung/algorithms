package add.two.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xudeng on 7/15/17.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            if(!count.containsKey(num)){
                count.put(num, 1);
            }else{
               count.remove(num);
            }
        }
        return count.keySet().iterator().next();
    }

    public int singleNumber2(int[] nums){
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
