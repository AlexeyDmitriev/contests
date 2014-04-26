package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        if(k * 2 > n - 1) {
            out.println(-1);
            return;
        }
        out.println(k * n);
        for(int i = 0; i < n; ++i) {

            for(int j = 1; j <= k; ++j) {
                out.println(i + 1 + " " + ((i + j) % n + 1));
            }
        }

    }
}
