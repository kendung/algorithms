package permutation.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/11/17.
 */
public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> existing = new ArrayList<>();
        backtrack(existing, 1, n, k );
        StringBuffer sb = new StringBuffer();
        for(Integer number : existing)
        {
            sb.append(number);
        }
        return sb.toString();
    }

    public void backtrack(final List<Integer> existing, final int index,
                          final int n, int k)
    {
        if (index == n)
        {
            // find last number for the permutation
            for(int i = 1; i <= n; i++)
            {
                if (!existing.contains(i))
                {
                    existing.add(i);
                    break;
                }
            }
        }
        for(int i = 1; i <= n; i++)
        {
            if (!existing.contains(i))
            {
                if (existing.size() < index)
                {
                    existing.add(index -1, i);
                }else
                {
                    existing.set(index -1, i);
                }
                int factorial = factorial(n-index);
                if (k > factorial)
                {
                    k = k - factorial;
                }else
                {
                    backtrack(existing, index + 1, n, k);
                }
            }

        }
    }

    public int factorial(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        System.out.println(main.getPermutation(3, 4));
    }

}
