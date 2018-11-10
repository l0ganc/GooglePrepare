public class SkipSpace {
    private static char[] getRes(char[] arr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != '*') {
                sb.append(arr[i]);
            } else if (arr[i] == '*') {
                sb.append('*');
                while (i + 1 < arr.length && arr[i + 1] == '*') {
                    i++;
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString().toCharArray();
    }


    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', '*', '*', '*', 'c'};

        char[] res = getRes(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(arr + " ");
        }

    }
}
