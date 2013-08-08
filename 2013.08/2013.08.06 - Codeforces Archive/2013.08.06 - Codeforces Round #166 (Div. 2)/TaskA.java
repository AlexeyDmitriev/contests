package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        while (true) {
            ++n;
            if(allDistinct(n)) {
                out.println(n);
                return;
            }
        }

    }

    private boolean allDistinct(int n) {
        HashSet<Integer> digits = new HashSet<Integer>(n);
        String s = String.valueOf(n);
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits.size() == s.length();
    }
}
