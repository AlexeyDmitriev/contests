package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TaskB {

    static class Friend implements Comparable<Friend>{
        int x, k;
        int mask;

        Friend(int x, int k, int mask) {
            this.x = x;
            this.k = k;
            this.mask = mask;
        }

        @Override
        public int compareTo(Friend o) {
            return Integer.compare(k, o.k);
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int b = in.nextInt();
        ArrayList<Friend> friends = new ArrayList<Friend>();
        for(int i = 0; i < n; ++i) {
            int x = in.nextInt();
            int k = in.nextInt();
            int mask = 0;
            int cnt = in.nextInt();
            for(int j = 0; j < cnt; ++j) {
                int z = in.nextInt();
                mask |= (1 << (z - 1));
            }
            friends.add(new Friend(x, k, mask));
        }

        Collections.sort(friends);
        long[][] dp = new long[2][1 << m];


        long ans = Long.MAX_VALUE;
        for(int i = 0; i <= 1; ++i)
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        dp[0][0] = 0;
        for(int i = 0; i < n; ++i) {
            Arrays.fill(dp[(i + 1) & 1], Long.MAX_VALUE / 2);
            for(int j = 0; j < 1 << m; ++j) {
                dp[(i + 1) & 1][j] = Math.min(dp[i %  2][j], dp[(i + 1) & 1][j]);
                dp[(i + 1) & 1][j | friends.get(i).mask] = Math.min(dp[(i + 1) & 1][j | friends.get(i).mask], dp[i & 1][j] + friends.get(i).x);
            }
            long need = dp[(i + 1) & 1][(1 << m) - 1] + b * 1L * friends.get(i).k;
            ans = Math.min(ans, need);
        }

        if(ans >= Long.MAX_VALUE / 2)
            ans = -1;

        out.println(ans);
    }
}
