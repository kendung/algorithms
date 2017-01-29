package four.sum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by xudeng on 1/28/17.
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {
            return 0;
        }
        // sum1 represents A + B
        Map<Integer, Integer> sum1 = new HashMap<>();
        // sum2 represents C + D
        Map<Integer, Integer> sum2 = new HashMap<>();

        int length = A.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                if (!sum1.containsKey(sum)) {
                    sum1.put(sum, 1);
                } else {
                    int count = sum1.get(sum);
                    sum1.put(sum, count + 1);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + D[j];
                if (!sum2.containsKey(sum)) {
                    sum2.put(sum, 1);
                } else {
                    int count = sum2.get(sum);
                    sum2.put(sum, count + 1);
                }
            }
        }
        int result = 0;
        Iterator<Integer> it1 = sum1.keySet().iterator();
        while(it1.hasNext())
        {
            int key1 = it1.next();
            int key2 = 0 - key1;
            if (sum2.containsKey(key2))
            {
                result = result + sum1.get(key1)*sum2.get(key2);
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        int[] A = new int[] {1,2};
        int[] B = new int[] {-2,-1};
        int[] C = new int[] {-1,2};
        int[] D = new int[] {0,2};
        System.out.println(main.fourSumCount(A,B,C,D));
    }
}
