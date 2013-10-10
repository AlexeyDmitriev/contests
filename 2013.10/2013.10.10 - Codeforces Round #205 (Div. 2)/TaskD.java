package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.List;

public class TaskD {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        List<Integer> females = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'F')
                females.add(i);
        }

        int last = 0;

        for(int i = 0; i < females.size(); ++i) {
            if(females.get(i) == i)
                continue;
            last = Math.max(females.get(i) - i, last + 1);
        }

        out.println(last);


    }
}
