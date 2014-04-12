package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class AChocolateFiesta {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        Counter<Integer> counter = new Counter<Integer>();
        long[] dp = new long[2];
        dp[0] = 1;
        int mod = 1000000007;
        for(int i = 0; i < n; ++i) {
            int k = in.nextInt();
            //out.println(Arrays.toString(dp));
            long[] newDp = new long[2];
            for(int j = 0; j <= 1; ++j) {
                newDp[j] += dp[j];
                newDp[(j + k) % 2] += dp[j];
            }

            dp = newDp;
            for(int j = 0 ; j <= 1; ++j)
                dp[j] %= mod;
        }
        out.println(dp[0] - 1);
    }
}
