package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskC1 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; ++i) {
            int copy = i;
            dp[i] = Integer.MAX_VALUE - 5;
            while(copy > 0) {
                dp[i] = Math.min(dp[i], dp[i - copy % 10] + 1);
                copy /= 10;
            }
        }

        out.println(dp[n]);

    }
}
