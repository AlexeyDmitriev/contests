package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        ArrayList<Pair<Integer, Integer>>[] candies = new ArrayList[2];
        ArrayList<Pair<Integer, Integer>>[] candies2 = new ArrayList[2];
        for(int i = 0; i < 2; ++i) {
            candies[i] = new ArrayList<Pair<Integer, Integer>>();
            candies2[i] = new ArrayList<Pair<Integer, Integer>>();
        }
        for(int i = 0; i < n; ++i) {
            int t = in.nextInt();
            int h = in.nextInt();
            int m = in.nextInt();
            candies[t].add(new Pair<Integer, Integer>(h, m));
            candies2[1 - t].add(new Pair<Integer, Integer>(h, m));
        }

        int res = solve(x, candies);
        res = Math.max(res, solve(x, candies2));
        out.println(res);

    }

    private int solve(int x, ArrayList<Pair<Integer, Integer>>[] candies) {
        int cur = 1;
        int ans = 0;
        while (true) {
            cur = 1 - cur;
            Pair<Integer, Integer> best = null;
            for (Pair<Integer, Integer> pair : candies[cur]) {
                if(pair.first > x) {
                    continue;
                }

                if(best == null || pair.second > best.second) {
                    best = pair;
                }

            }
            if(best == null) {
                return ans;
            }
            ans ++;
           // System.out.println(best);
            x += best.second;

            candies[cur].remove(best) ;
           // System.out.println(candies[0] + " " + candies[1]);
        }
    }
}
