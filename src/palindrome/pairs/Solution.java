package palindrome.pairs;

import java.util.*;

/**
 * Created by xudeng on 1/14/17.
 */
public class Solution {

    static class MapItem {
        private String reverse;
        private int index;

        public MapItem(String reverse, int index) {
            this.reverse = reverse;
            this.index = index;
        }

        public String getReverse() {
            return reverse;
        }

        public void setReverse(String reverse) {
            this.reverse = reverse;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Solution.MapItem> reverses = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reverses.put(words[i], new Solution.MapItem(reverse(words[i]), i));
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Solution.MapItem reverseItem  = reverses.get(word);
            if (!word.equals(reverseItem.getReverse()) &&
                    reverses.containsKey(reverseItem.getReverse())) {
                List<Integer> item = new ArrayList<>();
                item.add(i);
                item.add(reverses.get(reverseItem.getReverse()).getIndex());
                result.add(item);
            }
            Iterator<String> keysit = reverses.keySet().iterator();
            while(keysit.hasNext())
            {
                String key = keysit.next();
                if (reverseItem.getReverse().length() < key.length()
                        && key.substring(key.length() - reverseItem.getReverse().length()).equals(reverseItem.getReverse()))
                {
                    int lastindex = key.lastIndexOf(reverseItem.getReverse());
                    String prefix = key.substring(0, lastindex);
                    if (ispalindrome(prefix))
                    {
                        List<Integer> item = new ArrayList<>();
                        item.add(i);
                        item.add(reverses.get(key).getIndex());
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private boolean ispalindrome(String word)
    {
        if (word.equals(reverse(word)))
        {
            return true;
        }
        return false;
    }

    public static void main(String args[])
    {
        Solution main =new Solution();
        String [] words = new String[]{"a", ""};
        List<List<Integer>> result = main.palindromePairs(words);
        System.out.println("hello");
    }
}
