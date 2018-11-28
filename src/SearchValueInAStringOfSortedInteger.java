public class SearchValueInAStringOfSortedInteger {
    public static void main(String[] args) {
        String str = "1 3 5 7 11 18 100";
        String target = "7";
        System.out.println(getRes(str, target));
    }

    private static boolean getRes(String str, String target) {
        return str.contains(target);
    }
}
