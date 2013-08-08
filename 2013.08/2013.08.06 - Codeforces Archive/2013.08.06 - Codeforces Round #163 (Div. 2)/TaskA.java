package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        in.nextInt();
        String s = in.nextString();
        int answer = 0;
        for(int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == s.charAt(i - 1))
                ++answer;
        }
        out.println(answer);
    }
}
