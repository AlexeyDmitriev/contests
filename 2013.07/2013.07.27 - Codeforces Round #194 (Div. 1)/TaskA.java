package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long n = in.nextLong();

        while (n % 3 == 0) {
            n /= 3;
        }

        out.println(n / 3 + 1);
    }
}
