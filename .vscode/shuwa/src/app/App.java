package app;

public class App {
    public static void main(final String[] args) throws Exception {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(i + 1).append(",");

        }
        final String s = sb.toString();
        final String[] a = s.split(",");
        System.out.println(a);
    }
}