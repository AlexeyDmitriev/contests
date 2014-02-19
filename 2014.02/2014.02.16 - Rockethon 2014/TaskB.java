package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        ArrayList<Integer>[] poses = new ArrayList[26];
        for(int i = 0; i < 26; ++i)
            poses[i] = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); ++i) {
            poses[s.charAt(i) - 'A'].add(i);
        }

        int ans = 0;

        for(int i = 0; i < 26; ++i) {
            for(int p = 0; p < poses[i].size(); ++p) {
                int last = poses[i].get(p);
                int curAns = 1;
                for(int cur = p + 1; cur < poses[i].size(); ++cur) {
                    if((last - poses[i].get(cur)) % 2 != 0) {
                        last = poses[i].get(cur);
                        ++curAns;
                    }
                }
                ans = Math.max(ans, curAns);
            }
        }

        out.println(ans);
    }
}
