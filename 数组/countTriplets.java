package 数组;

public class countTriplets {
    public int f(int[] arr) {
        int[] tp = new int[arr.length];
        int[] ep = new int[arr.length];
        tp[0] = arr[0];
        ep[ep.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            tp[i] = tp[i - 1] ^ arr[i];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            ep[i] = ep[i + 1] ^ arr[i];
        }

        int[][] a = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0)
                    a[i][j] = tp[j];
                else {
                    if (j >= i)
                        a[i][j] = tp[j] ^ tp[i - 1];

                }
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        int[][] b = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i == 0)
                    b[i][j] = ep[j];
                else {
                    if (j <= arr.length - 1 - i)
                        b[i][j] = ep[j] ^ ep[arr.length - i];
                }


            }

        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + "\t");

            }
            System.out.println();
        }
        int sum = 0;


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j <= i) {
                    int tmp = a[j][i];
                    for (int k = 0; k < arr.length - (i + 1); k++) {
                        if (tmp == b[k][i + 1])
                            sum++;
                    }
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new countTriplets().f(new int[]{1, 1, 1, 1, 1}));
//        System.out.println(new countTriplets().f(new int[]{2, 3, 1, 6, 7}));
    }
}

