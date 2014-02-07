package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int stacks = in.nextInt();
        int sum1 = 0, sum2 = 0;
        ArrayList<Integer> realGame = new ArrayList<Integer>();
        for(int i = 0; i < stacks; ++i) {
            int inGroup = in.nextInt();
            int[] group = in.nextIntArray(inGroup);
            for(int j = 0; j < inGroup / 2; ++j) {
                sum1 += group[j];
            }
            int start = inGroup / 2;
            if(inGroup % 2 == 1) {
                realGame.add(group[start]);
                ++start;
            }
            for(int j = start; j < inGroup; ++j) {
                sum2 += group[j];
            }
        }
        Collections.sort(realGame, Collections.reverseOrder());

        boolean first = true;
        for(int number: realGame) {
            if(first)
                sum1 += number;
            else
                sum2 += number;
            first = !first;
        }
        out.println(sum1 + " " + sum2);
    }
}
