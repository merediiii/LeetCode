
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            if (a > b)
                if (!(a % 2 == 0 || a % 3 == 0 || a % 5 == 0 || a % 7 == 0 || a % 11 == 0 ||
                        a % 13 == 0 || a % 17 == 0 || a % 19 == 0 || a % 23 == 0 ||
                        a % 29 == 0 || a % 31 == 0 || a % 37 == 0 || a % 39 == 0))
                    System.out.println(a);
                else
                    for (long j = b; j > 0; j--) {
                        if (a % j == 0) {
                            System.out.println(a / j);
                            break;
                        }
                    }
            else
                System.out.println(1);

        }
    }

    public static Boolean isprime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int i, j, k;
        k = (int) Math.sqrt(n * 1.0);
        for (i = 3; i <= k; i += 2)
            if (n % i == 0) return false;
        return true;
    }
}
