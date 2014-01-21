package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskD {
    int MAGIC = 11100;
    private int mod = 1000000007;

    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] counts = new int[MAGIC * 2];
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            ++counts[MAGIC];
            if(counts[MAGIC] > mod)
                counts[MAGIC] -= mod;
            int[] newCounts = new int[MAGIC * 2];
            for(int oldValue = -10000; oldValue <= 10000; ++oldValue) {
                newCounts[MAGIC + oldValue + a[i]] += counts[MAGIC + oldValue];
                if(newCounts[MAGIC + oldValue + a[i]] >= mod)
                    newCounts[MAGIC + oldValue + a[i]] -= mod;
                newCounts[MAGIC + oldValue - a[i]] += counts[MAGIC + oldValue];
                if(newCounts[MAGIC + oldValue - a[i]] >= mod)
                    newCounts[MAGIC + oldValue - a[i]] -= mod;
            }
            counts = newCounts;
            ans += counts[MAGIC];
            if(ans >= mod)
                ans -= mod;
        }
        out.println(ans);
    }
}
