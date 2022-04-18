package nothing;

import java.util.ArrayList;
import java.util.List;

public class prefixesDivBy5 {

    public static String g(String before) {
        String after = "";
        String res = "";
        boolean ctx = false;
        for (int i = before.length() - 1; i >= 0; i--) {
            int ji = (before.charAt(i) - '0') * 2;
            after = String.valueOf(ji).substring(String.valueOf(ji).length() - 1);
            // System.out.println("x\t"+(before.charAt(i)-'0')+"\nafter\t"+after);
            String prefix = "";
            res = !ctx ? after : (String.valueOf(Integer.parseInt(after) + 1)) + res;
            //System.out.println(res);
            if (ji > 9)
                ctx = true;
            else
                ctx = false;

        }
        return res;
    }

    public static String h(String before, int n) {
        String after = "";
        String res = "";
        boolean ctx = false;
        for (int i = before.length() - 1; i >= 0; i--) {
            int ji = (before.charAt(i) - '0') + n;
            after = String.valueOf(ji).substring(String.valueOf(ji).length() - 1);
//             System.out.println("x\t"+(ji)+"\nafter\t"+after);
            String prefix = "";
            res = (!ctx ? after : (String.valueOf(Integer.parseInt(after) + 1))) + res;
//            System.out.println(res);
            if (ji > 9)
                ctx = true;
            else
                ctx = false;
            n = 0;
        }

        return res;
    }


    public static List<Boolean> f(int[] A) {
        String tmp = "0";
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            tmp = h(g(tmp), A[i]);
            System.out.println(tmp);
            System.out.println((tmp.substring(tmp.length() - 1)));
            list.add((tmp.substring(tmp.length() - 1).equals("0") || tmp.substring(tmp.length() - 1).equals("5")) ? Boolean.TRUE : Boolean.FALSE);
        }
        return list;
    }

    public static void main(String[] args) {

//        System.out.println(h("99",9));
        List<Boolean> list = f(new int[]{0, 1, 1});
        for (Boolean b : list
        ) {
            System.out.println(b);
        }
    }
}
