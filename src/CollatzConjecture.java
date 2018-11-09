//import java.util.Scanner;
//
//public class CollatzConjecture {
//    private static int getRes(int n) {
//        int res = 0;
//        int tempStep = 0;
//
//        for (int i = 1; i <= n; i++) {
//            tempStep = calStep(i);
//            System.out.println("the steps to convert " + i + " to 1 is " + tempStep);
//            res = Math.max(res, tempStep);
//        }
//        return res;
//    }
//
//
//    private static int calStep(int num) {
//        if (num <= 1) {
//            return 0;
//        }
//
//        if (num % 2 == 0) {
//            return 1 + calStep(num / 2);
//        }
//
//        return 1 + calStep(num * 3 + 1);
//    }
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Please input your number : ");
//        int n = sc.nextInt();
//        System.out.println("res is : " + getRes(n));
//    }
//}


/**
 * method 2
 * using HashMap
 */

import java.util.HashMap;
import java.util.Scanner;

public class CollatzConjecture {
    static HashMap<Integer, Integer> map = new HashMap<>();


    private static int getRes(int n) {
        int tempStep = 0;
        if (n < 1) {
            return 0;
        }
        int res = 0;


        for (int i = 1; i <= n; i++) {
            tempStep = calStep(i);
            System.out.println("the steps to convert " + i + " to 1 is " + tempStep);
            map.put(i, tempStep);
            res = Math.max(res, tempStep);
        }
        return res;
    }


    private static int calStep(int num) {
        if (num <= 1) {
            return 0;
        }

        if (map.containsKey(num)) {
            return map.get(num);
        }

        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }

        if (map.containsKey(num)) {
            return map.get(num) + 1;
        }

        int t = calStep(num);
        map.put(num, t);
        return t + 1;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your number : ");
        int n = sc.nextInt();
        System.out.println("res is : " + getRes(n));
    }
}

