package 数学;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> yanghui = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            System.out.println("i\t" + i);
            for (int j = i / 2; j > 0; j--) {
                res[j] = (res[j] == 0 ? res[j - 1] : res[j]) + res[j - 1];
            }
            System.out.println("yanghui");
            for (int z = 0; z < rowIndex; z++) {
                System.out.println(res[z]);
            }
            System.out.println();
        }
        for (int i = 0; i < (rowIndex + 1) / 2; i++) {
            yanghui.add(res[i]);
            tmp.add(0, res[i]);
            System.out.println("tmp\t" + tmp.get(0));
        }
        if (rowIndex % 2 == 0)
            yanghui.add(res[rowIndex / 2]);
        for (int i = 0; i < (rowIndex + 1) / 2; i++) {
            System.out.println("ttmp\t" + tmp.get(i));
            yanghui.add(tmp.get(i));
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            System.out.println(yanghui.get(i));
        }
        return yanghui;
    }


    public static void main(String[] args) {
        System.out.println(getRow(2));
    }
}
