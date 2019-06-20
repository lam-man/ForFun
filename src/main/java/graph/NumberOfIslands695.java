package graph;

public class NumberOfIslands695 {
    private int tempArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        // corner case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return maxArea;
        }

        // loop grid to check node and get maxArea
        int rows = grid.length, cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    Index index = new Index(row, col);
                    tempArea = 0;
                    dfs(index, grid);
                    maxArea = Math.max(tempArea, maxArea);
                }
            }
        }

        return maxArea;
    }

//     private int dfs(Index index, int[][] grid) {
//         int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//         Stack<Index> stack = new Stack<>();
//         stack.push(index);
//         grid[index.row][index.col] = 2;
//         int tempArea = 0;

//         while (!stack.isEmpty()) {
//             int stackSize = stack.size();
//             for (int i = 0; i < stackSize; i++) {
//                 Index current = stack.pop();
//                 tempArea++;
//                 // mark
//                 for (int[] dir : dirs) {
//                     Index next = new Index(dir[0] + current.row, dir[1] + current.col);
//                     if (isValid(next, grid)) {
//                         grid[next.row][next.col] = 2;
//                         stack.push(next);
//                     }
//                 }
//             }
//         }
//         return tempArea;
//     }

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(Index index, int[][] grid) {
        grid[index.row][index.col] = 2;
        tempArea++;
        for (int[] dir : dirs) {
            Index next = new Index(index.row + dir[0], index.col + dir[1]);
            if (isValid(next, grid)) {
                dfs(next, grid);
            }
        }
    }

    // [[1,1,0,0,0],
    //  [1,1,0,0,0],
    //  [0,0,0,1,1],
    //  [0,0,0,1,1]]

    private boolean isValid(Index index, int[][] grid) {
        if (index.row < 0 || index.row >= grid.length || index.col < 0 || index.col >= grid[0].length) {
            return false;
        }
        return grid[index.row][index.col] == 1;
    }
}

class Index {
    int row;
    int col;
    public Index(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
