import javax.xml.stream.FactoryConfigurationError;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class fib {


    static Scanner sc = new Scanner(System.in);


    static int f(int n) {
        int[] tmp = new int[n / 100 + 1];
        tmp[0] = 1;
        tmp[1] = 1;
        n = n / 100;
        if (n == 0) return 1;
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            tmp[i] = tmp[i - 1] + tmp[i - 2];

        }
        for (int i = 1; i <= n; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
        return tmp[n];
    }

    public static void main(String[] args) throws IOException {
        int num = sc.nextInt();
        System.out.println(f(num));

    }


}
