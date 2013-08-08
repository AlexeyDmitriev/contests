package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
    }
}
