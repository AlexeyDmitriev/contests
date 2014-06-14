package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.math.BigInteger;

public class Factorials {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        BigInteger factorial = BigInteger.ONE;
        BigInteger ans = BigInteger.ONE;
        for(int i = 1; i <= n; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            ans = ans.add(factorial.pow(k));
        }
        while (ans.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO))
            ans = ans.divide(BigInteger.valueOf(10));
        out.println(ans.mod(BigInteger.valueOf(10)  ));
    }
}
