import java.util.*;

public class IsExist {
    public static void main(String[] args) {
        String text = "please use this Google doc to doing your interview";
        List<String> words = Arrays.asList("please", "interview", "me");
        List<Boolean> res = getRes(text, words);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }

    private static List<Boolean> getRes(String text, List<String> words) {
        List<Boolean> res = new ArrayList<>();
        if (words == null || words.size() == 0) {
            return res;
        }

        Set<String> set = new HashSet<>();
        String[] test = text.split("\\s+");
        for (String s : test) {
            set.add(s);
        }

        for (int i = 0; i < words.size(); i++) {
            if (set.contains(words.get(i))) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
