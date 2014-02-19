package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.Arrays;

public class TaskC1 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] points = new int[n];
        int[] energy = new int[n];

        int needWon = n - k + 1;

        in.nextIntArrays(points, energy);

        int answer = Integer.MAX_VALUE;
        for(int wins = 0; wins <= n; ++wins) {
            int[][][] dp = new int[n + 1][n + 1][n + 1];
            for(int i = 0; i <= n; ++i)
                for(int j = 0; j <= n; ++j) {
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }


            dp[0][0][0] = 0;

            for(int opp = 0; opp < n; ++opp) {
                for(int wasPoints = 0; wasPoints < n; ++wasPoints) {
                    for(int wasBeaten = 0; wasBeaten < n; ++wasBeaten) {
                        if(dp[opp][wasPoints][wasBeaten] == Integer.MAX_VALUE)
                            continue;
                        {
                            int newBeaten = wasBeaten;
                            if(wins > points[opp] + 1)
                                ++newBeaten;
                            int newPoints = wasPoints;
                            dp[opp + 1][newPoints][newBeaten] = Math.min(dp[opp + 1][newPoints][newBeaten], dp[opp][wasPoints][wasBeaten]);
                        }

                        {
                            int newBeaten = wasBeaten;
                            if(wins >= points[opp])
                                ++newBeaten;
                            int newPoints = wasPoints + 1;
                            dp[opp + 1][newPoints][newBeaten] = Math.min(dp[opp + 1][newPoints][newBeaten], dp[opp][wasPoints][wasBeaten] + energy[opp]);
                        }


                    }
                }

                for(int wasBeaten = needWon; wasBeaten <= n; ++wasBeaten) {
                    answer = Math.min(answer, dp[n][wins][wasBeaten]);
                }
            }
        }


        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        out.println(answer);
    }
}
