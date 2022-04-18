package 数学;

public class clumsy {
    public static int f(int N) {

        char[] op = {'*', '/', '+', '-'};
        int a = N / 4;
        int b = N % 4;
        int sum = 0;
        int k = 1;
        for (int i = 1; i <= a; i++) {
            sum += k * N * (N - 1) / (N - 2) + (N - 3);
            N -= 4;
            k = -1;
        }
        if (b == 0)
            return sum;

        int tmp = 0;
        switch (b) {
            case 1:
                sum += k * N;
                break;
            case 2:
                sum += k * N * (N - 1);
                break;
            case 3:
                sum += k * N * (N - 1) / (N - 2);
                break;
            default:
                sum += k * N * (N - 1) / (N - 2) + N - 3;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
