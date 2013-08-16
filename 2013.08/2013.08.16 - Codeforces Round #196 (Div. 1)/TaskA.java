package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.numbers.IntegerUtils;

public class TaskA {
    private static final long MOD = 1000000009;

    public void solve(int testNumber, Reader in, OutputWriter out) {
        long answer = 0;
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        long l = -1;
        long r = n + 1;

        while (l + 1 < r) {
            long c = (l + r) / 2;
            if(n < c * k || canAchieve(n - c * k, k) >= m - c * k) {
                r = c;
            }
            else
                l = c;
        }

        //out.println(r);

        long c = r;

        answer = ((IntegerUtils.power(2, c + 1, MOD) - 2 + MOD) % MOD) * k % MOD;

        n -= k * c;
        m -= k * c;
        answer += m;
        answer %= MOD;

        out.println(answer);
    }

    private long canAchieve(long n, long k) {
        return n - n / k;
    }
}
