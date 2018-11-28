public class SanjiaoArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 10, 6, 5, 3, 2};

        System.out.println(getRes(arr));
    }

    private static boolean getRes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int i = 0;
        while (i < arr.length) {
            if (arr[i] < arr[i + 1]) {
                i++;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                break;
            }
        }

        // current i mean the max value's index
        while (i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
