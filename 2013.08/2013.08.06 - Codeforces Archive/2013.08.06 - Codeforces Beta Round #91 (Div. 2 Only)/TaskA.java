package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        Set<Integer> lucky = generateLuckyNumbers(n);
        for (int a : lucky) {
            if(n % a == 0) {
                out.println("YES");
                return;
            }
        }

        out.println("NO");

    }

    private Set<Integer> generateLuckyNumbers(int n) {
        Set<Integer> result = new HashSet<Integer>();
        result.add(4);
        result.add(7);
        int prevSize = 0;
        while (prevSize != result.size()) {
            prevSize = result.size();
            Set<Integer> next = new HashSet<Integer>();
            for (int a : result)
            {
                if(10 * a + 4 <= n) {
                    next.add(10 * a + 4);
                }
                if(10 * a + 7 <= n) {
                    next.add(10 * a + 7);
                }
            }

            result.addAll(next);

        }
        return result;
    }
}
