import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.awt.geom.Point2D;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            double[] x = new double[3];
            double[] y = new double[3];
            for (int i = 0; i < 3; i++) {
                x[i] = in.nextDouble();
                y[i] = in.nextDouble();
            }
            double a = Point2D.distance(x[0], y[0], x[1], y[1]);
            double b = Point2D.distance(x[1], y[1], x[2], y[2]);
            double c = Point2D.distance(x[2], y[2], x[0], y[0]);
            double ng1 = angle(a, b, c);
            double ng2 = angle(b, c, a);
            double ng3 = angle(c, a, b);
            double r = c / Math.sin(ng1) / 2;

            double n = Math.PI / gcd(ng1, gcd(ng2, ng3));

            double result = n / 2 * r * r * Math.sin(2 * Math.PI / n);

            out.printf("%.6f\n", result);
        }

        public static double angle(double a, double b, double c) {
            double r1 = a * a + b * b - c * c;
            double r2 = 2 * a * b;
            double ng = Math.acos(r1 / r2);
            return ng;
        }

        public static double gcd(double x, double y) {
            if (y < Math.PI / 100.0) {
                return x;
            } else {
                return gcd(y, x % y);
            }
        }

    }
}

