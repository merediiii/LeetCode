package 输入;

import java.util.Scanner;

public class readInput {

    public static String ans;


    public static void f(int n, String ans) {
        if (n == 1) {
            System.out.print(ans);
            return;
        }
        f(n - 1, "G");
        System.out.print(ans);
        f(n - 1, "R");
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String in = sc.nextLine();
//        while (sc.hasNextLine()) {
//            in = sc.nextLine();
//            if(in.equals(""))break;
//            System.out.println(in);
//        }
//        System.out.println("end");

        String ans = "R";
        f(100, ans);
    }

}
