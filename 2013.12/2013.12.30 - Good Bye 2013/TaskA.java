package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int all = in.nextInt();
        int b = in.nextInt();
        int rest = 0;
        long ans = 0;
        while (all > 0) {
            ans += all;
            rest += all;
            all = rest / b;
            rest %= b;
        }
        out.println(ans);
    }
}
