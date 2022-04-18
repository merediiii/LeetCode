package 动态规划;

public class divisorGame {
    public static boolean f(int N) {
        if (N == 2)
            return true;
        if (N == 3 || N == 1)
            return false;
        boolean[] victory = new boolean[N + 1];
        victory[1] = false;
        victory[2] = true;
        victory[3] = false;
        for (int i = 4; i < N + 1; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    victory[i] |= !victory[i - j];
            }
        }
        return victory[N];
    }

    public static void main(String[] args) {
        System.out.println(f(5));

    }
}
