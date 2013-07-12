package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class TaskC {
    private int mod = 1000000007;

    public void solve(int testNumber, Reader in, OutputWriter out) {
        String a = in.nextString();
        long n = in.nextInt();

        long answer = 0;

        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) == '0' || a.charAt(i) == '5') {
                answer += (IntegerUtils.power(2, n * a.length(), mod) - 1) * IntegerUtils.modInverse(IntegerUtils.power(2, a.length(), mod) - 1, mod) % mod * IntegerUtils.power(2, i, mod);
                answer %= mod;
            }
        }

        out.println(answer);
    }
}
