package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String x = in.nextString() + "X";
        int start = 0;
        int ans = 0;
        for(int i = 1; i < x.length(); ++i) {
            if(x.charAt(i) != x.charAt(start)) {
                if((i - start) % 2 == 0)
                    ++ans;
                start = i;
            }
        }
        out.println(ans);
    }
}
