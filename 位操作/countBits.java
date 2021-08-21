package 位操作;

public class countBits {
    public static int[] f(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        if (num < 2)
            return res;
        int k = 1;
        for (int i = 2; i < res.length; i++) {
            System.out.println(i + "\t" + res[i] + "\t" + (1 << (k + 1)));
            if (i != (1 << (k + 1)))
                res[i] = 1 + res[i - (1 << (k))];
            else {
                res[i] = 1;
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tmp = f(8);
        System.out.println();
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }

    }
}
