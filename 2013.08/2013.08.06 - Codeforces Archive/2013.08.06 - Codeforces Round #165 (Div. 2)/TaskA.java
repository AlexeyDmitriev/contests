package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        out.println(360 % (180 - in.nextInt()) == 0 ? "YES" : "NO");
    }
}
