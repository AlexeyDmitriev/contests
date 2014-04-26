package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class KFactorization {
    public static final int MOD = 1000000007;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int to = 32 * (n + 1);
        long[][] c = new long[to][n];
        for(int i = 0; i < to; ++i) {
            c[i][0] = 1;
            if(i < n)
                c[i][i] = 1;
            for(int j = 1; j < n && j < i; ++j) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }

        Counter<Integer> primes = new Counter<Integer>();

        for (int a : in.nextIntArray(n)) {
            for(int i = 2; i * i <= a; ++i) {
                while (a % i == 0){
                    primes.add(i);
                    a /= i;
                }
            }
            if(a > 1)
                primes.add(a);
        }

        long answer = 1;
        for (long a : primes.values()) {
            answer *= c[((int) (a + n - 1))][n - 1];
            answer %= MOD;
        }
        out.println(answer);
    }
}
