package main;

import name.admitriev.spsl.collections.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class MysticAndCandies {
    public int minBoxes(int C, int X, int[] low, int[] high) {
        int n = low.length;
        Pair<Integer, Integer>[] pairs = new Pair[n];
        int ans = n;
        for(int i = 0; i < n; ++i) {
            pairs[i] = new Pair<Integer, Integer>(low[i], high[i]);
        }
        Arrays.sort(pairs);
        int cnt = 0;
        int sumLow = 0;
        while(cnt < n && sumLow < X) {
            ++cnt;
            sumLow += pairs[n - cnt].first;
        }
        ans = Math.min(ans, cnt);
        cnt = 0;
        Arrays.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.second, o2.second);
            }
        });

        int sumHigh = 0;
        for(int i = 0; i < n; ++i) {
            sumHigh += pairs[i].second;
            int minOthers = C - sumHigh;
            if(minOthers >= X)
                ans = Math.min(n - i - 1, ans);
        }

        return ans;
    }
}