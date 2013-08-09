package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long m = in.nextInt();
        int r = in.nextInt();

        double answer = 0;
        for(int i = 0; i < m; ++i) {
            answer += solve(i);
            answer += solve(m - 1 - i);
            answer += 2;
        }

        out.println(answer / m * r / m);
    }

    private double solve(long l) {
        if(l == 0)
            return 0;
        return 2 + Math.sqrt(2) + (l - 1) * (1 + 2 * Math.sqrt(2) + 1) + (l - 1) * (l - 2);
    }
}
