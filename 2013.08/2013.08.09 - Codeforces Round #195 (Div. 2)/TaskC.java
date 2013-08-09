package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashSet;
import java.util.Set;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        long[] a = in.nextLongArray(n);
        final long all = (1L<<50) - 1;
        for(int i = 33; i >= 0; --i) {

            long and = all;
            for (long l : a) {
                if((l & (1L << i)) != 0) {
                    and &= l;
                }
            }
            if(and == all) {
                continue;
            }

            if(and % (1L << i) != 0) {
                continue;
            }

            Set<Long> answer = new HashSet<Long>();

            for (long l : a) {
                if((l & (1L << i)) != 0) {
                    answer.add(l);
                }
            }

            out.println(answer.size());
            for (long l : answer) {
                out.print(l + " ");
            }
            return;
        }

        throw new AssertionError();
    }
}
