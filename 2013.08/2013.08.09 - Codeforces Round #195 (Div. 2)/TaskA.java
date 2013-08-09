package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        int abs = Math.abs(x) + Math.abs(y);
        if(x < 0)
            out.println((x > 0 ? abs : -abs) + " 0 0 " + (y > 0 ? abs : -abs));
        else
            out.println("0 " + (y > 0 ? abs : -abs) + " " + (x > 0 ? abs : -abs) + " 0");
    }
}
