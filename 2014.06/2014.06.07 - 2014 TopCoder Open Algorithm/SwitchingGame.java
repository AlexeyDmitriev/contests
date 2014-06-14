package main;

import java.util.Arrays;

public class SwitchingGame {
    public int timeToWin(String[] states) {
        int n = states[0].length();
        char[] cur = new char[n];
        Arrays.fill(cur, '-');
        int ans = 0;
        for(int pos = 0; pos < states.length; ++pos) {
            String next = states[pos];
            boolean needOn = false;
            boolean needOff = false;
            for(int i = 0; i < n; ++i) {
                if(next.charAt(i) == '?')
                    continue;
                if(next.charAt(i) == cur[i])
                    continue;
                if(next.charAt(i) == '+')
                    needOn = true;
                else
                    needOff = true;
            }


            if(needOff)
               ans++;
            if(needOn)
                ans++;

            for(int i = 0; i < n; ++i) {
                char nextValue = '?';
                for(int j = pos; j < states.length && nextValue == '?'; ++j) {
                    nextValue = states[j].charAt(i);
                }
                if(nextValue == '?')
                    continue;
                if(nextValue == '+' && needOn)
                    cur[i] = '+';
                if(nextValue == '-' && needOff)
                    cur[i] = '-';
            }
        }
        return ans + states.length;

    }
}