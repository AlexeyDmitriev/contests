package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class BGen {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = 40;
        int q = 300000;
        out.println(n + " " + n + " " + q);
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j)
                out.print(i == 0 && j == 0 ? 1 : 0);
            out.println();
        }
        for(int i = 0; i < q; ++i){
            out.println(1 + " " + 1 + " " + n + " " + n);
        }
    }
}
