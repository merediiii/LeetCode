package 字符串;

public class repeatedSubstringPattern {
    public boolean f(String s) {
        String re = s + s;
        return re.substring(1, re.length() - 1).contains(s);
    }
}
