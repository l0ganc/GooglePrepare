package RecentlyQuestions;

/**
 *
 On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

 Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

 What is the largest possible number of moves we can make?



 Example 1:

 Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 Output: 5
 */
public class LC947MostStonesRemovedwithSameRoworColumn {
    static boolean[] visited;
    static int[][] input;
    static int i;

    public static int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0 || stones[0].length == 0) {
            return 0;
        }
        input = stones;
        visited = new boolean[stones.length];
        int count = 0;
        i = 0;

        while (i < stones.length) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                int x = input[i][0];
                int y = input[i][1];
                DFS(x, y);
            }
            i++;
        }
        return visited.length - count;
    }

    private static void DFS(int x, int y) {
        for (int j = i + 1; j < visited.length; j++) {
            if (input[j][0] == x || input[j][1] == y) {
                if (!visited[j]) {
                    visited[j] = true;
                    DFS(input[j][0], input[j][1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] stones = new int[][]{
                {0,0},{0,1},{1,0},{1,2},{2,1},{2,2}
        };

        int[][] stones1 = new int[][]{
                {0,0},{0,2},{1,1},{2,0},{2,2}
        };

        int[][] stones2 = new int[][]{{0,0}};

        System.out.println(removeStones(stones));
        System.out.println(removeStones(stones1));
        System.out.println(removeStones(stones2));
    }
}
