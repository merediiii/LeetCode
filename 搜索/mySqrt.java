package 搜索;

public class mySqrt {

    public int f(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (m * m == x)
                return m;
            else if (m * m < x) {
                l = m + 1;
            } else
                r = m - 1;
        }
        return l;

    }
}
