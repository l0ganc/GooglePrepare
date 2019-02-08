package Occur4times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *      time : O(m * n)
 *      space : O(n)
 *
 * 跟边界上的O相连的位置不需要改变，此外其他的O要编程X，
 * 因此需要从四个边界分别遍历，做DFS或者是BFS，最后剩下的元素如果还有O，那么必然是要转化为X的元素
 *
 *
 */
public class LC130SurroundedRegions {
    static char[][] grid = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };

    static char[][] grid1 = new char[][]{
            {'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X', 'X', 'X'}
    };
    public static void main(String[] args) {
        DFSSolve(grid);
        System.out.println("***********************");
        System.out.println("***********************");
        BFSSolve(grid);
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void BFSSolve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();

        // 从第一行、最后一行边界上的'O'元素开始做DFS遍历
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 'O') {
                grid[0][j] = '1';
                queue.add(new Point(0, j));
            }

            if (grid[m - 1][j] == 'O') {
                grid[m - 1][j] = '1';
                queue.add(new Point(m - 1, j));
            }
        }

        // 从第一列、最后一列边界上的'O'元素开始做DFS遍历
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                grid[i][0] = '1';
                queue.add(new Point(i, 0));
            }

            if (grid[i][n - 1] == 'O') {
                grid[i][n - 1] = '1';
                queue.add(new Point(i, n - 1));
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            if (x - 1 >= 0 && grid[x - 1][y] == 'O') {
                grid[x - 1][y] = '1';
                queue.add(new Point(x - 1, y));
            }
            if (x + 1 < grid.length && grid[x + 1][y] == 'O') {
                grid[x + 1][y] = '1';
                queue.add(new Point(x + 1, y));
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 'O') {
                grid[x][y - 1] = '1';
                queue.add(new Point(x, y - 1));
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == 'O') {
                grid[x][y + 1] = '1';
                queue.add(new Point(x, y + 1));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == '1') {
                    // 将边界上原先的'O'换回来（在DFS过程中将'O'换成了'1'）
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private static void DFSSolve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        int m = grid.length;
        int n = grid[0].length;

        // 从第一行、最后一行边界上的'O'元素开始做DFS遍历
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 'O') {
                dfs(grid, 0, j);
            }

            if (grid[m - 1][j] == 'O') {
                dfs(grid, m - 1, j);
            }
        }

        // 从第一列、最后一列边界上的'O'元素开始做DFS遍历
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                dfs(grid, i, 0);
            }

            if (grid[i][n - 1] == 'O') {
                dfs(grid, i, n - 1);
            }
        }

        // 剩下的都是需要变换的'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == '1') {
                    // 将边界上原先的'O'换回来（在DFS过程中将'O'换成了'1'）
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'O') {
            return;
        }

        grid[i][j] = '1';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
