package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskE {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int p = in.nextInt();
        int q = in.nextInt();
        out.println(answer(q) - answer(p - 1));
    }

    private long answer(int n) {
        long result = 0;
        for(int i = 0; n / (1 << i) > 0; ++i) {
            result +=  (n / (1 << i)) * (1 << i);
        }
        return result;
    }
}
