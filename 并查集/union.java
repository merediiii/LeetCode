package 并查集;

public class union {
    public int[] ele;
    public int[] dep;

    public void init(int n) {
        ele = new int[n];
        dep = new int[n];
        for (int i = 0; i < n; i++) {
            ele[i] = i;
            dep[i] = 1;
        }
    }

    public int find(int n) {
        return n == find(n) ? n : (n = find(n));
    }

    public void merge(int m, int n) {
        if (find(m) == find(n)) return;
        if (dep[find(m)] <= dep[find(n)]) {
            ele[m] = n;
        } else
            ele[n] = m;
        if (dep[find(m)] == dep[find(n)])
            ele[n]++;
    }
}
