package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task23 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        List<Integer> abundant = new ArrayList<Integer>();
        int max = 28125;
        for(int i = 1; i <= max; ++i) {
            long sum = ListUtils.sum(IntegerUtils.getDivisors(i)) - i;
            if(sum > i)
                abundant.add(i);
        }
        Set<Integer> sums = new HashSet<Integer>();
        for (int x : abundant) {
            for (int y : abundant) {
                sums.add(x + y);
            }
        }

        long sum = 0;
        for(int i = 1; i <= max; ++i) {
            if(!sums.contains(i))
                sum += i;
        }
        out.println(sum);
    }
    
}
