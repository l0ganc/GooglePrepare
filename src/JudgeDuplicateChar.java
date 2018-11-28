import java.util.Scanner;


/**
 * two solutions
 * Approach 3 – Use of Extra Data Structure:
 * This approach assumes ASCII char set(8 bits).
 * The idea is to maintain a boolean array for the characters.
 * The 256 indices represent 256 characters. All the array elements are initially set to false.
 * As we iterate over the string, set true at the index equal to the int value of the character.
 * If at any time, we encounter that the array value is already true, it means the character with that int value is repeated.
 *
 * Time Complexity: O(n)
 */
public class JudgeDuplicateChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 << 3 == " + (1 << 3));
        System.out.print("Please input your string: ");
        String str = sc.next();
        boolean res = getRes4(str);
        if (res) {
            System.out.println("The str " + str + " contains duplicate character!");
        } else {
            System.out.println("The str " + str + " doesn't contain duplicate character!");
        }

    }

    private static boolean getRes3(String str) {
        if (str == null || str.length() == 0 || str.length() > 256) {
            return false;
        }

        boolean[] arr = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);
            if (arr[index]) {
                return true;
            }
            arr[index] = true;

        }
        return false;
    }


    /**
     *Approach 4 – Without Extra Data Structure: The approach is valid for strings having alphabet as a-z.
     * This approach is little tricky. Instead of maintaining a boolean array, we maintain an integer value called checker(32 bits).
     * As we iterate over the string, we find the int value of the character with respect to ‘a’ with the statement int bitAtIndex = str.charAt(i)-‘a’;
     * Then the bit at that int value is set to 1 with the statement 1 << bitAtIndex .
     * Now, if this bit is already set in the checker, the bit AND operation would make checker > 0. Return false in this case.
     * Else Update checker to make the bit 1 at that index with the statement checker = checker | (1 <<bitAtIndex);
     *
     * Time Complexity: O(n)
     */
    private static boolean getRes4(String str) {
        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';

            // if that bit is already set in checker, return false
            if ((checker & (1 << bitAtIndex)) > 0) {
                return true;
            }

            // otherwise update and continue by setting that bit in the checker
            checker = checker | (1 << bitAtIndex);
        }

        // no duplicate encountered, return false;
        return false;
    }
}
