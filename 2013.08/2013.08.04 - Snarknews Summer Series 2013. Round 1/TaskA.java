package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskA {
    class State {
        int id, cntV, cntW;

        State(int id, int cntV, int cntW) {
            this.id = id;
            this.cntV = cntV;
            this.cntW = cntW;
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        ArrayList<State> states = new ArrayList<State>(1000000);
        states.add(new State(0,0,0));
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.nextString();
        int sumV = 0;
        int sumW = 0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) == 'v')
                sumV++;
            else
                sumW++;

            if(states.size() - 1 - k >= 0) {
                State prevState = states.get(states.size() - 1 - k);
                if(prevState.cntV + k == sumV && prevState.cntW + 1 == sumW) {
                    answer.add(i + 1);
                    for(int j = 0; j < k; ++j) {
                        answer.add(states.get(states.size() - 1).id);
                        states.remove(states.size() - 1);
                    }
                    sumV = states.get(states.size() - 1).cntV;
                    sumW = states.get(states.size() - 1).cntW;
                    continue;
                }
            }
            states.add(new State(i + 1, sumV, sumW));
        }

        for(int i = 0, j = 0; i < answer.size(); ++i, ++j) {
            out.print(answer.get(answer.size() - 1 - i));
            if(j == k) {
                out.println();
                j -= k + 1;
            }
            else
                out.print(' ');
        }
    }
}
