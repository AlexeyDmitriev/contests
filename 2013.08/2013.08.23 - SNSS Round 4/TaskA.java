package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TaskA {
    static class State {
        int b, e;
        int x, y;

        State( int x, int y, int b, int e) {
            this.b = b;
            this.e = e;
            this.x = x;
            this.y = y;
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int from = in.nextInt();
        int to = in.nextInt();

        int x = in.nextInt();
        int y = in.nextInt();

        ArrayList<State> states = new ArrayList<State>();
        for(int i = 0; i < n; ++i) {
            states.add(new State(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }

        int startId = n;
        for(int i = 0; i < n; ++i) {
            State state = states.get(i);
            if(x == state.x && y == state.y && in(from, state.b, state.e)) {
                startId = i;
                break;
            }
        }

        if(startId == n) {
            states.add(new State(x,y,from, from));
            ++n;
        }

        TreeSet<Pair<Double, Integer>> queue = new TreeSet<Pair<Double, Integer>>();
        double[] d = new double[n];
        Arrays.fill(d, 1e100);
        d[startId] = 0;

        queue.add(new Pair<Double, Integer>(d[startId], startId));

        while (!queue.isEmpty()) {
            int cur = queue.first().second;
            //out.println(cur);
            queue.remove(queue.first());
            State curState = states.get(cur);
            if(curState.e == to) {
                out.println(d[cur]);
                return;
            }
            for(int i = 0; i < n; ++i) {
                State nextState = states.get(i);
                if(in(curState.e, nextState.b, nextState.e)) {
                    double dist = Math.sqrt(sqr(curState.x - nextState.x) + sqr(curState.y - nextState.y));
                    if(d[i] > d[cur] + dist) {
                        queue.remove(new Pair<Double, Integer>(d[i], i));
                        d[i] = d[cur] + dist;
                        queue.add(new Pair<Double, Integer>(d[i], i));
                    }
                }
            }
        }

        out.println(-1);


    }

    private double sqr(double i) {
        return i * i;
    }

    private boolean in(int from, int b, int e) {
        return from >= b && from <= e || from <= b && from >= e;
    }
}
