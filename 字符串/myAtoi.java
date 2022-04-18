package 字符串;

public class myAtoi {
    public int f(String s) {
        String res = s.trim();
        char flag = res.charAt(0);
        if (flag != '-' && (flag < '0' || flag > '0'))
            return 0;
        boolean neg = flag == '-' ? true : false;
        if (neg)
            res = res.substring(1);
        int ten = 0;
        int re = 1;
        for (int i = 0; i < res.length(); i++) {
            re += re * ten++ * 10 + res.charAt(i);
//            if(0x7fffffff - re )
        }
        return 0;
    }
}
