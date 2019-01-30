package Occur3times;


import java.lang.reflect.Array;
import java.util.Arrays;

public class LC505TheMazeII {
    /**
     * distance[i][j] represents
     * the minimum number of steps required to reach the positon (i, j)(i,j)
     * starting from the startstart position.
     * This array is initialized with largest integer values in the beginning.
     */
    public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        if (distance[dest[0]][dest[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return distance[dest[0]][dest[1]];
    }

    private static void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;

            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }

            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0], y - dir[1]}, distance);
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 4};
        System.out.println(shortestDistance(maze, start, dest));
    }
}
