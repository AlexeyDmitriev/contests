package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.numbers.Rational;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        ArrayUtils.sort(a);

        long res = 0;
        long sum = 0;
        for(int i = 0; i < n; ++i) {
            res += 2 * (a[i] * 1L * i - sum);
            res += a[i];
            sum += a[i];
        }

        Rational ans = new Rational(res, n);
        out.println(ans.numerator + " " + ans.denominator);
    }
}
