package MostFrequentlyQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 把人和自行车配对，输出vector<pair<int, int>>每个人对应的自行车. {i, j} 是人i对应自行车j
 *
 * 2D平面上，有m个人（P），n辆自行车(B)，还有空白（O）满足以下条件
 * 1.m < n
 * 2.不存在两个人，到同一辆自行车距离相等, 距离用abs(x1-x2) + abs(y1-y2)定义
 * 3.每个人尽量找离自己最近的自行车，一旦某辆自行车被占，其他人只能找别的自行车。
 * 例：
 * OPOBOOP
 * OOOOOOO
 * OO#OOOO
 * #OOO#OO
 * BOOBOOB
 *
 */

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class HumanBikeMatch {
    public Pair BFS(char[][] grid, Pair employee) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(employee);
        visited[employee.x][employee.y] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (grid[cur.x][cur.y] == '#') {
                continue;
            }
            if (grid[cur.x][cur.y] == 'B') {
                return cur;
            }

            if (cur.x + 1 < grid.length && !visited[cur.x + 1][cur.y]) {
                queue.add(new Pair(cur.x + 1, cur.y));
                visited[cur.x + 1][cur.y] = true;
            }

            if (cur.x - 1 >= 0 && !visited[cur.x - 1][cur.y]) {
                queue.add(new Pair(cur.x - 1, cur.y));
                visited[cur.x - 1][cur.y] = true;
            }

            if (cur.y - 1 >= 0 && !visited[cur.x][cur.y - 1]) {
                queue.add(new Pair(cur.x, cur.y - 1));
                visited[cur.x][cur.y - 1] = true;
            }

            if (cur.y + 1 < grid[0].length && !visited[cur.x][cur.y + 1]) {
                queue.add(new Pair(cur.x, cur.y + 1));
                visited[cur.x][cur.y + 1] = true;
            }
        }
        return null;
    }
}
