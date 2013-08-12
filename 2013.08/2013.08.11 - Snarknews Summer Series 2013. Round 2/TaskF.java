package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskF {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int p = in.nextInt(), q = in.nextInt();
        if(n == 1) {
            out.println((m - 1) * 2);
            return;
        }
        if(m == 1) {
            out.println((n - 1) * 2);
            return;
        }

        int answer = n * m;
        if(answer % 2 == 1)
            ++answer;
        out.println(answer);
    }
}
