package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        char[] s = in.nextString().toCharArray();
        char[] t = in.nextString().toCharArray();
        
        for(int i = 0; i < s.length; ++i){
            if(s[i] == '6')
                s[i] = '9';
            if(s[i] == '2')
                s[i] = '5';
        }

        for(int i = 0; i < t.length; ++i){
            if(t[i] == '6')
                t[i] = '9';
            if(t[i] == '2')
                t[i] = '5';
        }

        int[] need = new int[10];
        int[] have = new int[10];
        for(int i = 0; i < s.length; ++i)
            need[s[i] - '0'] ++;

        for(int i = 0; i < t.length; ++i) {
            have[t[i] - '0']++;
        }

        int pos = Integer.MAX_VALUE;

        for(int i = 0; i < 10 ;++ i){
            if(need[i] > 0){
                pos = Math.min(pos, have[i] / need[i]);
            }
        }

        out.println(pos);

    }
}
