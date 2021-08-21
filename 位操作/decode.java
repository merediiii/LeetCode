package 位操作;

import java.util.Arrays;
import java.util.stream.Stream;

public class decode {
    public int[] f(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int tmp = encoded[i];
            String bin = Integer.toBinaryString(tmp);
            String fst = Integer.toBinaryString(first);
            int len = Math.abs(bin.length() - fst.length());
            StringBuilder sb = new StringBuilder();
//            System.out.println("1 bin\t"+bin);
//            System.out.println("1 fst\t"+fst);
//            System.out.println(len);
            for (int j = 0; j < len; j++) {
                sb.append("0");
            }
//            System.out.println(sb);
            if (bin.length() > fst.length())
                fst = sb.toString() + fst;
            else
                bin = sb.toString() + bin;
            StringBuilder as = new StringBuilder();
//            System.out.println("2 bin\t"+bin);
//            System.out.println("2 fst\t"+fst);
            for (int j = 0; j < bin.length(); j++) {
                int tp = 0;
                if (bin.charAt(j) - '0' == 0)
                    tp = (bin.charAt(j) - '0') | (fst.charAt(j) - '0');
                else
                    tp = (bin.charAt(j) - '0') ^ (fst.charAt(j) - '0');
                as.append(tp);
            }
            ans[i + 1] = Integer.parseInt(as.toString());
//            System.out.println(ans[i+1]);
            first = ans[i + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.asList(new decode().f(new int[]{1, 2, 3}, 1)).stream().forEach(System.out::println);
    }
}
