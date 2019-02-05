package RecentlyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class LC210CourseScheduleII {
    /**
     * 拓扑排序
     * 先构建dependency map，再DFS或BFS遍历
     * （DFS从头到尾各元素做DFS，途中碰到环false，BFS先扫一遍选出0dependency的种子点、每次减依赖、遍历后发现没全遍历则false）
     */

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];

        if (numCourses <= 0 || prerequisites == null) {
            return res;
        }

        // 建一张图
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] course : prerequisites) {
            inDegree[course[0]]++;
            if (graph.containsKey(course[1])) {
                graph.get(course[1]).add(course[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(course[0]);
                graph.put(course[1], list);
            }
        }

        int first = 0;
        int last = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                res[last++] = i;
            }
        }

        while (first < last) {
            List<Integer> subClass = graph.get(res[first]);
            if (subClass != null) {
                for (int sub : subClass) {
                    if (--inDegree[sub] == 0) {
                        res[last++] = sub;
                    }
                }
            }
            first++;
        }

        if (last != numCourses) {
            return new int[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int num = 4;
        int[][] prerequisites = new int[][]{
                {1,0}, {2,0}, {3,1}, {3,2}
        };
        System.out.println(Arrays.toString(findOrder(num, prerequisites)));
    }
}
