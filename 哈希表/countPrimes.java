package 哈希表;

/*
204. 计数质数
统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class countPrimes {
    public static int countPrimes(int n) {
        int count = 1;
        if (n == 0 || n == 1)
            return 0;
        if (n == 2)
            return 0;
        if (n == 3)
            return 1;
        for (int i = 3; i < n; i += 2) {
            int isPrime = 1;
            int k = (int) Math.sqrt(i);//k为num的正平方根，取整数
            for (int j = 2; j <= k; j++) {
                if (i % j == 0) {
                    isPrime = 0;//不是素数
                    break;
                }
            }
            if (isPrime == 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(5));
    }
}
