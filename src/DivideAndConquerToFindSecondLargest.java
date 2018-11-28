/**
 * divide and conquer with O(n) time complexity and minimum compare times
 */
public class DivideAndConquerToFindSecondLargest {
    static class Result {
        int max1;
        int max2;

        Result(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }
    public static void main(String[] args) {
        int[] A = {1, 5, 2, 4, 3};

        // Find first and second max elements
        Result res = FirstSecondMax(A, 0, 4);

        System.out.println("First one is : " + res.max1);
        System.out.println("Second one is : " + res.max2);
    }

    private static Result FirstSecondMax(int[] A, int l, int r) {
        Result res = new Result(A[l], A[r]);

        // if array has only one element return null record
        if (l == r) {
            return res;
        }

        // Base case when array has only two elements
        if (r - l == 1) {
            // if right element is greater than the left one
            // then right one is the first maximum
            if (A[r] >= A[l]) {
                res.max1 = A[r];
                res.max2 = A[l];
            } else {
                res.max1 = A[l];
                res.max2 = A[r];
            }
            return res;
        }

        // Find middle element
        int m = (l + r) / 2;

        // find the largest two elements in each half
        Result lres = FirstSecondMax(A, l, m);
        Result rres = FirstSecondMax(A, m + 1, r);

        // so far we got 4 max values 2 on each half
        // so we need to merge them and take out only two

        // First max on the right is greater than first max on the left
        if (rres.max1 >= lres.max1) {
            // Take the first max on the right
            res.max1 = rres.max1;

            // Compare second max on the right with first max on the left
            if (rres.max2 >= lres.max1) {
                res.max2 = rres.max2;
            } else {
                res.max2 = lres.max1;
            }
        } else {
            // First max on the left is greater that first max on the right
            res.max1 = lres.max1;

            // compare second max on the left with first max on the right
            if (lres.max2 >= rres.max1) {
                res.max2 = lres.max2;
            } else {
                res.max2 = rres.max1;
            }
        }
        return res;
    }
}
