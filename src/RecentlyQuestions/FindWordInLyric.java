package RecentlyQuestions;

import java.util.*;

/**
 * 题目：给一个品牌名和一句歌词， 按顺序使用歌词中的单词里的字母，问是否能拼出品牌名。
 *
 * 比如歌词是”I do not want to have to go where you do not follow”
 * 品牌名 “wow” 就可以被拼出来 want to follow. check 1point3acres for more.
 * 但是品牌名 “abc”就不行
 *
 * 每个单词只能用一次，而且是按顺序使用，然后就讲了想法
 *
 * follow up: 就是如果有一堆的品牌名，每一个都需要被check是不是能用这句歌词拼出来，
 * 要怎么做。讲了思路，面试官提出需要improvement, 于是调整了下思路，面试官觉得可以，然后就写了代码。
 */
public class FindWordInLyric {
    public static boolean isSub(String sentence, String brand) {
        String[] arr = sentence.split("\\s+");
        int i = 0;
        int j = 0;

        for (; i < arr.length; i++) {
            for (char c : arr[i].toCharArray()) {
                if (c == brand.charAt(j)) {
                    j++;
                    if (j == brand.length()) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    private static List<String> isSubFollowUp(String sentence, String[] brand) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        String[] array = sentence.split("\\s+");
        List<String> res= new ArrayList<String>();
        for (int i = 0;i < array.length; i++) {
            for (char n : array[i].toCharArray()) {
                if (!map.containsKey(n)) {
                    map.put(n, new TreeSet<Integer>());
                }
                map.get(n).add(i);
            }
        }

        for (String n : brand) {
            int prev = -1;
            char[] charArray = n.toCharArray();
            for (int i = 0; i < charArray.length; i++) {

                if (!map.containsKey(charArray[i])) {
                    break;
                }
                TreeSet<Integer> set = map.get(charArray[i]);
                if (set.ceiling(prev) != null) {
                    if (i == charArray.length - 1) {
                        res.add(n);
                    }
                    prev = set.ceiling(prev) + 1;
                } else {
                    break;
                }

            }
        }
        return res;

    }

    public static void main(String[] args) {
        String sentence = "I do not want to have to go where you do not follow";
        String brand = "wow";
        System.out.println(isSub(sentence, brand));
    }
}
