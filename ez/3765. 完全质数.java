package ez;

import java.util.Arrays;
import java.util.Random;

class completePrime {
    int pre[];
    int post[];

    private boolean isPrime(int x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        int limit = (int) Math.sqrt(x);
        for (int i = 3; i <= limit; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }


    public boolean completePrime(int num) {
        int len = String.valueOf(num).length();
        pre = new int[len];
        post = new int[len];
        if(len == 1) return isPrime(num);
        for (int i = 1; i <= len; i++) {
            pre[len - i] = (int) (num / Math.pow(10 , i-1));
            post[i-1] = (int) (num % (Math.pow(10 , i)));
        }
        boolean res = true;
        for (int i = 0; i < len; i++) {
            res &= isPrime(pre[i]) && isPrime(post[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        completePrime solution = new completePrime();
        Random random = new Random();
        int num = random.nextInt(17);
        System.out.println(num);
        System.out.println(solution.completePrime(17));
    }
}