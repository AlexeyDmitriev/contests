package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int currentStrength = in.nextInt();
        int n = in.nextInt();
        Pair<Integer, Integer>[] dragons = new Pair[n];
        for(int i = 0; i < n; ++i) {
            dragons[i] = new Pair<Integer, Integer>(in.nextInt(), in.nextInt());
        }
        Arrays.sort(dragons);

        for(int i = 0; i < n; ++i) {
            if(currentStrength <= dragons[i].first) {
                out.println("NO");
                return;
            }
            currentStrength += dragons[i].second;
        }

        out.println("YES");
    }
}
