import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lixintong
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            for (int _i = 0; _i < n; _i++) {
                String s = in.next();
                if (s.matches("R[0-9]+C[0-9]+")) {
                    String[] nums = s.split("R|C");
                    int x = Integer.parseInt(nums[2]);
                    String t = "";
                    while (x != 0) {
                        int m = x % 26;
                        if (m == 0) {
                            t = 'Z' + t;
                            x -= 26;
                        } else
                            t = (char) (m + 'A' - 1) + t;
                        x /= 26;
                    }
                    out.println(t + nums[1]);
                } else {
                    String x1 = s.replaceAll("[0-9]", "");
                    String x2 = s.replaceAll("[A-Z]", "");
                    int base = 1;
                    int t = 0;
                    for (int i = x1.length() - 1; i >= 0; i--) {
                        t += base * (x1.charAt(i) - 'A' + 1);
                        base *= 26;
                    }
                    out.println("R" + x2 + "C" + t);
                }
            }
        }

    }
}

