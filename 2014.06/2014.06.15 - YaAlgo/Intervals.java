package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class Intervals {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = in.nextIntArray(n);
        int first = 0;
        Counter<Integer> integers = new Counter<Integer>();
        long ans = 0;
        for(int last = 0; last < n; ++last) {
            long hasPairs = (integers.get(a[last] - d)) + (integers.get(a[last] + d));
            integers.add(a[last]);
            while (first < last && hasPairs > 0) {
                if(a[first] == a[last] - d) {
                    --hasPairs;
                }
                if(a[first] == a[last] + d) {
                    --hasPairs;
                }
                integers.add(a[first], -1);
                ++first;
            }
            ans += first;

        }

        out.println(ans);
    }
}
