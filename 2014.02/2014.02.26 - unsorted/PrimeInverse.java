package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class PrimeInverse {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();

        int prev = n, next = n + 1;
        while(!IntegerUtils.isPrime(next))
            ++next;
        while (!IntegerUtils.isPrime(prev))
            --prev;
        long p = next;
        int k = next - n - 1;
        long ansc = (p - 2) * 1L * prev - k * 2;
        long ansz = 2 * p * prev;
        long g = IntegerUtils.gcd(ansc, ansz);
        out.println(ansc/g + "/" + ansz/g);
    }
}
