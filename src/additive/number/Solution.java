package additive.number;

import java.math.BigInteger;

/**
 * Created by xudeng on 3/18/17.
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {

        for(int i = 1; i < num.length(); i++)
            for(int j = i + 1; j < num.length(); j++)
            {
                String first = num.substring(0,i);
                String second = num.substring(i, j);
                String last = num.substring(j);
                if (check(first,second, last))
                {
                    return true;
                }
            }
            return false;
    }

    private boolean check(String first, String second, String last)
    {
        if (isLeadingZero(first) || isLeadingZero(second))
        {
            return false;
        }
        String sum = (new BigInteger(first)).add(new BigInteger(second)).toString();
        if (sum.equals(last))
        {
            return true;
        }
        if (last.length() < sum.length())
        {
            return false;
        }
        if (!last.substring(0, sum.length()).equals(sum))
        {
            return false;
        }
        return check(second, sum, last.substring(sum.length()));
    }

    private boolean isLeadingZero(String num)
    {
        if (num.length() > 1 && num.charAt(0) == '0')
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        System.out.println(main.isAdditiveNumber("199100199"));
    }
}
