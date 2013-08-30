package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class TaskC {
    private static final int MOD = 1000000007;
    int[] fact;
    long[] inv;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        fact = IntegerUtils.factorials(n, MOD);
        inv = new long[fact.length];
        for(int i = 0; i < fact.length; ++i) {
            inv[i] = IntegerUtils.modInverse(fact[i], MOD);
        }
        int[]a = in.nextIntArray(n);
        boolean[] positions = new boolean[n];
        boolean[] numbers = new boolean[n];
        int all = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] != -1) {
                numbers[a[i] - 1] = true;
                positions[i] = true;
                ++all;
            }

        }



        int same = 0;
        for(int i = 0; i < n; ++i) {
            if(numbers[i] && positions[i])
                ++same;
        }

        out.println(solve(n - same, all - same));
    }


    long[] memo = new long[2005 * 2005];

    private long solve(int n, int k) {
        int key = n * 2005 + k;
        if(memo[key] != 0)
            return memo[key];
        if(k == 0) {
            long ans = 0;
            int cur = 1;
            for(int i = 0; i <= n; ++i) {
                ans += fact[n] * inv[i] * cur;

                cur = -cur;
                ans %= MOD;
                if(ans < 0) {
                    ans += MOD;
                }
            }
            return memo[key] = ans;
        }
        int rest = n - 2 * k;

        if(rest < 0)
            throw new AssertionError();

        long ans = k * solve(n - 2, k - 1);
        if(rest != 0)
            ans += rest * solve(n - 1, k);
        ans %= MOD;
        return memo[key] = ans;
    }
}
