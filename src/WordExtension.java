import java.util.ArrayList;
import java.util.List;

public class WordExtension {
    public static void main(String[] args) {
        String s1 = "hellooooo";
        String s2 = "helllooooo";
        List<List<Integer>> res = getRes(s1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        System.out.println("the result list is : " + getRes(s1));
//        System.out.println("the result list is : " + getRes(s2));
    }

    private static List<List<Integer>> getRes(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int i = 0;
        int j = 1;
        while (i < s.length() && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                i++;
                j++;
            } else {
                while (s.charAt(i) == s.charAt(j)) {
                    j++;
                    if (j == s.length()) {
                        break;
                    }
                }
                if (j - i <= 2) {
                    continue;
                }
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                cur.add(j - 1);
                res.add(cur);
                i = j;
            }
        }
        return res;
    }
}
