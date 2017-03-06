package longest.common.prifix.string;

/**
 * Created by xudeng on 3/5/17.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {

        String common = "";
        if (strs.length == 0)
        {
            return common;
        }
        String firstItem = strs[0];
        if (firstItem.length() == 0)
        {
            return common;
        }else
        {
            char firstChar = firstItem.charAt(0);
            String firstCharstr = String.valueOf(firstChar);
            String[] substrs = new String[strs.length];
            for(int i = 0 ; i < strs.length; i++)
            {
                if(!strs[i].startsWith(firstCharstr))
                {
                    return common;
                }else
                {
                    substrs[i] = strs[i].substring(1, strs[i].length());
                }
            }
            // all items in the strs contains the same prefix
            return firstCharstr + longestCommonPrefix(substrs);
        }
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        String[] strs = new String[]{"c","acc","ccc"};
        System.out.print(main.longestCommonPrefix(strs));
    }
}
