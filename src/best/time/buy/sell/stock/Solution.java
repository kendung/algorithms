package best.time.buy.sell.stock;

/**
 * Created by xudeng on 3/22/17.
 * // dynamic programming
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
        {
            return 0;
        }
        int[] result = new int[prices.length];
        for(int i = 0; i < prices.length; i++)
        {
            dp(prices, result, i);
        }
        return result[result.length -1];
    }

    private void dp(int[] prices, int[] result, int index)
    {
        if (index == 0)
        {
            result[index] = 0;
            return;
        }
        if (index >= prices.length)
        {
            return;
        }
        int maxprofilt = 0;
        if (prices[index] == 0)
        {
            result[index] = result[index-1];
            return;
        }
        if (result[index-1] == 0 && prices[index] <= prices[index-1])
        {
            result[index] = 0;
            return;
        }
        for(int i = 0; i < index; i++)
        {
            if (prices[index] < prices[i])
            {
                continue;
            }
            int profit = prices[index] - prices[i];
            if (profit > maxprofilt)
            {
                maxprofilt = profit;
            }
        }
        if (maxprofilt > result[index - 1])
        {
            result[index] = maxprofilt;
        }else
        {
            result[index] = result[index - 1];
        }
    }
    public static void main(String[] args)
    {
        Solution main = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.print(main.maxProfit(prices));
    }
}
