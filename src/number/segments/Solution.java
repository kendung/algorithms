package number.segments;

/**
 * Created by xudeng on 2/8/17.
 */
public class Solution {

    public int countSegments(String s) {
        if (s.length() == 0)
        {
            return 0;
        }
        int count = 0;
        boolean space = true;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == ' ')
            {
                space = true;
            }else
            {
                if (space)
                {
                    count ++;
                }
                space = false;
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        System.out.print(main.countSegments("Hello, my name is John"));
    }

}
