package MostFrequentlyQuestions;


import java.util.*;

public class LC843GuessTheWord {
    public static void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String word = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(word);
            List<String> list = new ArrayList<>();

            for (String s : wordlist) {
                if (match(s, word) == x) {
                    list.add(s);
                }
            }
            wordlist = list.toArray(new String[list.size()]);
        }
    }

    public static int match(String s, String word) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == word.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public static void findSecretWordII(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for (String str : wordlist) {
            list.add(str);
        }

        for (int i = 0; i < 10; i++) {
            Map<String, Integer> zeroMatch = new HashMap<>();
            for (String s1 : list) {
                zeroMatch.putIfAbsent(s1, 0);
                for (String s2 : list) {
                    if (match(s1, s2) == 0) {
                        zeroMatch.put(s1, zeroMatch.get(s1) + 1);
                    }
                }
            }

            Pair pair = new Pair("", 101);
            for (String key : zeroMatch.keySet()) {
                if (zeroMatch.get(key) < pair.freq) {
                    pair = new Pair(key, zeroMatch.get(key));
                }
            }

            int matchNum = master.guess(pair.key);
            if (matchNum == 6) return;
            List<String> tmp = new ArrayList<>();
            for (String s : list) {
                if (match(s, pair.key) == matchNum) {
                    tmp.add(s);
                }
            }
            list = tmp;
        }

    }
}

class Master{
    public int guess(String word) {
        return 1;
    }
}

class Pair {
    String key;
    int freq;
    public Pair(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}

