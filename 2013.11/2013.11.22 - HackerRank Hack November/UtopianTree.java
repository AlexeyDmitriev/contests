package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class UtopianTree {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        long ans = 1;
        for(int i = 0; i < n; ++i) {
            if(i % 2 == 0)
                ans <<= 1;
            else
                ans += 1;
        }
        out.println(ans);
    }
}
