import java.util.HashSet;

public class MinimumRectangle {
    public static int getMinimumRect(int[][] arr) {
        int res = 100;
        HashSet<String> set = new HashSet<>();


        for(int [] a:arr){
            set.add(makeString(a));
        }

        for(int i = 0;i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                int[] leftBottom = arr[i];
                int[] rightTop = arr[j];
                int[] leftTop = new int[]{leftBottom[0], rightTop[1]};
                String lt = makeString(leftTop);


                int[] rightBottom = new int[]{rightTop[0], leftBottom[1]};
                String rb = makeString(rightBottom);

                if(set.contains(lt) && set.contains(rb)){
                    int size = Math.abs((rightTop[0] - leftBottom[0]) * (rightTop[1] - leftBottom[1]));
                    if(size>0){
                        res = Math.min(res, size);
                    }

                }
            }
        }
        return res;
    }

    private static String makeString(int[] a) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(a[0]));
        sb.append("-");
        sb.append(String.valueOf(a[1]));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1}, {1,3}, {1,4}, {3,1}, {1,-1}, {3,-1}, {2,5}, {6,7}, {0,4}, {5,5}, {9,3}};
        System.out.println(getMinimumRect(arr));
    }
}
