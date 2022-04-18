public class Tool {
    public static <T> void show(T[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
