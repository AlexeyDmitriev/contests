package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.Arrays;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] needs = in.nextIntArray(n);

        Pair<Integer, Integer>[] people = new Pair[n];
        for(int i = 0; i < n; ++i) {
            people[i] = new Pair<Integer, Integer>(needs[i], i);
        }

        Arrays.sort(people);

        int[] answer = new int[n];
        int last = 0;
        for(int i = 0; i < n; ++i) {
            last = Math.max(people[i].first, last + 1);
            answer[people[i].second] = last;
        }
        for(int i = 0; i < n; ++i) {
            out.print(answer[i] + " ");
        }
    }
}
