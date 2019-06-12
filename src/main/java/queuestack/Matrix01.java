package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    continue;
                } else {
                    int dist = bfs(matrix, new int[]{row, col});
                    matrix[row][col] = dist;
                }
            }
        }
        return matrix;
    }

    private int bfs(int[][] matrix, int[] index) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> loop = new LinkedList<>();
        loop.offer(index);
        int level = 0;
        while (!loop.isEmpty()) {
            level = level + 1;
            for (int i = 0; i < loop.size(); i++) {
                int[] start = loop.poll();
                for (int[] dir : dirs) {
                    int[] newIndex = new int[]{dir[0] + start[0], dir[1] + start[1]};
                    if (isValid(matrix, newIndex)) {
                        if (matrix[newIndex[0]][newIndex[1]] == 0) {
                            return level;
                        }
                        loop.offer(newIndex);
                    }
                }
            }

        }
        return level;
    }

    private boolean isValid(int[][] matrix, int[] index) {
        return index[0] >= 0 && index[0] < matrix.length &&
                index[1] >= 0 && index[1] < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        Matrix01 matrix01 = new Matrix01();
        matrix01.updateMatrix(test);
    }
}
