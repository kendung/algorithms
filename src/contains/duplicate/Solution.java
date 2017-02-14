package contains.duplicate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xudeng on 2/13/17.
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> sets = new HashSet<>();
        for(int num : nums)
        {
            if (!sets.contains(num))
            {
                sets.add(num);
            }else
            {
                return true;
            }
        }
        return false;
    }
}
