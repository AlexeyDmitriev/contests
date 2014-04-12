package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.numbers.IntegerUtils;

public class DevuVsPolice {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n1 = in.nextInt();
        int k1 = in.nextInt();
        int n2 = in.nextInt();
        int k2 = in.nextInt();
        int n = in.nextInt();
        out.println(IntegerUtils.power(IntegerUtils.power(n1, k1, n), IntegerUtils.power(n2, k2, IntegerUtils.phi(n)), n));
    }
}
