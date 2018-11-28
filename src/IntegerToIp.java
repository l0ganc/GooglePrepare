public class IntegerToIp {
    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println("转换后的ip地址是 : " + getRes(a));
    }

    private static String getRes(int a) {
        if (a == 0) {
            return "0.0.0.0";
        } else if (a == 1) {
            return "0.0.0.1";
        }

        // convert num a into 32 bits binary, and store it in String s
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char)(((a >> i) & 1) + '0');
        }
        String s = new String(chs);
        //System.out.println(new String(chs));

        String one = s.substring(0, 8);
        String two = s.substring(8, 16);
        String three = s.substring(16, 24);
        String four = s.substring(24, 32);

        StringBuilder res = new StringBuilder();
        String oneInt = Integer.parseInt(one, 2) + "";
        String twoInt = Integer.parseInt(two, 2) + "";
        String threeInt = Integer.parseInt(three, 2) + "";
        String fourInt = Integer.parseInt(four, 2) + "";

        res.append(oneInt).append(".").append(twoInt).append(".").append(threeInt).append(".").append(fourInt);

        return res.toString();


    }
}
