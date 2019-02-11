package LeetCodeGoogleTagSixMonths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinBlockLocation {
    public static void main(String[] args) {
        List<List<String>> street = new ArrayList<>();
        street.add(Arrays.asList("store", "school", "museum"));
        street.add(Arrays.asList("hospital", "restaurant"));
        street.add(Arrays.asList("school", "restaurant"));
        List<String> temp = new ArrayList<>();
        temp.add("");
        street.add(temp);

        List<String> temp1 = new ArrayList<>();
        temp1.add("museum");
        street.add(temp1);

        List<String> requirement = Arrays.asList("store", "museum", "restaurant");
        List<Integer> res = getRange(street, requirement);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }

    public static List<Integer> getRange(List<List<String>> street, List<String> requirement) {
        return new ArrayList<>();
    }
}
