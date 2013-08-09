package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.numbers.IntegerUtils;

public class TaskD {
    int[] factorials;
    int mod = 1000000007;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int nulls = in.nextInt();
        int ones = in.nextInt();
        int res = in.nextInt();
        factorials = IntegerUtils.factorials(nulls + ones + 1, mod);
        if(ones == 0) {
            out.println(res == nulls % 2 ? 0 : 1);
            return;
        }
        long answer = 0;

        if(ones == 1) {
            answer += res == nulls % 2 ? 0 : 1;
        }
        for(int firstOne = res; nulls - firstOne >= 0; firstOne += 2) {
            int nullsRemaining = nulls - firstOne;
            int onesRemaining = ones - 1;

            if(nullsRemaining == 0 && onesRemaining == 0)
                continue;


            answer += c(nullsRemaining + onesRemaining, onesRemaining);
            answer %= mod;
        }

        out.println(answer);
    }

    private long c(int n, int k) {
        return factorials[n] * IntegerUtils.modInverse(factorials[k], mod) % mod * IntegerUtils.modInverse(factorials[n - k], mod) % mod;
    }
}
