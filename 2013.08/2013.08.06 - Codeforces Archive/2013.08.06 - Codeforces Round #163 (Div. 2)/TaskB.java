package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int t = in.nextInt();
        CharSequence s = in.nextString();

        for(int i = 0; i < t; ++i) {
            StringBuilder sb = new StringBuilder(s);
            for(int j = 0; j + 1< n; ++j) {
                if(s.charAt(j) == 'B' && s.charAt(j + 1) == 'G') {
                    sb.setCharAt(j, 'G');
                    sb.setCharAt(j + 1, 'B');
                }
            }
            s = sb;
        }

        out.println(s);


    }
}
