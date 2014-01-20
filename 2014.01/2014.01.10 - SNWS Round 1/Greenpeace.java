package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Greenpeace {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int guards = in.nextInt();
        ArrayList<Pair<Integer, Integer>>[] graph = new ArrayList[n];
        for(int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Pair<Integer, Integer>>();
        }

        for(int i = 0; i < m; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int t = in.nextInt();
            graph[a].add(new Pair<Integer, Integer>(b, t));
            graph[b].add(new Pair<Integer, Integer>(a, t));
        }

        int[] guardPositions = in.nextIntArray(guards);

        int startPosition = in.nextInt();

        long[] d = new long[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        TreeSet<Pair<Long, Integer>> queue = new TreeSet<Pair<Long, Integer>>();
        queue.add(new Pair<Long, Integer>(d[0], 0));

        while (!queue.isEmpty()) {
            int v = queue.first().second;
            queue.remove(queue.first());
            for (Pair<Integer, Integer> edge : graph[v]) {
                int next = edge.first;
                long newDist = d[v] + edge.second;
                if(newDist < d[next]) {
                    queue.remove(new Pair<Long, Integer>(d[next], next));
                    d[next] = newDist;
                    queue.add(new Pair<Long, Integer>(d[next], next));
                }
            }

        }

        long ourTime = d[startPosition - 1];
        long bestGuard = Integer.MAX_VALUE;
        for (int guardPosition : guardPositions) {
            bestGuard = Math.min(bestGuard, d[guardPosition - 1]);
        }
        if(bestGuard <= ourTime) {
            out.println(-1);
        }
        else
            out.println(ourTime);

    }
}
