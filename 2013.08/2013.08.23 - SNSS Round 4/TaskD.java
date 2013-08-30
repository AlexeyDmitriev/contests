package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskD {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n - 1);
        long[] b = in.nextLongArray(n - 1);
        ArrayList<Pair<Integer, Long>>[] children = new ArrayList[n];
        for(int i = 0; i < n; ++i) {
            children[i] = new ArrayList<Pair<Integer, Long>>();
        }
        for(int i = 1; i < n; ++i) {
            children[a[i - 1]].add(new Pair<Integer, Long>(i, b[i - 1]));
        }



        long res = dfs(children, 0);
        if(res % 2 == 0) {
            out.println("Pass");
        }
        else
            out.println(res % (mod / 2));
    }
    long mod = 2 * 1000000007;

    private long dfs(ArrayList<Pair<Integer, Long>>[] children, int v) {
        long answer = 0;
        for (Pair<Integer, Long> pair : children[v]) {
            answer += dfs(children, pair.first) * pair.second;
            answer %= mod;
        }
        if(children[v].size() == 0)
            return 1;
        return answer;
    }
}
