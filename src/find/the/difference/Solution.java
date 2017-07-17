package find.the.difference;

/**
 * Created by xudeng on 7/17/17.
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        char result = 0;
        for (int i = 0; i < s.length(); i++){
            result ^= s.charAt(i);
        }
        for (int i= 0; i < t.length(); i++){
            result ^= t.charAt(i);
        }
        return result;
    }
}
