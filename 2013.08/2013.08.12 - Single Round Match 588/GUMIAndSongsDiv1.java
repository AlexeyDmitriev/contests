package main;

import java.util.Arrays;
import java.util.Comparator;

public class GUMIAndSongsDiv1 {
    public int maxSongs(int[] duration, final int[] tone, int T) {
        int n = duration.length;
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; ++i) {
            indices[i] = i;
        }

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(tone[o1], tone[o2]);
            }
        });

        int answer = 0;

        for(int start = 0; start < n; ++start) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, - 1);
            dp[1] = duration[indices[start]];
            if(dp[1] <= T) {
                answer = Math.max(answer, 1);
            }
            for(int i = start + 1; i < n; ++i) {
                for(int k = n; k >= 1; --k) {
                    if(dp[k] != -1) {
                        if(dp[k + 1] == -1 || dp[k + 1] > dp[k] + duration[indices[i]]) {
                            dp[k + 1] = dp[k] + duration[indices[i]];
                            if(dp[k + 1] + tone[indices[i]] - tone[indices[start]] <= T) {
                                answer = Math.max(answer, k + 1);
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
