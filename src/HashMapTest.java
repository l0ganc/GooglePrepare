import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<String, Boolean> map = new HashMap<>();
//        map.put("anc", true);
//        System.out.println(map.get("aasds"));
//        System.out.println(map.get("anc"));

        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        List<String> d1 = Arrays.asList("a","b","c");
        List<String> d2 = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        String s2 = "aewfafwafjlwajflwajflwafj";
        String s1 = "abpcplea";
        String s = "abpcplea";

//        System.out.println("res string is : " + findLongestWord(s, d));
//        System.out.println("res string is : " + findLongestWord(s1, d1));
        System.out.println("res string is : " + findLongestWord(s2, d2));

    }


    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> (a.length() == b.length()) ? a.compareTo(b) : b.length() - a.length());

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < d.size(); i++) {
            String word = d.get(i);

            int m = 0;
            int j = 0;
            while (m < word.length() && j < s.length()) {
                if (!map.containsKey(word.charAt(m))) {
                    break;
                }

                if (word.charAt(m) == s.charAt(j)) {
                    m++;
                    j++;
                } else {
                    while (j < s.length() && word.charAt(m) != s.charAt(j)) {
                        j++;
                    }
                    if (j == s.length()) {
                        break;
                    }
                    m++;
                    j++;

                }

                if (m == word.length()) {
                    return word;
                }
            }
        }
        return "";
    }
}
