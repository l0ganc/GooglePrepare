package RecentlyQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s，问能不能转化成另一个字符串p，条件是每次转换要把所有相同的字母一起变动，例子如: abca(两个a一起变) -> dbcd(变c) -> dbed(变b) -> dced。
 * 所以abca能转化成dced，return true。
 * 我目前只能想到：
 * 首先必须原来s中字符相等的几个位置，在p中都要被转化成同一个字符，否则 return false
 *
 * 如果有环，需要用中间tmp字符解开环后再变换
 * a->b->c->a需要变成a->b->c, c->k->a，这样解开字母之间的相互影响
 *
 * 如果tmp字符可以重复利用，一个tmp可以解开所有环，如果不能，一个环需要一个tmp字符
 *
 */
public class IsomorphicStringsBianzhong {

    private static boolean isomorphic(String s, String p) {
        if(s == null) return p == null;
        if(p == null) return s == null;
        if(s.length() != p.length()) return false;
        int tmpNum = 26;
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < str.length ; i++) {
            if(map.containsKey(str[i])) {
                if(map.get(str[i]) != pat[i]) return false;
            } else {
                map.put(str[i], pat[i]);
                tmpNum--;
            }
        }
        //if(tmpNum > 0) return true;
        boolean[] visited = new boolean[26];
        for(Character key: map.keySet()) {
            if(!visited[key - 'a']) {
                Character curr = key;
                while (!visited[curr - 'a']) {
                    visited[curr - 'a'] = true;
                    curr = map.get(curr);
                    if(curr == null) break;
                }
                if(curr != null) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isomorphic("abca", "dced"));
    }

}
