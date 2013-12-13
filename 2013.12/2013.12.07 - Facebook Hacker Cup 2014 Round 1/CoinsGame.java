package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class CoinsGame {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int jars = in.nextInt();
        int coins = in.nextInt();
        int need = in.nextInt();
        int ans = Integer.MAX_VALUE;
        for(int max = 1; max <= jars; ++max) {
            int inMaximums = coins / max * max;
            int left = coins - inMaximums - (coins - need);
            if(left <= (coins / max - 1) * (jars - max)) {
                ans = Math.min(ans, jars - max);
            }
        }
        out.println("Case #" + testNumber + ": " + (ans + need));
    }
}
