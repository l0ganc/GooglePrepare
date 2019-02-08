package Occur4times;

/**
 * 输入一个围棋棋盘，和一个黑棋子坐标，判断这个棋子是活是死，就是search找有没有和黑棋子相连的空格
 * follow up: 比如现在每个棋子都有一个status变量，代表这个地方是死是活，问题是当下一个棋子的时候如何更新棋子的status
 * 判断在一个棋盘上给定的棋子所在的片区有没有气，只要有一个气（空格），这片棋就没死
 *
 * 给一个围棋棋盘，写一个function判断某一个白子是否是死子，即上下左右四个方向都被黑子包围。
 * 也需要能判断一团白子是不是死子，即这团白子上下左右四个方向都被黑子包围。用bfs解。
 * follow up是数出整个棋盘有多少个死掉的白子，和number of island类似. 我先说对于每个棋盘的白子，
 * call 第一问的function，time n^4, 白人姐姐觉得太慢，我就把number of island解法说了一遍，满意，迅速写完。
 * 她再指出我没有handle整个棋盘都是白子的case，我说是，我没想到，结束。
 *
 *
 * BBBBB
 * BAA B
 * BBBBB
 *
 * 以上的AA棋子就没死， 因为还有个空格，还有气
 */
public class XiaWeiqi {
    static int val;   // 1: black, -1: white, 0: empty
    /**
     * 围棋问题，可以用queue做BFS或用recursion做DFS.
     * 判断一片棋子死活就是判断有没有空格邻居。类似Leetcode "number of islands".
     */
    public static boolean isAlive(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j > matrix[0].length || matrix[i][j] == 0) {
            return false;
        }

        val = matrix[i][j];
        return findEmptyNeignbour(matrix, i, j);
    }

    private static boolean findEmptyNeignbour(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ||
        matrix[i][j] == Integer.MAX_VALUE || matrix[i][j] == -val) {
            return false;
        }
        if (matrix[i][j] == 0) {
            return true;
        }

        // set as visited
        matrix[i][j] = Integer.MAX_VALUE;
        return (findEmptyNeignbour(matrix, i + 1, j) ||
                findEmptyNeignbour(matrix, i - 1, j) ||
                findEmptyNeignbour(matrix, i, j + 1) ||
                findEmptyNeignbour(matrix, i, j - 1));
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 1, 1, 1, 1},
                {1, -1, 0, 1, 1, 1},
                {1, -1, -1, 1, 1, 1},
                {1, -1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(isAlive(matrix, 1, 1));
        System.out.println(isAlive(matrix, 2, 1));
        System.out.println(isAlive(matrix, 2, 2));
        System.out.println(isAlive(matrix, 3, 1));
        System.out.println(isAlive(matrix, 3, 2));
        System.out.println(isAlive(matrix, 1, 2));
    }
}
