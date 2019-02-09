package MostFrequentlyQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计⼀一个Map, get() 和 set() function,
 * 每个set同时还set⼀一个expiration time, get 的时候如果expire了了就返回null， 这个⽤用普通hashmap就能解决
 * follow up 加⼀一个clean function，clean所有expire的entry，我就加了了⼀一个 heap解决，到这⾥里里⼤大概30分钟不不到
 */
public class HashMapWithExpirationTime {
    Map<String, String> valuePair;
    Map<String, Long> timePair;

    public HashMapWithExpirationTime() {
        valuePair = new HashMap<>();
        timePair = new HashMap<>();
    }

    public void put(String key, String value, Long time) {
        valuePair.put(key, value);
        long expiredTime = System.currentTimeMillis() + time;
        timePair.put(key, expiredTime);
    }

    public String get(String key) {
        long now = System.currentTimeMillis();
        Long expiredTime = timePair.get(key);
        if (Double.compare(now, expiredTime) > 0) {
            valuePair.remove(key);
            timePair.remove(key);
            return null;
        } else {
            return valuePair.get(key);
        }
    }

    public Thread cleanThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (String key : valuePair.keySet()) {
                    get(key);
                }
            }
        }
    });
}
