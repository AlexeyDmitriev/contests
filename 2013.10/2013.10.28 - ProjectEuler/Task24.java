package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class Task24 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = i;

        for(int i = 0; i < k - 1; ++i) {
            ArrayUtils.nextPermutation(a);
        }

        for(int i = 0; i < n; ++i)
            out.print(a[i]);
    }
}
