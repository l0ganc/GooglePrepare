package RecentlyQuestions;

/**
 * 给三个integers, 判断这三个integers组成的（a,b,c）是否构成一个valid date.
 *    yyyy-MM-dd也算valid， MM-dd-yyyy也算valid， 要考虑所以可能的合法的date格式。
 * 补充：
 * 给三个integer，然后可以让这三个integer分别作为year, month 和day，然后看他们能不能组成一个有效的日期
 *  注意corner case
 *
 *  思路：
 *  考虑leap year和non-leap year
 *  考虑负数和0
 *  月份范围1-12
 *  day范围1-31
 *  year范围正整数
 */
public class ThreeIntegerValidDate {
    static int[] days = new int[]{
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    public static boolean canForm(int[] nums) {
        return firstFrom(nums, 0);
    }

    // yyyy-mm-dd
    private static boolean firstFrom(int[] nums, int curr) {
        if(curr >= nums.length) return true;
        for(int i = curr ; i < nums.length ; i++) {
            if(curr == 0) {
                if(nums[i] > 0) {
                    swap(nums, curr, i);
                    if(firstFrom(nums, curr + 1)) return true;
                    swap(nums, curr, i);
                }
            } else if(curr == 1) {
                if(nums[i] >= 1 && nums[i] <= 12) {
                    swap(nums, curr, i);
                    if(firstFrom(nums, curr + 1)) return true;
                    swap(nums, curr, i);
                }
            } else {
                int year = nums[0];
                int month = nums[1];
                if(month == 2) {
                    // leap year
                    if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        if(nums[i] >= 1 && nums[i] <= 29) return true;
                    } else {
                        if(nums[i] >= 1 && nums[i] <= 28) return false;
                    }
                } else {
                    if(nums[i] >= 1 && nums[i] <= days[month-1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2019, 2, 4};
        System.out.println(canForm(nums));
    }

}
