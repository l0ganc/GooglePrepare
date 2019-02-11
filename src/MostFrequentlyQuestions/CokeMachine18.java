package MostFrequentlyQuestions;

import java.util.*;

public class CokeMachine18 {
    public static void main(String[] args) {

        Soda soda1 = new Soda(100, 120);
        Soda soda2 = new Soda(200, 240);
        Soda soda3 = new Soda(400, 410);
        List<Soda> sodas = Arrays.asList(soda1,soda2, soda3);



        List<Integer> button1 = Arrays.asList(100, 120);
        List<Integer> button2 = Arrays.asList(200, 240);
        List<Integer> button3 = Arrays.asList(400, 410);
        List<List<Integer>> buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        System.out.println(coke(buttons, Arrays.asList(100, 110)));
        System.out.println(coke(buttons, Arrays.asList(90, 120)));
        System.out.println(coke(buttons, Arrays.asList(300, 360)));
        System.out.println(coke(buttons, Arrays.asList(310, 360)));

//        System.out.println("&&&&&&&&&&&");
//
//
//
//        System.out.println(dfs(sodas, 0, 0,
//                100, 110, new HashMap<>()));
//
//        System.out.println(dfs(sodas, 0, 0,
//                90, 120, new HashMap<>()));
//
//        System.out.println(dfs(sodas, 0, 0,
//                300, 360, new HashMap<>()));
//
//        System.out.println(dfs(sodas, 0, 0,
//                310, 360, new HashMap<>()));


    }

    public static boolean coke(List<List<Integer>> buttons, List<Integer> target) {
        int m = target.get(0);
        int n = target.get(1);
        boolean[][] dp = new boolean[m + 1][n + 1];

        //Init
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (List<Integer> button: buttons) {
                    if (i <= button.get(0) && j >= button.get(1)) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (List<Integer> button: buttons) {
                    int preL = i - button.get(0);
                    int preR = j - button.get(1);
                    if (preL >= 0 && preR >= 0 && dp[preL][preR]) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }

        return dp[m][n];
    }


    public static boolean dfs(List<Soda> sodas, int volumeLower, int volumeUpper, int targetLower,
                              int targetUpper, Map<String, Boolean> memo) {
        Boolean val = memo.get(volumeLower + "-" + volumeUpper);
        if (val != null) {
            return val;
        }
        if (volumeLower >= targetLower && volumeUpper <= targetUpper) {
            return true;
        }

        if (volumeUpper > targetUpper) {
            return false;
        }

        for (Soda soda : sodas) {
            if (dfs(sodas, volumeLower + soda.lower, volumeUpper + soda.upper,
                    targetLower, targetUpper, memo)) {
                memo.put(volumeLower + "-" + volumeUpper, true);
                return true;
            }
        }
        memo.put(volumeLower + "-" + volumeUpper, false);
        return false;
    }
}


class Soda {
    int lower;
    int upper;
    public Soda(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
}