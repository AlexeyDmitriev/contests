package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.math.BigInteger;

public class Labelmaker {

    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        long m = in.nextLong();
        out.print("Case #" + testNumber + ": ");
        for(int i = 1; ; ++i) {
            BigInteger all = BigInteger.valueOf(s.length()).pow(i);
            if(all.compareTo(BigInteger.valueOf(m)) < 0) {
                m -= all.longValue();
                continue;
            }
            String res = BigInteger.valueOf(m - 1).toString(s.length());
            //System.err.println(m + " " + res);
            for(int j = 0; j < i - res.length(); ++j) {
                out.print(s.charAt(0));
            }
            for (char c : res.toCharArray()) {
                if(c >= '0' && c <= '9')
                    out.print(s.charAt(c - '0'));
                else if(c >= 'a' && c <= 'z')
                    out.print(s.charAt(c - 'a' + 10));
                else if(c >= 'A' && c <= 'Z')
                    out.print(s.charAt(c - 'A' + 10));
            }
            out.println();
            return;
        }

    }
}
