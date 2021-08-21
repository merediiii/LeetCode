package 字符串;

public class modifyString {
    public static String f(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char tmp = 'a';
                while (i < s.length() - 1 && s.charAt(i + 1) == tmp || i > 0 && sb.charAt(i - 1) == tmp) {
                    tmp++;

                }
                sb.append(tmp);
            } else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String re = "??yw?ipkj?";

        System.out.println(f(re));
    }
}
