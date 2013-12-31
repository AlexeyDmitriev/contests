package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class Dhack {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = 200000;
        out.println(n);
        for(int i = 0; i < n; ++i) {
            if(i != 0)
                out.print(' ');
            out.print(1);
        }
        out.println();
    }
}
