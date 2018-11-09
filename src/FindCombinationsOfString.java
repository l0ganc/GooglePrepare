import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * find all combinations of a string
 * 找出所有char的combination，不止是substring
 */
public class FindCombinationsOfString {

    private static Set<String> getCombinations(String s) {
        Set<String> res = new HashSet<>();
        helper(res, s, 0, new StringBuilder());
        return res;
    }

    private static void helper(Set<String> res, String s, int start, StringBuilder sb) {
        res.add(sb.toString());
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(res, s, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input your string : ");
        String str = sc.next();
        Set<String> res = getCombinations(str);
        for (String s : res) {
            System.out.print(s +  ", ");
        }
    }

}
