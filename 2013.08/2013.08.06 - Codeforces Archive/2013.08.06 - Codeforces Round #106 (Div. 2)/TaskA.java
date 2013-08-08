package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.misc.ReverseComparator;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int needHeight = in.nextInt();
        int[] a = in.nextIntArray(12);
        ArrayUtils.sort(a, new ReverseComparator<Integer>());
        int height = 0;
        if(needHeight == 0) {
            out.println(0);
            return;
        }
        for(int i = 0; i < 12; ++i) {
            height += a[i];
            if(height >= needHeight) {
                out.println(i + 1);
                return;
            }
        }
        out.println(-1);
    }
}
