package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskF {
    private static final int MAGIC = 100;

    class Point{
        double x, y, z;

        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {

            return "(" + x + " " + y + " " + z +")";
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        Point[][] points = new Point[n + 2][2];

        for(int i = 0; i < 2; ++i){
            points[i][0] = new Point(in.nextInt(), in.nextInt(), in.nextInt());
            points[i][1] = points[i][0];
        }

        for(int i = 0; i < n; ++i) {
            points[i + 2][0] = new Point(in.nextInt(), in.nextInt(), in.nextInt());
            points[i + 2][1] = new Point(in.nextInt(), in.nextInt(), in.nextInt());
        }

        n += 2;

        double[][] distances = new double[n][n];

        //System.out.println(Arrays.deepToString(points));

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                distances[i][j] = Math.sqrt(distance(points[i], points[j]));
            }
        }

        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        out.println(distances[0][1]);
    }

    Point c1 = new Point(0,0,0);
    Point d1 = new Point(0,0,0);
    Point d2 = new Point(0,0,0);
    Point c2 = new Point(0,0,0);

    private double distance(Point[] x, Point[] y) {
        double l = 0;
        double r = 1;
        for(int i = 0; i < MAGIC; ++i) {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            c1.x = x[0].x + m1 * (x[1].x - x[0].x);
            c1.y = x[0].y + m1 * (x[1].y - x[0].y);
            c1.z = x[0].z + m1 * (x[1].z - x[0].z);


            c2.x = x[0].x + m2 * (x[1].x - x[0].x);
            c2.y = x[0].y + m2 * (x[1].y - x[0].y);
            c2.z = x[0].z + m2 * (x[1].z - x[0].z);

            if (distance (c1, y) > distance (c2, y))
                l = m1;
            else
                r = m2;

        }
        return distance(c1, y);
    }

    private double distance(Point a, Point[] x) {
        double l = 0;
        double r = 1;

        for(int i = 0; i < MAGIC; ++i) {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            d1.x = x[0].x + m1 * (x[1].x - x[0].x);
            d1.y = x[0].y + m1 * (x[1].y - x[0].y);
            d1.z = x[0].z + m1 * (x[1].z - x[0].z);


            d2.x = x[0].x + m2 * (x[1].x - x[0].x);
            d2.y = x[0].y + m2 * (x[1].y - x[0].y);
            d2.z = x[0].z + m2 * (x[1].z - x[0].z);

            if (distance (a, d1) > distance (a, d2))
                l = m1;
            else
                r = m2;

        }
        return distance(a, d1);
    }

    private double distance(Point a, Point b) {
        return sqr(a.x - b.x) + sqr(a.y - b.y) + sqr(a.z - b.z);
    }

    private double sqr(double v) {
        return v * v;
    }
}
