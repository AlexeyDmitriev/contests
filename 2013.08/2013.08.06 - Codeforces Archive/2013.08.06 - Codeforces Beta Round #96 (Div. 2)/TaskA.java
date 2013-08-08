package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        boolean result = s.contains("H") || s.contains("9") || s.contains("Q");
        out.println(result ? "YES" : "NO");
    }
}
