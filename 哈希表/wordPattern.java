package 哈希表;
/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
import java.util.HashMap;

public class wordPattern {
    public static boolean f(String pattern, String str) {
        HashMap<Character, String> hash = new HashMap<>();
        String[] dic = str.split(" ");
        hash.put(pattern.charAt(0), dic[0]);
        if(pattern.toCharArray().length != dic.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (hash.containsKey(pattern.charAt(i))) {
                if (!dic[i].equals(hash.get(pattern.charAt(i))))
                    return false;
            } else {
                if (hash.containsValue(dic[i]))
                    return false;
                hash.put(pattern.charAt(i), dic[i]);
            }

        }
        return true;
    }


    public static void main(String[] args) {
        String a = "abba";
        String b = "dog dog dog dog";
        System.out.println(f(a,b));
    }
}
