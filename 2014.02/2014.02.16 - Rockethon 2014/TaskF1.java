package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.Arrays;

public class TaskF1 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] cost = in.nextLongArray(n);
        long[][][] dp = new long[n + 1][2][k + 1];

        for(int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i][1], Long.MIN_VALUE);
           // Arrays.fill(dp[i][0], Long.MIN_VALUE);
        }

        dp[0][0][0] = 0;

        for(int day = 0; day < n; ++day) {
            for(int hasActs = 0; hasActs <= 1; ++hasActs) {
                for(int transactions = 0; transactions <= k; ++transactions) {
                    if(dp[day][hasActs][transactions] == Long.MIN_VALUE) {
                        continue;
                    }
                    dp[day + 1][hasActs][transactions] = Math.max(dp[day + 1][hasActs][transactions], dp[day][hasActs][transactions]);
                    if(hasActs == 0 && transactions < k) {
                        dp[day + 1][1][transactions] = Math.max(dp[day + 1][1][transactions], dp[day][hasActs][transactions] - cost[day]);
                       // out.println(day + 1 + " " + 1 + " " + transactions + "=" + dp[day + 1][1][transactions] );
                    }
                    if(hasActs == 1 && transactions < k) {
                       // out.println("here" + day + " 0 " + (transactions + 1) + "");
                        dp[day + 1][0][transactions + 1] = Math.max(dp[day + 1][0][transactions + 1], dp[day][hasActs][transactions] + cost[day]);
                       // out.println(dp[day + 1][0][transactions + 1]);
                    }
                }
            }
        }
        long ans = 0;
        for(int transactions = 0; transactions <= k; ++transactions) {
            ans = Math.max(ans, dp[n][0][transactions]);
        }
        out.println(ans);



    }
}
