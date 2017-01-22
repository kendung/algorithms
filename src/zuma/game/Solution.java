package zuma.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xudeng on 1/21/17.
 */
public class Solution {

    private int min = -1;

    private static class BallItem {
        public char color;
        public int count;
    }

    public int findMinStep(String board, String hand) {
        backtrack(0, board, hand);
        return min;
    }

    private void backtrack(int treelevel, String board,
                           String hand) {
        if (hand.length() == 0) {
            return;
        }
        List<BallItem> ballItems = organizeBoard(board);
        for (BallItem item : ballItems) {
            // pick item to do zuma game
            if (hand.indexOf(item.color) == -1) {
                continue;
            } else {
                int index = hand.indexOf(item.color);
                StringBuilder sb = new StringBuilder(hand);
                hand = sb.deleteCharAt(index).toString();
                item.count = item.count + 1;
                List<BallItem> newBallItems = chainReactionForBoard(organizeBoard(getBoard(ballItems)));
                if (newBallItems.size() == 0) {
                    if (min == -1) {
                        min = treelevel + 1;
                    } else if (treelevel + 1 < min) {
                        min = treelevel + 1;
                    }
                } else {
                    backtrack(treelevel + 1, getBoard(newBallItems), hand);
                    hand = sb.append(item.color).toString();
                    item.count = item.count - 1;
                }

            }
        }
    }

    private String getBoard(List<BallItem> items) {
        StringBuffer sb = new StringBuffer();
        for (BallItem item : items) {
            for (int i = 0; i < item.count; i++) {
                sb.append(item.color);
            }
        }
        return sb.toString();
    }

    private List<BallItem> organizeBoard(String board) {
        List<BallItem> balls = new ArrayList<>();
        if (board == null || board.length() == 0) {
            return balls;
        }
        int i = 0;
        while (i < board.length()) {
            BallItem item = new BallItem();
            item.color = board.charAt(i);
            item.count = 1;
            balls.add(item);
            int j = i + 1;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                item.count = item.count + 1;
                j++;
            }
            i = j;
        }
        return balls;
    }

    private List<BallItem> chainReactionForBoard(List<BallItem> organizedBoard) {
        boolean reaction;
        do {
            reaction = false;
            Iterator<BallItem> it = organizedBoard.iterator();
            while (it.hasNext()) {
                BallItem item = it.next();
                if (item.count >= 3) {
                    reaction = true;
                    it.remove();
                    break;
                }
            }
            if (reaction) {
                organizedBoard = organizeBoard(getBoard(organizedBoard));
            }

        } while (reaction);
        return organizedBoard;
    }

    public static void main(String args[]) {
        Solution main = new Solution();
        System.out.println(main.findMinStep("RBYYBBRRB", "YRBGB"));
    }

}
