package 双指针;

import java.util.Arrays;

public class trap {
    public static int f(int[] height) {
        if(height.length == 0 || height.length == 1)
            return 0;
        int sum = 0;
        int[] a = new int[height.length];
        int[] b = new int[height.length];
        int max = height[0];
        for (int i = 0; i < height.length - 1; i++) {
            max = Math.max(height[i], max);
            a[i+1] = max;
        }
        max = height[height.length - 1];
        for (int i = height.length -1; i > 0 ; i--) {
            max = Math.max(height[i],max);
            b[i - 1] = max;
        }
        for (int i = 1; i < height.length - 1; i++) {
            if(height[i] < Math.min(a[i],b[i]))
                sum += Math.min(a[i],b[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
