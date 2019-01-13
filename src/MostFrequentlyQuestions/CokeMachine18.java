package MostFrequentlyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CokeMachine18 {
    public static void main(String[] args) {
        List<Soda> sodas = Arrays.asList(new Soda(100, 120),
                new Soda(200, 240),
                new Soda(400, 410));
        Soda soda1 = new Soda(100, 110);
        Soda soda2 = new Soda(90, 120);
        Soda soda3 = new Soda(300, 360);
        Soda soda4 = new Soda(310, 360);

        System.out.println(dfs(sodas, ));

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