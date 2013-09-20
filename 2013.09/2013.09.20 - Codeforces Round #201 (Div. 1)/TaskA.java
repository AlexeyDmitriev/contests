package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        long gcd = 0;
        int max = 0;
        for (int i : a) {
            gcd = IntegerUtils.gcd(gcd, i);
            max = Math.max(max, i);
        }

        long numbersPossible = max / gcd;
        if((numbersPossible - n) % 2 == 0)
            out.println("Bob");
        else
            out.println("Alice");


    }
}