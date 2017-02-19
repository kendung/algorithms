package ugly.number.two;

/**
 * Created by xudeng on 2/19/17.
 */
public class Solution {

    private long[] results = new long[1690];


    public long nthUglyNumber(int n) {
        // initialize
        for(int i = 0; i < results.length; i ++)
        {
            results[i] = -1;
        }
        // if n = 1; then return 1;
        results[0] = 1;
        return dp(n);
    }

    private long dp(int n)
    {
        if (results[n-1] != -1)
        {
            return results[n-1];
        }
        long previous = dp(n-1);
        long min = -1;
        for(int i = 1; i <= n-1; i ++)
        {
            long dpi = dp(i);
            long value1 = dpi * 2;
            long value2 = dpi * 3;
            long value3 = dpi * 5;
            if (value1 > previous)
            {
                if (min == -1)
                {
                    min = value1;
                }else if (min > value1)
                {
                    min = value1;
                }
            }else if (value2 > previous)
            {
                if (min == -1)
                {
                    min = value2;
                }else if (min > value2)
                {
                    min = value2;
                }
            }else if (value3 > previous)
            {
                if (min == -1)
                {
                    min = value3;
                }else if (min > value3)
                {
                    min = value3;
                }
            }
        }
        results[n-1] = min;
        return min;
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        System.out.print(main.nthUglyNumber(1600));
    }
}
