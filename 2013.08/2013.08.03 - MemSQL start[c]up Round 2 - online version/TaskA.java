package main;

import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.Map;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        int n = in.nextInt();
        Counter<Character> counter = new Counter<Character>();

        for(int i = 0; i < s.length(); ++i) {
            counter.add(s.charAt(i));
        }

        if(counter.size() > n){
            out.println(-1);
            return;
        }

        int l = 0;
        int r = 1111;
        while(r - l > 1) {
            int m = (l + r) / 2;
            int need = 0;
            for (Map.Entry<Character, Long> entry : counter.entrySet()) {
                long t = entry.getValue();
                need += (t + m - 1) / m;
            }
            if(need <= n) {
                r = m;
            }
            else
                l = m;
        }

        out.println(r);

        int m = r;
        int need = 0;
        for (Map.Entry<Character, Long> entry : counter.entrySet()) {
            long t = entry.getValue();
            long cur = (t + m - 1) / m;
            need += cur;

            for(long i = 0; i < cur; ++i){
                out.print(entry.getKey());
            }
        }

        for(int i = 0; i < n - need; ++i) {
            out.print('a');
        }
    }
}
