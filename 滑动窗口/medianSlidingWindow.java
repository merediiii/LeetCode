package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class medianSlidingWindow {

    public static ArrayList<Double> so;

    public static double comp(int[] nums, int i, int j) {
        int o = j - i + 1;
        ArrayList<Double> list = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            list.add((double) nums[k]);
        }
        Collections.sort(list);
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k));
            ;
        }
        System.out.println();

        if (o % 2 == 1)
            return list.get(list.size() / 2);
        else
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
    }

    public static double[] f(int[] nums, int k) {
        so = new ArrayList<>(k);
        int l = 0;
        int r = l + k - 1;
        double[] res = new double[nums.length - k + 1];
        while (r < nums.length) {
            res[l] = comp(nums, l, r++);
            l++;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] res = {1, 3, -1, -3, 5, 3, 6, 7};
        f(res, 3);
    }


}
