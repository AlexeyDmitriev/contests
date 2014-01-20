package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class Ecology {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n  = in.nextInt();
        int maxMoney = in.nextInt();
        int maxSpoil = in.nextInt();
        int[] spoil = new int[n];
        int[] cost = new int[n];
        int[] profit = new int[n];
        in.nextIntArrays(profit, cost, spoil);

        int[][][] dp = new int[n + 1][maxMoney + 1][maxSpoil + 1];
        for(int i = 0; i <= n; ++i) {
            for(int j = 0; j <= maxMoney; ++j) {
                for(int k = 0; k <= maxSpoil; ++k) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        int answer = 0;
        for(int i = 0; i < n; ++i) {
            for(int money = 0; money <= maxMoney - cost[i]; ++money) {
                for(int spoiled = 0; spoiled <= maxSpoil - spoil[i]; ++spoiled) {
                    if(dp[i][money][spoiled] < 0)
                        continue;

                    dp[i + 1][money + cost[i]][spoiled + spoil[i]] = Math.max(dp[i + 1][money + cost[i]][spoiled + spoil[i]], dp[i][money][spoiled] + profit[i]);
                    answer = Math.max(answer,dp[i + 1][money + cost[i]][spoiled + spoil[i]]);
                }
            }
            for(int money = 0; money <= maxMoney; ++money) {
                for(int spoiled = 0; spoiled <= maxSpoil; ++ spoiled) {
                    dp[i + 1][money][spoiled] = Math.max(dp[i + 1][money][spoiled], dp[i][money][spoiled]);
                }
            }
        }
       // out.println(Arrays.deepToString(dp));
        out.println(answer);
    }
}
