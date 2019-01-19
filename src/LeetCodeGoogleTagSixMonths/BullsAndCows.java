package LeetCodeGoogleTagSixMonths;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            }
            else{
                nums1[s - '0']++;
                nums2[g - '0']++;
            }
        }
        int cows = 0;
        for(int i = 0; i < 10; i++){
            cows += Math.min(nums1[i], nums2[i]);
        }
        String res = bulls + "A" + cows + "B";
        return res;
    }
}
