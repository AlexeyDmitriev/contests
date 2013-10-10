package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        String m = in.nextString();


        long[] prefSum = new long[n + 1];
        prefSum[0] = 0;
        for(int i = 0; i < n; ++i) {
            prefSum[i + 1] = prefSum[i] + a[i];
        }

        long curSum = 0;
        long ans = 0;

        for(int i = n - 1; i >= 0; --i) {
            if(m.charAt(i) == '0')
                continue;

            ans = Math.max(ans, prefSum[i] + curSum);
            curSum += a[i];
        }

        ans = Math.max(ans, curSum);

        out.println(ans);
    }
}
