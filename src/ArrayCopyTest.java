import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println(Arrays.toString(b));
        System.out.println('a' < 'b');
    }
}
