public class MinFetchMath {
    public static void main(String[] args) {
        String A = "azaz";
        String B = "bza";

        System.out.println(getRes(A, B));
    }

    private static int getRes(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0, count = 0;

        while (true) {
            boolean move = false;
            while (i < m && j < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                    move = true;
                } else {
                    j++;
                }
            }
            if (!move) {
                return -1;
            }
            count++;
            if (i < m) {
                j = 0;
            } else if (i == m) {
                break;
            }
        }
        return count;
    }
}
