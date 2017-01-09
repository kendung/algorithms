package bucket.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xudeng on 1/8/17.
 */
// find max difference value in sorted array for unsorted input, all data in the array is positive
public class MaxDifferenceValueInSortedArray {

    private int[] input;
    // the number of elements in the array
    private int n;
    private int max;
    private int min;
    private int bucketCount;
    private int divider;


    private MaxDifferenceValueInSortedArray(int[] input, int bucketCount) {
        this.input = input;
        this.n = input.length;
        this.bucketCount = bucketCount;
        min = input[0];
        max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
            } else if (input[i] > max) {
                max = input[i];
            }
        }
        double doubleMax = max;
        divider = (int) (Math.ceil((doubleMax + 1) / bucketCount));
    }

    private List<List<Integer>> constructBuckets()
    {
        List<List<Integer>> buckets = new ArrayList<>();
        // construct buckets
        for(int i = 0; i < this.bucketCount; i++)
        {
            List<Integer> bucket = new ArrayList<>();
            buckets.add(bucket);
        }
        // put element into bucket
        for(int i = 0; i < this.n; i++)
        {
            int j = Math.floorDiv(this.input[i], this.divider);
            buckets.get(j).add(this.input[i]);
        }
        return buckets;
    }

    public int getMaDifferenceValueInSortedArray()
    {
        List<List<Integer>> buckets = this.constructBuckets();
        int max = this.divider;
        int pre = 0;
        int next= pre +1;
        while(next < buckets.size())
        {
            if (buckets.get(pre).size() > 0 && buckets.get(next).size() > 0)
            {
                // pre bucket has elements, next bucket has elements
                int difference = Collections.min(buckets.get(next)) -
                        Collections.max(buckets.get(pre));
                if (difference > max)
                {
                    max = difference;
                }
                pre = next;
                next = pre + 1;
            }else if (buckets.get(pre).size() == 0)
            {
                pre = next;
                next = pre + 1;
            }else if (buckets.get(next).size() == 0)
            {
                next = next + 1;
            }
        }
        return max;
    }

    public static void main(String args[])
    {
        int [] input = new int[]{22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
        MaxDifferenceValueInSortedArray main =new MaxDifferenceValueInSortedArray(input, 10);
        System.out.println(main.getMaDifferenceValueInSortedArray());
    }

}
