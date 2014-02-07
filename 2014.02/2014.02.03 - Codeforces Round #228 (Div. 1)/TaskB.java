package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int paths = in.nextInt();
        int n = 31;
        int[] pows = new int[30];
        ArrayList<Pair<Integer, Integer>> edges = new ArrayList<Pair<Integer, Integer>>();
        for(int i = 0; i < 30; ++i) {
            pows[i] = 1 + i;
        }
        for(int i = 0; i + 1 < pows.length; ++i) {
            edges.add(new Pair<Integer, Integer>(n, pows[i]));
            edges.add(new Pair<Integer, Integer>(n, pows[i + 1]));
            ++n;
            edges.add(new Pair<Integer, Integer>(n, pows[i]));
            edges.add(new Pair<Integer, Integer>(n, pows[i + 1]));
            ++n;
        }
        for(int i = 0; i < 30; ++i) {

            if((paths & (1 << i)) != 0) {
                int prev = 0;
                for(int j = 0; j < 58 - i * 2; ++j) {
                    edges.add(new Pair<Integer, Integer>(prev, n));
                    prev = n;
                    ++n;
                }
                edges.add(new Pair<Integer, Integer>(prev, pows[i]));
            }
        }


        //for (Pair<Integer, Integer> edge : edges) {
          //  out.println(edge.first + " " +edge.second);
        //}
        out.println(n);
        char[][] ans = new char[n][n];
        for(int i = 0; i < n; ++i)
            Arrays.fill(ans[i], 'N');
        for(int i = 0; i < edges.size(); ++i) {
            ans[edges.get(i).first][edges.get(i).second] = 'Y';
            ans[edges.get(i).second][edges.get(i).first] = 'Y';
        }
        for(int i = 0; i < n; ++i)
            out.println(new String(ans[i]));
    }
}
