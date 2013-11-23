package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class BdayGift {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long sum = 0;
        for (int i : in.nextIntArray(in.nextInt())) {
            sum += i;
        }
        out.println(sum / 2 + "." + (sum % 2 * 5));
    }
}
