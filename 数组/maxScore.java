package 数组;

public class maxScore {

    public static void p(int... obj) {
        for (Object b : obj) {
            System.out.print(b + "\t");
        }
        System.out.println();
    }

    public static int f(int[] cardPoints, int k) {
        int l = 0;
        int r = 0;
        int i = 0;
        k = cardPoints.length - k;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int total = 0;
        while (r < cardPoints.length) {
            total += cardPoints[r];
            sum += cardPoints[r];
            if (r - l + 1 == k) {
                min = Math.min(min, sum);
                sum -= cardPoints[l++];
            }
            r++;
            p(min, sum);
        }
        return k == 0 ? total : total - min;
    }

    public static void main(String[] args) {
        int[] re = new int[]{1, 2, 3, 4, 5, 6, 1};
        System.out.println(f(re, 3));
    }
}
