package org.kakao19_intern;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P1_1_Claw_Machine_Game {
    public int solution(int[][] board, int[] moves) {

        Map<Integer, Deque<Integer>> stackBoard = createStackBoard(board);

        int removedDolls = pickDolls(stackBoard, moves);

        return removedDolls;
    }

    private Map<Integer, Deque<Integer>> createStackBoard(int[][] board) {

        Map<Integer, Deque<Integer>> stackBoard = new HashMap<>();

        for (int c = 0; c < board[0].length; c++) {
            Deque<Integer> columnStack = new ArrayDeque<>();

            for (int r = board.length - 1; r >= 0; r--) {
                if (board[r][c] != 0) {
                    columnStack.push(board[r][c]);
                }
            }
            stackBoard.put(c, columnStack);
        }

        return stackBoard;
    }

    private int pickDolls(Map<Integer, Deque<Integer>> stackBoard, int[] movements) {
        Deque<Integer> bucket = new ArrayDeque<>();
        int removedCounts = 0;

        for (int m : movements) {
            int pos = m - 1;

            if (stackBoard.containsKey(pos) && !stackBoard.get(pos).isEmpty()) {
                Integer pickedDoll = stackBoard.get(pos).pop();

                if (!bucket.isEmpty() && canRemoved(pickedDoll, bucket)) {
                    bucket.pop();
                    removedCounts += 2;
                } else {
                    bucket.push(pickedDoll);
                }
            }
        }

        return removedCounts;
    }

    private boolean canRemoved(Integer pickedDoll, Deque<Integer> bucket) {
        return bucket.peek().equals(pickedDoll);
    }
}
