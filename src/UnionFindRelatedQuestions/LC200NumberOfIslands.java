package UnionFindRelatedQuestions;

/**
 * 经典题
 *
 * 尝试用Union Find做
 */

class UnionFind{
    int[] father;
    int m, n;
    int count = 0;

    UnionFind(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        father = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int id = i * n + j;   // 就是用一维的下标来遍历二维
                    father[id] = id;
                    count++;
                }
            }
        }
    }

    public void union(int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) {
            father[fa_x] = fa_y;
            count--;
        }
    }

    public int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
}
public class LC200NumberOfIslands {
    static int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int id1 = i * n + j;
                            int id2 = x * n + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }
}
