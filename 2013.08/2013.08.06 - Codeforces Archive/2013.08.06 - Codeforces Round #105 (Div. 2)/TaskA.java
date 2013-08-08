package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.array.BoolArray;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[] a = in.nextIntArray(4);
        int count = in.nextInt();
        boolean[] d = new boolean[count + 1];
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j <= count; j += a[i]) {
                d[j] = true;
            }
        }

        out.println(ListUtils.count(new BoolArray(d), true) - 1);

    }
}
