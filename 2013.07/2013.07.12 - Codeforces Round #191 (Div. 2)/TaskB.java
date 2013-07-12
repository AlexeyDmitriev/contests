package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        for(int i = 0; i < n; ++i) {
            out.print(n + i);
            out.print(' ');
        }
    }
}
