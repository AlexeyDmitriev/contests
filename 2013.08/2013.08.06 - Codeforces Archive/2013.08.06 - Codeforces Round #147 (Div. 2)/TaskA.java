package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        Counter<Integer> uniqueTimes = new Counter<Integer>();
        for(int i = 0; i < n; ++i) {
            uniqueTimes.add(in.nextInt() * 100 + in.nextInt());
        }
        long max = 0;
        for (long customers : uniqueTimes.values()) {
            max = Math.max(customers, max);
        }
        out.println(max);

    }
}
