import java.util.HashMap;

public class SportNumber {
    public static void main(String[] args) {
        String num = "88";
        System.out.println(getRes(num));
    }

    private static boolean getRes(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '!');
        map.put('3', '@');
        map.put('4', '$');
        map.put('5', '%');
        map.put('6', '9');
        map.put('7', '^');
        map.put('8', '8');
        map.put('9', '6');

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            sb.insert(0, map.get(c));
        }
        System.out.println(sb.toString());
        return sb.toString().equals(num);
    }
}
