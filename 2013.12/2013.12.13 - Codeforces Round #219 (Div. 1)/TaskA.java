package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        ArrayUtils.sort(a);
        int l = 0;
        int r = n / 2 + 1;
        while (r - l > 1) {
            int m = (l + r) / 2;
            boolean ok = true;
            for(int i = 0; i < m; ++i) {

                if(a[i] * 2 > a[n - m + i]) {
                    ok = false;
                    break;
                }
            }
            //System.out.println(m + " " + ok);
            if(ok)
                l = m;
            else
                r = m;
        }
        out.println(n - l);
    }
}
