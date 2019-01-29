package Occur3times;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implement a magic directory with buildDict, and search methods.
 *
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 *
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
 *
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 */
public class LC676MagicDictionary {
    HashMap<Integer, List<String>> map;

    public LC676MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dict) {
        for (String str : dict) {
            int len = str.length();
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(str);
        }
    }

    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }

        for (String candidate : map.get(word.length())) {
            int misMathch = 0;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    misMathch++;
                }
            }

            if (misMathch == 1) {
                return true;
            }
        }
        return false;
    }

}
