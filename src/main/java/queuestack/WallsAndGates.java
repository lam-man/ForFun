package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private static final int[][] deltas =
            {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean isValid(int[][] rooms, Index index) {
        if (index.row < 0 || index.col < 0 ||
                index.row >= rooms.length || index.col >= rooms[0].length) {
            return false;
        }

        return rooms[index.row][index.col] == Integer.MAX_VALUE;
    }

    public void wallsAndGates(int[][] rooms) {
        Queue<Index> queue = new LinkedList<Index>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Index(i, j));
                }
            }
        }

        int length = 0;
        while (!queue.isEmpty()) {
            length++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Index index = queue.poll();
                for (int[] delta : deltas) {
                    Index nextIndex = new Index(index.row + delta[0], index.col + delta[1]);
                }
            }
        }
    }

    private class Index {
        int row;
        int col;

        Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}