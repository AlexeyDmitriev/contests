package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int left = 0;
        for(int i = 0; i < n; ++i) {
            left += 1 - a[i];
        }
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == 0) {
                --left;
            }
            else
                ans += left;
        }
        out.println(ans);
    }
}
