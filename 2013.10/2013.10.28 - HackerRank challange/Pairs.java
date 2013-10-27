package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class Pairs {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        Counter<Integer> counter = new Counter<Integer>();
        for (int i : a) {
            counter.add(i);
        }
        int ans = 0;
        for (int i : a) {
            ans += counter.get(i + k);
        }

        out.println(ans);

    }
}
