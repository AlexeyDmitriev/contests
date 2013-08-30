package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    int mod = 1000000007;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[][][][][] dp = new int[n + 1][2][2][2][2];
        dp[0][0][0][0][0] = 1;
        int[] numbers = {0,3,6,9};
        for(int i = 0; i < n; ++i) {
            for(int was3 = 0; was3 < 2; ++was3) {
                for(int was6 = 0; was6 < 2; ++was6) {
                    for(int was9 = 0; was9 < 2; ++was9) {
                        for(int was0 = 0; was0 < 2; ++was0) {
                            for(int next: numbers) {
                                if(dp[i][was3][was6][was9][was0] == 0)
                                    continue;
                                if(next == 0 && i == 0)
                                    continue;
                                if(was9 == 1 && next == 6)
                                    continue;
                                if(was3 == 1 && next == 0)
                                    continue;
                               
                                dp[i + 1][was3 == 1 || next == 3 ? 1 : 0][was6 == 1 || next == 6 ? 1 : 0][was9 == 1 || next == 9 ? 1 : 0][was0 == 1 || next == 0 ? 1 : 0] += dp[i][was3][was6][was9][was0];

                                dp[i + 1][was3 == 1 || next == 3 ? 1 : 0][was6 == 1 || next == 6 ? 1 : 0][was9 == 1 || next == 9 ? 1 : 0][was0 == 1 || next == 0 ? 1 : 0] %= mod;
                            }
                        }
                    }
                }
            }
        }

        out.println(dp[n][1][1][1][1]);
    }
}
