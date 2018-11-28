import java.util.*;

public class DistinctSubSeq {

    public static void main(String[] args) {
        String str = "aaa";
        Set<String> res = getRes(str);

        System.out.println(res.size() - 1);
    }

    private static Set<String> getRes(String S) {
        Set<String> res = new HashSet<>();
        Helper(S, res, 0, new StringBuilder());
        return res;
    }

    private static  void Helper(String S, Set<String> res, int start, StringBuilder sb) {
        res.add(sb.toString());
        for (int i = start; i < S.length(); i++) {
            sb.append(S.charAt(i));
            Helper(S, res, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
