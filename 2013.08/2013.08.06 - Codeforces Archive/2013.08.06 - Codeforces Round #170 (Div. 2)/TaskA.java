package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.array.IntArray;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] d = in.nextIntArray(n);
        int sum = ListUtils.sum(new IntArray(d));
        int s = in.nextInt() - 1;
        int t = in.nextInt() - 1;
        if(s > t) {
            int tmp = s;
            s = t;
            t = tmp;
        }

        int forwardPath = 0;

        for(int i = s; i < t; ++i) {
            forwardPath += d[i];
        }

        out.println(Math.min(forwardPath, sum - forwardPath));

    }
}
