package MostFrequentlyQuestions;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}

class Master{
    public int guess(String word) {}
}
