import java.util.Arrays;

public class SalaryControl {

    public static void main(String[] args) {
        int[] salary = new int[]{100, 200, 300, 400};
        int budget = 800;

        System.out.println(getRes(salary, budget));
    }

    private static int getRes(int[] salary, int budget) {
        int sum = 0;

        for (int num : salary) {
            sum += num;
        }

        int low = budget / salary.length;
        int high = salary[salary.length - 1];

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int temp = 0;
            for (int i = 0; i < salary.length; i++) {
                if (salary[i] <= mid) {
                    temp += salary[i];
                } else {
                    temp += mid;
                }
            }

            if (temp == budget) {
                return mid;
            } else if (temp > budget) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
