package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[] matrix = in.nextIntArray(25);
        for(int i = 0; i < 25; ++i) {
            if(matrix[i] == 1) {
                out.println(Math.abs(i / 5 - 2) + Math.abs(i % 5 - 2));
            }
        }
    }
}
