package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] cnt = new int[101];
        for(int i = 0; i < n; ++i) {
            cnt[a[i]] ++;
        }

        int sum = 0;
        int ans = 0;
        for(int i = 0; i <= 100; ++i) {
            sum += cnt[i];
            //if(i == 0)
              //  out.println(sum + " " + (sum + i)/ (i + 1));
            ans = Math.max(ans, (sum + i)/ (i + 1));
        }

        out.println(ans);
    }
}
