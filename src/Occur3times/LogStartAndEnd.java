package Occur3times;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 有一个Class叫Logger，它有两个函数，一个是
 *      LogStart(int logId, int timestamp)，一个是
 *      LogFinish(int logId, int timestamp)。
 *   Log开始时LogStart会被调用，log结束时LogFinish会被调用。
 *   要求是实现这两个函数，并打印已经结束的log，打印log时要按log的开始时间排序。
 *
 * interface Logger {
 *   void started(long timestamp, String requestId);
 *   void finished(long timestamp, String requestId);
 * }
 *
 * started(100, "1")
 * started(101, "2")
 * finished(102, "2")
 * started(103, "3")
 * finished(104, "1")
 * finished(105, "3")
 *
 * Expected Output:
 * $1 start at 100 end at 104
 * $2 start at 101 end at 102
 * $3 start at 103 end at 105
 */
public class LogStartAndEnd {
    static HashMap<String, Long> startMap = new HashMap<>();
    static HashMap<String, Long> endMap = new HashMap<>();
    static TreeMap<Long, String> output = new TreeMap<>();

    public static void started(long timestamp, String requestId) {
        startMap.put(requestId, timestamp);
    }

    public static void finished(long timestamp, String requestId) {
        endMap.put(requestId, timestamp);
        //output.put()
    }
}
