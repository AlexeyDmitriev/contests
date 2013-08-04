package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashSet;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        HashSet<Integer>[] answers = new HashSet[1 << 4];
        for(int i = 0; i < (1 << 4); ++i) {
            answers[i] = new HashSet<Integer>();
        }
        for(int i = 0; i < 4; ++i)
            answers[1 << i].add(in.nextInt());

        for(int mask = 1; mask < (1 << 4); ++mask) {
            for(int subMask = 1; subMask < mask; ++subMask) {
                if((mask & subMask) != subMask)
                    continue;

                int otherSubMask = mask - subMask;

                for (int a : answers[subMask]) {
                    for(int b: answers[otherSubMask]) {
                        answers[mask].add(a + b);
                        answers[mask].add(a * b);
                        answers[mask].add(a - b);


                        if(b != 0 && a % b == 0) {
                            answers[mask].add(a / b);
                        }
                    }
                }
            }
        }

        int bestAns = 100000000;

        for (int ans : answers[15]) {
            if(Math.abs(ans - 21) < Math.abs(bestAns - 21) || Math.abs(ans - 21) == Math.abs(bestAns - 21) && ans < bestAns) {
                bestAns = ans;
            }
        }

        out.println(bestAns);
    }
}
