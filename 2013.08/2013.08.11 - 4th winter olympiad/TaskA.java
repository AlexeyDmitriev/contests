package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        out.println(Math.min(in.nextInt(), in.nextInt()));
    }
}
