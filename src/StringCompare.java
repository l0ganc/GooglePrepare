public class StringCompare {
    public static void main(String[] args) {
        String s1 = "she is running";
        String s2 = "she is runnin";

        System.out.println('a' - 'a');

        System.out.println(getRes(s1, s2));
    }

    private static boolean getRes(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return true;
        }

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        int i = 0, j = 0;

        while (i < arr1.length && arr1[i].equals(arr2[i])) {
            i++;
        }
        j = arr1.length - 1;
        while (j >= i) {
            if (arr1[j] != arr2[j]) {
                return false;
            }
            j--;
        }
        return true;
    }
}
