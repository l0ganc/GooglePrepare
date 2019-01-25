package MostFrequentlyQuestions;

import java.util.*;

public class CokeMachine18 {
    public static void main(String[] args) {

        Soda soda1 = new Soda(100, 120);
        Soda soda2 = new Soda(200, 240);
        Soda soda3 = new Soda(400, 410);
        List<Soda> sodas = Arrays.asList(soda1,soda2, soda3);

        System.out.println(dfs(sodas, 0, 0,
                100, 110, new HashMap<>()));

        System.out.println(dfs(sodas, 0, 0,
                90, 120, new HashMap<>()));

        System.out.println(dfs(sodas, 0, 0,
                300, 360, new HashMap<>()));

        System.out.println(dfs(sodas, 0, 0,
                310, 360, new HashMap<>()));


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