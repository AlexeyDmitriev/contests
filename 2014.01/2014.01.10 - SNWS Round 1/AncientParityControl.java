package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class AncientParityControl {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        Counter<Character> counter = new Counter<Character>();
        for(int i = 0; i < s.length(); ++i) {
            counter.add(s.charAt(i));
            if(counter.get(s.charAt(i)) % 3 == 0) {
                if(i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                    out.println("FAKE");
                    return;
                }
                ++i;
            }
        }
        out.println("OK");
    }
}
