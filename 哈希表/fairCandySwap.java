package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class fairCandySwap {
    public int[] f(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            sumA += A[i];
        for (int i = 0; i < B.length; i++)
            sumB += B[i];
        int diff = Math.abs(sumA - sumA);
        // System.out.println(sumA);
        int sum = (sumA + sumB) / 2;
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(sum - sumA + A[i]))
                map.put(sum - sumA + A[i], i);
        }

        for (int i = 0; i < B.length; i++)
            if (map.containsKey(B[i]))
                return new int[]{A[map.get(B[i])], B[i]};
        return new int[]{};

    }
}
