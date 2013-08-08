package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] reverse = new int[n];

        for(int i = 0; i < n; ++i) {
            reverse[a[i] - 1] = i;
        }

        for(int i = 0; i < n; ++i) {
            out.println(reverse[i] + 1);
        }
    }
}
