package main;

import name.admitriev.spsl.collections.DefaultValueHashMap;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskE {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        DefaultValueHashMap<Integer, Integer> last = new DefaultValueHashMap<Integer, Integer>(-1);
        int answer = 0;
        int lastBad = -1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; ;++i) {
            int x = in.nextInt();
            if(x == 0){
                break;
            }
            list.add(x);
        }
        int start = 0;

        for(int i = 0; i < list.size(); ++i) {
            int x = list.get(i);
            int prev = last.get(x);
            lastBad = Math.max(lastBad, prev);
            if(i - lastBad > answer) {
                answer = Math.max(i - lastBad, answer);
                start = lastBad + 1;
            }
            last.put(x, i);
        }
        for(int i = start; i < start + answer; ++i) {
            out.print(list.get(i) + "\n");
        }
        //out.println(0);
    }
}
