package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        HashSet<Integer> have = new HashSet<Integer>();
        for(int i = 0; i < 4; ++i)
            have.add(in.nextInt());
        out.println(4 - have.size());
    }
}
