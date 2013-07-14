package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        long S = 0;
        long minX = Integer.MAX_VALUE;
        long maxX = Integer.MIN_VALUE;
        long minY = Integer.MAX_VALUE;
        long maxY = Integer.MIN_VALUE;

        for(int i = 0; i < n; ++i) {
            long x1, y1, x2, y2;
            minX = Math.min(minX, x1 = in.nextInt());
            minY = Math.min(minY, y1 = in.nextInt());
            maxX = Math.max(maxX, x2 = in.nextInt());
            maxY = Math.max(maxY, y2 = in.nextInt());

            S += (x2 - x1) * (y2 - y1);
        }

        //System.err.println(minX + " " + minY + " " + maxX + " " + maxY);

        out.println(((maxX - minX) * (maxY - minY) == S && maxX - minX == maxY - minY) ? "YES" : "NO");
    }
}
