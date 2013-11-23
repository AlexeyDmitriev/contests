package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.math.BigInteger;

public class Task25 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int len = in.nextInt();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int pos = 2;
        while (b.toString().length() < len) {
            BigInteger tmp = b.add(a);
            a = b;
            b = tmp;
            ++pos;
        }
        out.println(pos);
    }
}
