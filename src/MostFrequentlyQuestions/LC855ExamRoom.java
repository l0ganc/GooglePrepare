package MostFrequentlyQuestions;

import java.util.TreeSet;

/**
 * 这个题目的目的是最大化每个两个相邻座位间的距离。
 * 思路是用TreeSet。因为Treeset中的元素是排好序的。
 */
public class LC855ExamRoom {
    static int N;
    static TreeSet<Integer> positions;

    public LC855ExamRoom(int N) {
        this.N = N;
        positions = new TreeSet<>();  // students中存放各个student考试的位置，按照位置从小到大
    }
    public static int seat() {
        int student = 0;
        if (positions.size() > 0) {
            // 已经有学生坐了，需要找另一个位置使得两个相邻同学之间距离最大化
            int firstDist = positions.first();   // 第一个同学坐的位置
            Integer prev = null;   // 第一个同学之前的同学坐的位置，初始化为null
            for (int pos : positions) {
                if (prev != null) {
                    int d = (pos - prev) / 2;
                    if (d > firstDist) {
                        firstDist = d;
                        student = prev + d;
                    }

                }
                prev = pos;
            }
            if (N - 1 - positions.last() > firstDist) {
                student = N - 1;
            }
        }
        positions.add(student);
        return student;
    }

    public static void leave(int p) {
        positions.remove(p);
    }

    public static void main(String[] args) {
        LC855ExamRoom obj = new LC855ExamRoom(10);
        System.out.println(seat());
        System.out.println(seat());
        System.out.println(seat());
        System.out.println(seat());
        leave(4);
        System.out.println(seat());
    }
}
