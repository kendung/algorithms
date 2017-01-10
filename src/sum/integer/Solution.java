package sum.integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xudeng on 1/9/17.
 */
public class Solution {

    public int getSum(int a, int b) {
        List<String> bits1 = getBit(a);
        List<String> bits2 = getBit(b);
        if (bits1.size() < bits2.size()) {
            int length = bits2.size() - bits1.size();
            for (int i = 0; i < length; i++) {
                bits1.add(bits1.size(), "0");
            }
        } else if (bits1.size() > bits2.size()) {
            int length = bits1.size() - bits2.size();
            for (int i = 0; i < length; i++) {
                bits2.add(bits2.size(), "0");
            }
        }
        List<String> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        boolean carryBit = false;
        while (index1 < bits1.size() && index2 < bits2.size()) {
            String bit1 = bits1.get(index1);
            String bit2 = bits2.get(index2);
            if (bit1.equals("0") && bit2.equals("0")) {
                if (carryBit) {
                    result.add("1");
                    carryBit = false;
                }
                else
                    result.add("0");
            }
            if (bit1.equals("0") && bit2.equals("1")) {
                if (carryBit) {
                    result.add("0");
                    carryBit = true;
                } else {
                    result.add("1");
                }

            }
            if (bit1.equals("1") && bit2.equals("0")) {
                if (carryBit) {
                    result.add("0");
                    carryBit = true;
                } else {
                    result.add("1");
                }

            }
            if (bit1.equals("1") && bit2.equals("1")) {
                if (carryBit) {
                    result.add("1");
                    carryBit = true;
                } else {
                    result.add("0");
                    carryBit = true;
                }
            }
            index1++;
            index2++;
        }
        if (carryBit)
        {
            result.add("1");
        }
        Collections.reverse(result);
        return Integer.parseInt(String.join("", result), 2);
    }

    public List<String> getBit(int a) {
        List<String> bits = new ArrayList<>();
        if (a < 0) {
            throw new IllegalArgumentException("negative case is not allowed");
        }
        while (a >= 2) {
            int bit = a % 2;
            bits.add(Integer.toString(bit));
            a = a / 2;
        }
        bits.add(Integer.toString(a));
        return bits;
    }

    public static void main(String args[]) {
        Solution main = new Solution();
//        List<String> bits = main.getBit(2);
//        Collections.reverse(bits);
//        for (String bit : bits) {
//            System.out.print(bit);
//        }
        System.out.println(main.getSum(49989, 21119));

    }

}
